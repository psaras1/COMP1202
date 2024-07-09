package lab8part3;

public class Train extends Transport implements Refuelable {
  public Train(String name, float fuel) {
    super(name, fuel);
  }

  public void getFuel() {}

  public void refuel() {}

  public void costToRefuel() {}
}
