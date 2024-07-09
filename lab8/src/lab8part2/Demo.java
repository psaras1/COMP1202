package lab8part2;

import java.util.ArrayList;

public class Demo {
  /*
  An interface acts as a blueprint in java. Any classes that implement
  and interface must provide definitions for the methods defined in the interface.
  This forces all classes that implement the interface to have the required methods.

  An abstract class is usually used as a superclass/base class and is used
  in a similar manner as an interface. However, abstract classes can also have instance
  variables/constructors and interfaces can not.

  A class can implement many interfaces, however it can only extend one abstract class.

  Choice between the two depends on the use case.
  */


  public static void main(String[]args){
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
  }
}
