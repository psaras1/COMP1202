package lab8part2;

public class Elephant extends Herbivore {

  public Elephant(String name, int age) {
    super(name, age);
  }

  public void makeNoise() {
    System.out.println("The elephant says: hello");
  }
}
