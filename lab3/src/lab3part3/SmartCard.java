package lab3part3;

public class SmartCard {
    String name;
    boolean staff;
    public SmartCard (String owner){
        name=owner;
        staff=false;
    }
    public String getOwner(){
        return name;
    }
    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean value){
        staff=value;
    }

}
