package lab8part2;

abstract class Herbivore extends Animal {
  public Herbivore(String name, int age) {
    super(name, age);
  }

  public void eat(Food food) throws Exception {
    if (food instanceof Meat) {
      throw new Exception("Herbivores only eat plants");
    } else {
      System.out.println(this.getName() + " eats " + food.getName());
    }
  }

  public void eat(Food food, int i) throws Exception {
    if (food instanceof Meat) {
      throw new Exception("Herbivores only eat plants");
    } else {
      for (int j = 0; j < i; j++) {
        System.out.println(this.getName() + " eats " + food.getName());
      }
    }
  }
}
