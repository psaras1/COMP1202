package lab6part3;



abstract class Carnivore extends Animal {
    public Carnivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) throws Exception {
        if (food instanceof Plant) {
            throw new Exception("Carnivores only eat meat");
        } else {
            System.out.println(this.getName() + "eats" + food.getName());
        }

    }
}
