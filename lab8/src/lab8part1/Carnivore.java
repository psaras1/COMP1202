package lab8part1;



abstract class Carnivore extends Animal {
  public Carnivore(String name, int age) {
    super(name, age);
  }

  public Carnivore() {
    super();
  }

  public void eat(Food food) throws Exception {
    if (food instanceof Plant) {
      throw new Exception("Carnivores only eat meat");
    } else {
      System.out.println(this.getName() + " eats " + food.getName());
    }
  }

  public void eat(Food food, int i) throws Exception {
    if (food instanceof Plant) {
      throw new Exception("Carnivores only eat meat");
    } else {
      for (int j = 0; j < i; j++) {
        System.out.println(this.getName() + " eats " + food.getName());
      }
    }
  }
}
