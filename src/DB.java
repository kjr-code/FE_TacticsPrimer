import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

//TODO: THIS CODE IS NOT DRY, GENERALIZE THIS BEHAVIOR

public class DB {
    
    public static HashMap<String, Character> characters = new HashMap<String, Character>();
    public static HashMap<String, BaseClass> baseClasses = new HashMap<String, BaseClass>();
    public static HashMap<String, UnitClass> promotedClasses = new HashMap<String, UnitClass>();
    public static HashMap<String, Skill> skills = new HashMap<String, Skill>();

    public static void loadData() throws Exception{
        try{
            //read in skills first such that they can be added to classes
            File skillFile = new File(Constants.skillsFile);
            Scanner skillFileScanner = new Scanner(skillFile);
            while(skillFileScanner.hasNextLine()){
                //read in the skills and such
                String nextSkill = skillFileScanner.nextLine();
                String[] split = nextSkill.split("&");
                Skill newSkill = new Skill(split[0], split[1]);
                skills.put(newSkill.getName(), newSkill);
                //TODO: the third index in split[] is the skill's "id"/file name
            }
            skillFileScanner.close();

            File promotedClassesFile = new File(Constants.promotedClassesFile);
            Scanner promotedClassesFileScanner = new Scanner(promotedClassesFile);
            while(promotedClassesFileScanner.hasNextLine()){
                String nextClass = promotedClassesFileScanner.nextLine();
                String[] outerSplit = nextClass.split("^");
                String[] nameAndDesc = outerSplit[0].split("&");
                UnitClass newClass = new UnitClass(nameAndDesc[0], nameAndDesc[1]);
                promotedClasses.put(nameAndDesc[0], newClass);

                String[] growthRates = outerSplit[1].split("&");
                //TODO make this a method.
                int[] parsedRates = new int[8];
                for(int i = 0; i < growthRates.length; i++){
                    parsedRates[i] = Integer.parseInt(growthRates[i]);
                }
                Growths newGrowths = new Growths(parsedRates);
                promotedClasses.put(nameAndDesc[0], newClass);
            }
            promotedClassesFileScanner.close();


            File baseClassesFile = new File(Constants.baseClassesFile);
            Scanner baseClassesFileScanner = new Scanner(baseClassesFile);
            while(baseClassesFileScanner.hasNextLine()){
                String nextClassData = baseClassesFileScanner.nextLine();
                String[] outerSplit = nextClassData.split("^");
                String[] nameAndDesc = outerSplit[0].split("&");
                BaseClass newClass = new BaseClass(nameAndDesc[0], nameAndDesc[1]);
                baseClasses.put(nameAndDesc[0], newClass);

                //TODO: this feels a bit dodgy
                String[] growthRates = outerSplit[1].split("&");
                int[] parsedRates = new int[8];
                for(int i = 0; i < growthRates.length; i++){
                    parsedRates[i] = Integer.parseInt(growthRates[i]);
                }
                Growths newGrowths = new Growths(parsedRates);
                baseClasses.get(nameAndDesc[0]).setGrowths(newGrowths);

                String[] promotionBranches = outerSplit[2].split("&");
                //TODO aren't "foreach" loops technically suboptimal or something?
                for(String newBranch : promotionBranches){
                    baseClasses.get(nameAndDesc[0]).addPromotedClass(newBranch);
                }
            }
            baseClassesFileScanner.close();


            //read in characters last so that all dependencies are already filled and we don't have to loop 
            //back through the char hashmap multiple times.
            File charFile  = new File(Constants.charNameAndGrowthsFile);
            Scanner charFileScanner = new Scanner(charFile);
            while(charFileScanner.hasNextLine()){
                String nextChar = charFileScanner.nextLine();
                String[] split = nextChar.split(",");
                Character newChar = new Character(split);
                characters.put(newChar.name, newChar);
            }
            charFileScanner.close();

            File spritesDir = new File(Constants.mapSpritesFolder);
            File[] mapSprites = spritesDir.listFiles();
            for(final File mFile : mapSprites){
                String fName = mFile.getName();
                int dotPos = fName.lastIndexOf(".");
                fName = fName.substring(0, dotPos);
                //mapSpritesHash.put(fName, mFile);
                characters.get(fName).setMapSpriteFile(mFile);
            }

            //loop through the portraits folder and the mapsprites folder and assign the appropriate images to their
            //respective characters (int the charHash)

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
