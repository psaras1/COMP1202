package lab8part2;

import java.util.ArrayList;
import java.util.Collections;

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

    Wolf firstWolf = new Wolf("John",15);
    Wolf secondWolf = new Wolf();
    Parrot firstParrot = new Parrot("Wick",7);
    Elephant firstElephant = new Elephant("Tumbo",13);

    ArrayList<Animal> animals = new ArrayList<>();

    animals.add(firstWolf);
    animals.add(secondWolf);
    animals.add(firstElephant);
    animals.add(firstParrot);

    for(Animal i:animals){
      System.out.println("Name:"+i.getName()+" Age:"+i.getAge());
    }
    System.out.println();

    Collections.sort(animals);

    for(Animal i:animals){
      System.out.println("Name:"+i.getName()+" Age:"+i.getAge());
    }

    /*
    To sort the animals from largest age to smallest, we have to
    change the definition of the comparable to return 1 when
    this.getAge() < i.getAge() instead of the other way around.
     */



  }

}
