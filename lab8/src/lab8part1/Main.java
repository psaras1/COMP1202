package lab8part1;

public class Main {
  public static void main(String[] args) {
    Wolf myWolf = new Wolf("John", 41);
    Meat myMeat = new Meat("Beef");

    try {
      myWolf.eat(myMeat, 5);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    System.out.println();

    Parrot myParrot = new Parrot(5);
    System.out.println(myParrot.getName());
    Wolf newWolf = new Wolf();
    System.out.println(newWolf.getName() + " " + newWolf.getAge());
    System.out.println();
  }
}
