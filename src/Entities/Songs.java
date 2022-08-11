package Entities;

public class Songs {
    private String title;
    private String genre;
    private int releaseYear;
    private String language;

    private long artistId;
    private long totalListens;
    private static long counter=0;
    private final long id;

    public Songs(String title, String genre, int releaseYear, String language,long artistId) {
        this.artistId=artistId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.language = language;
        counter++;
        this.id=counter;
        totalListens=0;
    }

    public long getId() {
        return id;
    }

    public long getArtistId(){
        return artistId;
    }

    public String getName() {
        return title;
    }

    public void markPlayed(){
        totalListens++;
    }

    public long getTotalListens(){return totalListens;}

}
