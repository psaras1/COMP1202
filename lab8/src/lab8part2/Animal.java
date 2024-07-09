package lab8part2;

abstract class Animal implements Comparable<Animal> {
  public int compareTo(Animal i) {
    if (this.getAge() == i.getAge()) return 0;
    else if (this.getAge() > i.getAge()) return 1;
    else return -1;
  }

  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Animal() {
    this("newborn", 0);
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public abstract void makeNoise();

  public abstract void eat(Food food) throws Exception;

  public abstract void eat(Food food, int times) throws Exception;
}
