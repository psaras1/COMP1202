package lab8part3;

abstract class Transport {
  String name;
  float fuel;

  public Transport(String name, float fuel) {
    this.name = name;
    this.fuel = fuel;
  }

  public Transport(String name) {
    this.name = name;
  }
}
