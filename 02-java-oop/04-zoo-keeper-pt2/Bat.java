public class Bat extends Mammal{


    public void fly(){
        energyLevel -= 50;
        System.out.println("Sheeeeeeeeesh");
    }

    public void eatHumans(){
        energyLevel += 25;
        System.out.println("So Well never mind");
    }
    public void attackTown(){
        energyLevel -= 100;
        System.out.println("Fire Fire Fire !!!");
    }
}