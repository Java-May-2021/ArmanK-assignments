public class StringManTester{
    public static void main(String[] args){
        StringManipulator s1 = new StringManipulator();
        String result = s1.trimAndConcat("   Hello   ", "     World         ");
        System.out.println(result);

        System.out.println( s1.getIndexOrNull("Hello",'o'));
        System.out.println( s1.getIndexOrNull("Hello",'i'));

        System.out.println( s1.getIndexOrNull("Hello","llo"));
        System.out.println( s1.getIndexOrNull("Hello","world"));

        System.out.println( s1.concatSubstring("Hello",1,3,"World"));
        System.out.println( s1.concatSubstring("Hello",1,2,"world"));


    }
}