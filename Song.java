//Abriel Hernandez
//

public class Song extends Songlib {
    String name;
    String artist;
    String album;
    String year;

    

    public Song(String name, String artist, String album, String year){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }

    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.album = " ";
        this.year = " ";
    }

   
}