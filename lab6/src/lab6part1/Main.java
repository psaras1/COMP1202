package lab6part1;

public class Main {
    public static void main(String[] args){
        Wolf myWolf = new Wolf("John",2);
        Parrot myParrot = new Parrot("Katy",5);
        System.out.println(myWolf.getName());
        System.out.println(myParrot.getAge());

        Meat myMeat = new Meat("Beef");
        Plant myPlant = new Plant("Carrot");
    }
}
