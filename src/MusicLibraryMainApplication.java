import Entities.Artists;
import services.MusicLibraryService;

import java.util.Scanner;

public class MusicLibraryMainApplication {
    static String yn;
    public static void main(String[] args) {
        MusicLibraryService service = new MusicLibraryService();
        Scanner sc = new Scanner(System.in);

        int i=0;
        while (i!=9){
            System.out.println("-------------------------------");
            System.out.println("Choose an Option From Below");
            System.out.println("1. Register a User");
            System.out.println("2. Register an Artist");
            System.out.println("3. Release a Song");
            System.out.println("4. Play a Song");
            System.out.println("5. Get List of Songs of Specific Artist");
            System.out.println("6. Get Top 10 Songs For Specific User");
            System.out.println("7. Get Top 10 Songs Global");
            System.out.println("9. Quit the app");
            i=sc.nextInt();
            switch(i){
                case 1:
                    registerUser(sc, service);
                    break;
                case 2:
                    registerArtist(sc, service);
                    break;
                case 3:
                    releaseSong(sc,service);
                    break;
                case 4:
                    playASong(sc,service);
                    break;
                case 5:
                    getListOfSongsOfArtist(sc,service);
                    break;
                case 6:
                    getTop10SongsForUSer(sc,service);
                    break;
                case 7:
                    getTop10SongsOverAll(service);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Enter a Valid Option");
            }

        }

    }

    private static void getTop10SongsOverAll(MusicLibraryService service) {
        service.getTop10SongsOverAll();
    }

    private static void getTop10SongsForUSer(Scanner sc, MusicLibraryService service) {
        System.out.println("Enter User Id:");
        long userId= sc.nextLong();
        service.getTop10SongsForUSer(userId);
    }

    private static void getListOfSongsOfArtist(Scanner sc, MusicLibraryService service) {
        System.out.println("Enter Artist Id");
        long artistId=sc.nextLong();
        service.getListOfSongsOfArtist(artistId);
    }

    private static void playASong(Scanner sc, MusicLibraryService service) {

        do {
            System.out.println("Enter User Id");
            Long userId = sc.nextLong();
            System.out.println("Enter Song Id");
            Long songId = sc.nextLong();
            service.playASong(userId, songId);
            System.out.println("Do You Want To Play Another Song? (Y/N)");
            yn = sc.next();
        } while (yn.equals("Y"));
    }


    private static void releaseSong(Scanner sc, MusicLibraryService service) {
        do{
            System.out.println("Enter the Song Title:");
            String songTitle = sc.next();
            System.out.println("Enter Song Genre:");
            String songGenre = sc.next();
            System.out.println("Enter Release Year:");
            int releaseYear = sc.nextInt();
            System.out.println("Enter Song Language:");
            String language = sc.next();
            System.out.println("Enter Artist ID");
            Long artistId = sc.nextLong();
            service.releaseSong(songTitle,songGenre,releaseYear,language,artistId);
            System.out.println("Do You Want To Release Another Song? (Y/N)");
            yn = sc.next();
        }while(yn.equals("Y"));
    }

    private static void registerArtist(Scanner sc, MusicLibraryService service) {
       do{
           System.out.println("Enter the First Name of the Artist");
           String firstName = sc.next();
           System.out.println("Enter the Last Name of the Artist");
           String lastName = sc.next();
           service.registerArtist(firstName,lastName);
           System.out.println("Would you Like To Register Another Artist? (Y/N)");
           yn = sc.next();
       }while(yn.equals("Y"));
    }

    public static void registerUser(Scanner sc, MusicLibraryService service){
        do{
            System.out.println("Enter the First Name of the User");
            String firstName = sc.next();
            System.out.println("Enter the Last Name of the User");
            String lastName = sc.next();
            System.out.println("Enter Email Id:");
            String emailId=sc.next();
            System.out.println("Enter Phone Number:");
            long phone = sc.nextLong();
            System.out.println("Enter the City:");
            String city=sc.next();
            System.out.println("Enter Locality:");
            String locality = sc.next();
            System.out.println("Enter State:");
            String state = sc.next();
            System.out.println("Enter Pincode:");
            int pinCode = sc.nextInt();
            service.registerUser(firstName,lastName,emailId,phone,city,locality,state,pinCode);
            System.out.println("Would you Like To Register Another User? (Y/N)");
            yn = sc.next();
        }while(yn.equals("Y"));
    }
}
