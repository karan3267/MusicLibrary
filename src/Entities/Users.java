package Entities;

import Entities.Address;
import Entities.Contact;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Users {
    private String firsName;
    private String lastName;
    private Address address;
    private Contact contact;
    private final long id;

    private Date date;
    private static long counter =0;

    public Users(String firsName, String lastName, Address address, Contact contact) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        counter++;
        this.id=counter;
        date = new Date();
    }

    public void getArtistRegistrationDate(){
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Artist "+getName()+" Registered on Date: "+ ft.format(date));
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return firsName+" "+lastName;
    }
}


