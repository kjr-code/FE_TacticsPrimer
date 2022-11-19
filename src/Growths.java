public class Growths {

    //java be like "what's a struct?"
    //TODO: use a dictionary here 
    public int HPGrowth;
    public int STRGrowth;
    public int MAGGrowth;
    public int SKLGrowth;
    public int SPDGrowth;
    public int LCKGrowth;
    public int DEFGrowth;
    public int RESGrowth;
    
    public Growths(int[] input){
        //ugly implementation for MVP
        HPGrowth = input[0];
        STRGrowth = input[1];
        MAGGrowth = input[2];
        SKLGrowth = input[3];
        SPDGrowth = input[4];
        LCKGrowth = input[5];
        DEFGrowth = input[6];
        RESGrowth = input[7];
        //just pretend there's input validation here 
    }

    //GETTERS and SETTERS for PropertyValueFactory, since making the fields public wasn't enough
    public int getHPGrowth(){
        return HPGrowth;
    }

    public void setHPGrowth(int arg){
        HPGrowth = arg;
    }

    public int getSTRGrowth(){
        return STRGrowth;
    }

    public void setSTRGrowth(int arg){
        STRGrowth = arg;
    }

    public int getMAGGrowth(){
        return MAGGrowth;
    }

    public void setMAGGrowth(int arg){
        MAGGrowth = arg;
    }

    public int getSKLGrowth(){
        return SKLGrowth;
    }

    public void setSKLGrowth(int arg){
        SKLGrowth = arg;
    }

    public int getSPDGrowth(){
        return SPDGrowth;
    }

    public void setSPDGrowth(int arg){
        SPDGrowth = arg;
    }

    public int getLCKGrowth(){
        return LCKGrowth;
    }

    public void setLCKGrowth(int arg){
        LCKGrowth = arg;
    }

    public int getDEFGrowth(){
        return DEFGrowth;
    }

    public void setDEFGrowth(int arg){
        DEFGrowth = arg;
    }

    public int getRESGrowth(){
        return RESGrowth;
    }

    public void setRESGrowth(int arg){
        RESGrowth = arg;
    }
}
