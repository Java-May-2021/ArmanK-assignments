public class Samuri extends Human{

        public Samuri(){
            this.health = 200;
            numberOfSamuri++;
        }
        
        private static int numberOfSamuri = 0;
        public void deathBlow(Human human){
            human.health -= human.health;
            this.health -= this.health/2;
        }

        public void meditate(){
            this.health += this.health/2;
        }

        public int howMany(){
            return numberOfSamuri;
        }

        public void display(){
            System.out.println("Samuri Health:"+ this.health);
        }
}