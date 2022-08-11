package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Artists {
    private String firstName;
    private String lastName;
    private List<String> listOfSongNames;
    private static long counter=0;
    private long id;

    private Date date;

    public Artists(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        counter++;
        this.id=counter;
        listOfSongNames = new ArrayList<>();
        date = new Date();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public void setListOfSongNames(Songs song) {
        this.listOfSongNames.add(song.getName());
    }

    public List<String> getListOfSongNames() {
        return listOfSongNames;
    }
    public void getArtistRegistrationDate(){
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Artist "+getName()+" Registered on Date: "+ ft.format(date));
    }
}
