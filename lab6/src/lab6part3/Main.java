package lab6part3;

public class Main {
    public static void main(String[] args) {
        Wolf myWolf = new Wolf("John", 2);
        Parrot myParrot = new Parrot("Katy", 5);
        System.out.println(myWolf.getName());
        System.out.println(myParrot.getAge());

        Meat myMeat = new Meat("Beef");
        Plant myPlant = new Plant("Carrot");

        myWolf.makeNoise();
        myParrot.makeNoise();

        Elephant myElephant = new Elephant("bibo", 45);
        myElephant.makeNoise();

        try {
            myElephant.eat(myMeat);
            myWolf.eat(myPlant);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
