public class PhoneTester{
    public static void main(String[] args){
        Galaxy g1 = new Galaxy("S9",99,"AT&T","Ring RIng RIng");
        g1.displayInfo();
        System.out.println(g1.ring());
        System.out.println(g1.unlock());

        IPhone i1 = new IPhone("X",100, "Family-Mobile","Zing Zing ZIng");
        i1.displayInfo();
        System.out.println(i1.ring());
        System.out.println(i1.unlock());

    }
}