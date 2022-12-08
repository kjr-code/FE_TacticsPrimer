import javafx.scene.image.Image;

public class Skill {

    private String name;
    private String desc;
    public Image icon;

    //TODO skills don't have to point back to the class they're from (at least not now)

    public Skill(String _name, String _desc){
        name = _name;
        desc = _desc;
    }
    public Skill(String _name, String _desc, Image _icon){
        name = _name;
        desc = _desc;
        icon = _icon;
    }

    public String getName(){
        return name;
    }

    public void setName(String arg){
        name = arg;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String arg){
        desc = arg;
    }

    public Image getIcon(){
        return icon;
    }

    public void setIcon(Image arg){
        icon = arg;
    }
}
