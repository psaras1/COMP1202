package lab3part3;

public class CardLock {
    boolean unlocked = false;
    boolean studentAccess;
    SmartCard lastCard;
    public void swipeCard(SmartCard card) {
        lastCard = card;
        if(studentAccess){
            unlocked=true;
        }
        else if(lastCard.isStaff()){
            unlocked=true;
        }
        else{
            unlocked=false;
        }
    }
    public boolean isUnlocked(){
        if (studentAccess) {
            System.out.println("Students allowed");
        }
        else{
            System.out.println("Students not allowed");
        }
        return unlocked;
    }

    public void toggleStudentAccess(){
        studentAccess = !studentAccess;
    }

    public SmartCard getLastCardSeen(){return lastCard;}

    public static void main(String[] args){
        SmartCard card=new SmartCard("Dr. Bob Lecturer");
        CardLock lock = new CardLock();
        lock.toggleStudentAccess();
        lock.toggleStudentAccess();
        //System.out.println(lock.swipeCard(card));


    }

}
