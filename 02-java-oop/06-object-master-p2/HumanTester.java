public class HumanTester{
    public static void main(String[] args){
       Ninja n1 = new Ninja();
       Samuri s1 = new Samuri();
       Samuri s2 = new Samuri();
       Wizard w1 = new Wizard();

        n1.steal(w1);
        n1.runAway();
      
        w1.fireball(n1);
        w1.fireball(n1);

        //Ninja health
        n1.display();
        w1.heal(n1);
        n1.display();

        s1.deathBlow(n1);
         n1.display();
        s1.display();
        s1.meditate();
        s1.display();
        System.out.println(s1.howMany());
    }
}