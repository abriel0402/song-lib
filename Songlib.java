//Abriel Hernandez
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Songlib {
    
    static void sort(){
        // puts all lines into an arraylist
        // sorts array
        // loop thru arraylist to display song names in alphabetical order
        String line;
        ArrayList<String> lines = new ArrayList<String>();

        try{
            FileReader fReader = new FileReader("songs.txt");
            BufferedReader bReader = new BufferedReader(fReader);
        
            while((line = bReader.readLine()) != null){
                lines.add(line);
            }
            Collections.sort(lines);
            
            for(int i=0; i < lines.size(); i++){
                
                System.out.println(lines.get(i));
            }
            bReader.close();
            fReader.close();

        } catch (Exception exception){
            System.out.println("error");
        }
    }

    static void addSong(Song song){
        Boolean SongAlreadyExists = false;
        int count = 0;

        // variable is to compare if song already exists char by char up to artist
        String lineToAdd = "NAME:" + song.name + "|ARTIST:" + song.artist;
        
        try {
            FileReader fReader = new FileReader("songs.txt");
            BufferedReader bReader = new BufferedReader(fReader);
            String line;             

            while((line = bReader.readLine()) != null){
                count = 0;
                for (int i=0; i < lineToAdd.length(); i++){

                    if (line.charAt(i) == lineToAdd.charAt(i)){
                        count += 1;
                    }
                }
                if (count == lineToAdd.length()){
                    SongAlreadyExists = true;
                }
            }
            bReader.close();
            fReader.close();

        } catch (IOException exception){
            System.out.println("file not found");
        }

        //add song to the text file with all songs if song doesnt exist        
        if (! (SongAlreadyExists)){
            try {
                FileWriter fileWriter = new FileWriter("songs.txt", true);
                fileWriter.write("NAME:" + song.name + "|ARTIST:" + song.artist + "|ALBUM:" + song.album + "|YEAR:" + song.year + "|\n");
                fileWriter.close();
                System.out.println("Added song");
            } catch (Exception exception){
                System.out.println("error");
            }
        }
        sort();
    }


    static void editSong(Song song){
        String songLine = "NAME:" + song.name + "|ARTIST:" + song.artist + "|ALBUM:" + song.album + "|YEAR:" + song.year + "|";
        try {
            FileReader fReader = new FileReader("songs.txt");
            BufferedReader bReader = new BufferedReader(fReader);
            String line;    
            File temp = new File("temp.txt");
            FileWriter fileWriter = new FileWriter("temp.txt", true);         

            while((line = bReader.readLine()) != null){
                if (!(line.equals(songLine))){
                    fileWriter.write(line + "\n");
                }
            }
            

            //create new song object with edited data
            //write song object into file, example:
            //Song editedSong = new Song(editedName, editedArtist, editedAlbum, editedYear);
            //fileWriter.write("NAME:" + editedSong.name + "|ARTIST:" + editedSong.artist + etc.)

            

            bReader.close();
            fReader.close();
            fileWriter.close();

            File songsFile = new File("songs.txt");
            songsFile.delete();
            temp.renameTo(songsFile);


        } catch (Exception exception){
            System.out.println("error");
        }
        sort();
    }


 
    static void deleteSong(Song song){
        String songLine = "NAME:" + song.name + "|ARTIST:" + song.artist + "|ALBUM:" + song.album + "|YEAR:" + song.year + "|";
        
        try {
            FileReader fReader = new FileReader("songs.txt");
            BufferedReader bReader = new BufferedReader(fReader);
            File temp = new File("temp.txt");
            FileWriter fileWriter = new FileWriter("temp.txt", true);
            String line;      
            
            while((line = bReader.readLine()) != null){
                if(!(line.equals(songLine))){
                    fileWriter.write(line + "\n");
                }
            }
            fileWriter.close();
            bReader.close();
            fReader.close();

            File songsFile = new File("songs.txt");
            songsFile.delete();
            temp.renameTo(songsFile);

        } catch (Exception exception){
            System.out.println("error");
        }
        sort();
    }

    

    public static void main(String[] args){
        Song song = new Song("AAaaaa", "TestArtist", "NewTest", "NewTest");
        Song otherSong = new Song("New", "Drake");
        Song song2 = new Song("New", "TestArtist", "NewTest", "NewTest");
        
        addSong(otherSong);

        sort();
       
    
}
}