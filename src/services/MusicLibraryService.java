package services;

import Entities.*;
import dao.Inventory;

import java.util.*;

public class MusicLibraryService {
    long currentUserPlayCount =0;
    private Inventory inventory;
    public MusicLibraryService(){
        this.inventory=new Inventory();
    }

    private Map<Long, Long> songPlayCounts = new HashMap<>();


    private Map<Long, Map<Long, Long>> userPlayHistory = new HashMap<>();
    public void registerUser(String firstName, String lastName, String emailId, long phone,
                             String city, String locality, String state, int pinCode){
        Contact contact = new Contact(emailId,phone);
        Address address = new Address(city,locality,state,pinCode);
        Users user = new Users(firstName,lastName,address,contact);
        inventory.addUser(user);
        System.out.println("Registered User with UsedId:"+user.getId()+", name:"+user.getName());
    }
    public void registerArtist(String firstName, String lastName){

        Artists artist = new Artists(firstName,lastName);
        inventory.addArtist(artist);
        System.out.println("Registered Artist with ArtistId:"+artist.getId()+", name:"+artist.getName());
    }

    public void releaseSong(String songTitle, String genre, int releaseYear,String language,long artistId){
        Artists artist = inventory.getArtistById(artistId);
        if(artist==null){
            System.out.println("Artist is not Registered");
        }else{
            Songs song = new Songs(songTitle,genre,releaseYear,language,artistId);
            inventory.addSong(song);
            artist.setListOfSongNames(song);
            System.out.println("Song Released with songId: "+song.getId()+", songTitle:"+song.getName());
        }
    }
    Map <Long,Long> userPlayCount=new HashMap<>();
    public void playASong(long userId,long songId){
        Songs song = inventory.getSongById(songId);
        Users user = inventory.getUserById(userId);
        song.markPlayed();
        Artists artists = inventory.getArtistById(song.getArtistId());
        if(song == null){
            System.out.println("Song with Id "+songId+" is not Released");
        }else if(user==null){
            System.out.println("User with Id: " + userId+" Not Registered");
        }else{
            System.out.println(user.getName()+" Listened to the song "+ song.getName()+" By "+inventory.getArtistById(song.getArtistId()).getName());

            try {
                if(!userPlayCount.containsValue(songId)){
                    userPlayCount.put(songId,0l);
                }
                userPlayCount.put(songId,1+userPlayCount.get(songId));
                userPlayHistory.put(userId,userPlayCount);
            if(songPlayCounts.get(songId)==null){
                songPlayCounts.put(songId,0l);
            }
            songPlayCounts.put(songId,1+songPlayCounts.get(songId));
            }catch (Exception e){

            }
        }
    }

    public void getListOfSongsOfArtist(long artistId){
        Artists artist= inventory.getArtistById(artistId);
        if(artist==null){
            System.out.println("Artist is not Registered");
        }else{
            List <String> s= artist.getListOfSongNames();
            for(String g:s ){
                System.out.println(g);
            }
            }
        }
    public List<Map.Entry<Long, Long>> getTopNSongs(Map<Long,Long> map,Integer n){
        List<Map.Entry<Long,Long>> list = new LinkedList<Map.Entry<Long,Long>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Long,Long>>(){
            public int compare(Map.Entry<Long,Long> a1,Map.Entry<Long,Long> a2){
                return (int)(a1.getValue()- a2.getValue());
            }
        });
        return list.subList(0,(int)Math.min(n,list.size()));
    }

    public void getTop10SongsOverAll(){
        getTopNSongs(songPlayCounts,10).forEach(entry -> {
            System.out.println("Song: "+inventory.getSongById(entry.getKey()).getName()+
                    ", played : "+ entry.getValue() +" times.");
        });

    }

    public void getTop10SongsForUSer(Long userId){
        Map<Long,Long> userPlayMap= userPlayHistory.get(userId);
       getTopNSongs(userPlayMap,10).forEach(entry-> {
            System.out.println("Song: "+inventory.getSongById(entry.getKey()).getName()+
                    ", played : "+ entry.getValue() +" times.");
        });
    }

}
