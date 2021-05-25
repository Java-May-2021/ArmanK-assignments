public class HumanTester{
    public static void main(String[] args){
        Human ninja = new Human();
        Human samuri = new Human();
        Human wizard = new Human();

        samuri.attack(wizard);
        samuri.attack(ninja);
        samuri.attack(ninja);
    }
}