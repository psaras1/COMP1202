package lab8part2;

abstract class Omnivore extends Animal {
  public Omnivore(String name, int age) {
    super(name, age);
  }

  public void eat(Food food) {
    System.out.println(this.getName() + " eats " + food.getName());
  }

  public void eat(Food food, int i) throws Exception {
    for (int j = 0; j < i; j++) {
      System.out.println(this.getName() + " eats " + food.getName());
    }
  }
}
