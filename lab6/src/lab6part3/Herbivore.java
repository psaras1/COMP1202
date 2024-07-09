package lab6part3;


abstract class Herbivore extends Animal {
    public Herbivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) throws Exception {
        if (food instanceof Meat) {
            throw new Exception("Herbivores only eat plants");
        } else {
            System.out.println(this.getName() + "eats" + food.getName());
        }
    }
}
