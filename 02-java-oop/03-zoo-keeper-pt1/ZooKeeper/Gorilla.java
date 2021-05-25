
public class Gorilla extends Mammal{
    public void throwSomething(){
            energyLevel -= 5;
            System.out.println("Gorilla is throwing rock watch out");
    }

     public void eatBananas(){
            energyLevel += 10;
            System.out.println("Gorilla is eating banana's");
    }

     public void climb(){
            energyLevel -= 10;
            System.out.println("Gorilla is climbing a tree");
    }

    
}