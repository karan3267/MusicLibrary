package dao;

import Entities.Artists;
import Entities.Songs;
import Entities.Users;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Long, Users> users;
    private Map<Long, Artists> artists;
    private Map<Long, Songs> songs;

    public Inventory() {
        this.users = new HashMap<>();
        this.artists = new HashMap<>();
        this.songs = new HashMap<>();
    }

    public void addUser(Users user){
        users.put(user.getId(), user);
    }
    public void addArtist(Artists artist){
        artists.put(artist.getId(), artist);
    }
    public void addSong(Songs song){
        songs.put(song.getId(), song);
    }
    public Users getUserById(long userId){
        return users.get(userId);
    }

    public Artists getArtistById(long artistId){
        return artists.get(artistId);
    }

    public Songs getSongById(long songId){
        return songs.get(songId);
    }
}
