import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DataGrabber {

    public static ArrayList<Character> charDB = new ArrayList<Character>();
    
    public static void getData(String gameName) throws FileNotFoundException{
        String fileName = "";
        switch(gameName){
            case "Fates":
                fileName = "Fates.csv";
                break;
            case "Awakening":
                fileName = "Awakening.csv";
                break;
            default:
                fileName = "";
                break;
        }

        try{
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String nextUnit = fileScanner.nextLine();
                String[] unitData = nextUnit.split(",");
                //TODO may run into error if charData cannot be parsed fully
                Character thisChar = new Character(unitData);
                charDB.add(thisChar);
            }
            fileScanner.close();
        } catch(FileNotFoundException e) {
            System.out.println("_dattaGrabber can't find the file it's looking for!");
            e.printStackTrace();
        }
    }
}
