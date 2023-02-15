import javafx.event.ActionEvent;
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;  

public class Song extends Application {
    String name;
    String artist;
    String album;
    int year;

    public Song(String name, String artist, String album, int year){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }


    static void songDetail(Song song){
        System.out.println(song.name);
        System.out.println(song.artist);
        System.out.println(song.album);
        System.out.println(song.year);
    }

    static Song addSong(String name, String artist, String album, int year){
        //check if song with the same name & artist already exist, if not, create new song
        Song newSong = new Song(name, artist, album, year);
        //add song to the text file will all songs

        
        return newSong;
    }

    public void start(Stage stage) {      
        
        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();    
        
        //Setting size for the pane 
        gridPane.setMinSize(400, 200); 
        
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER); 

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
         
       
    }


    public static void main(String[] args){
        Song song = new Song("Song", "artist1", "alb", 1994);
        
        Application.launch(args);
        
    }
}