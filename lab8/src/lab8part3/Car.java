package lab8part3;

public class Car extends Transport implements Refuelable {
  public Car(String name, float fuel) {
    super(name, fuel);
  }

  public void getFuel() {}

  public void refuel() {}

  public void costToRefuel() {}
}
