import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class DataGrabber {

    //TODO using a DBMS would allow for these structures to be replaced by a single, logical, persistent data object type
    //public static ArrayList<Character> charDB = new ArrayList<Character>();
    public static HashMap<String, Character> charHM = new HashMap<String, Character>();
    public static HashMap<String, File> mapSpritesHash = new HashMap<String, File>();
    public static HashMap<String, File> portraitsHash = new HashMap<String, File>();
    public static HashMap<String, UnitClass> classHash = new HashMap<String, UnitClass>();
    
    public static void getData() throws FileNotFoundException{
        String dbFile = "src\\Fates.csv";
        String skillsDBFile = "src\\Skillsand.txt";
        String classesDBFile = "src\\Classesand.txt";
        String mapSpritesFolder =  "src\\Images\\MapSprites";
        String portraitsFolder = "src\\Images\\Portraits";

        try{
            File file = new File(dbFile);
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String nextUnit = fileScanner.nextLine();
                String[] unitData = nextUnit.split(",");
                Character thisChar = new Character(unitData);
                charHM.put(thisChar.name, thisChar);
            }
            //System.out.println("charDB size: "+charHM.size()+" entries");
            fileScanner.close();

            File spritesDir = new File(mapSpritesFolder);
            File[] mapSprites = spritesDir.listFiles();
            for(final File mFile : mapSprites){
                String fName = mFile.getName();
                int dotPos = fName.lastIndexOf(".");
                fName = fName.substring(0, dotPos);
                mapSpritesHash.put(fName, mFile);
                //System.out.println("Just put "+fName+" in the map sprites hash.");
            }

            File portraitsDir = new File(portraitsFolder);
            File[] portraits = portraitsDir.listFiles();
            for(final File mFile : portraits){
                String fName = mFile.getName();
                int dotPos = fName.lastIndexOf(".");
                fName = fName.substring(0, dotPos);
                portraitsHash.put(fName, mFile);
                //System.out.println("Just put "+fName+" in the Portraits hash.");
            }

            //unit classes
            File classesFile = new File(classesDBFile);
            Scanner classScanner = new Scanner(classesFile);
            while(classScanner.hasNextLine()){
                String nextClass = classScanner.nextLine();
                String[] classData = nextClass.split("&");
                //risky business and sloppy code right here
                UnitClass thisClass = new UnitClass(classData[0], classData[1]);
                classHash.put(classData[0], thisClass);
            }
            classScanner.close();

            //skills
            File skillsFile = new File(skillsDBFile);
            Scanner skillScanner = new Scanner(skillsFile);
            while(skillScanner.hasNextLine()){
                String nextSkill = skillScanner.nextLine();
                String[] skillData = nextSkill.split("&");
                Skill thisSkill = new Skill(skillData[0], skillData[1]);
                //TODO needs to make class dictionary first, so the skills have somewhere to "live"
                String assocClass = skillData[2];
                if(classHash.get(assocClass) != null){
                    classHash.get(assocClass).addSkill(thisSkill);
                } else {
                    System.out.println("HEY! WARNING! Can't find the "+skillData[2]+" class that the skill "+skillData[0]+" is supposed to go with");
                }
            }
            

        } catch(FileNotFoundException e) {
            System.out.println("_dattaGrabber can't find the file it's looking for!");
            System.out.println("While looking for: unit data");
            //e.printStackTrace();
        }
    }
}
