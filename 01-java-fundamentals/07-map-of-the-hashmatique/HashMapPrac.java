import java.util.Set;
import java.util.HashMap;


public class HashMapPrac{
    public static void main(String[] args){
        HashMap<String,String> trackList = new HashMap<String,String>();
        trackList.put("Summer of 69","Back in the summer of 69");
        trackList.put("Nothing Else matter","So Close to matter how far");
        trackList.put("Lifehouse Broken","I am falling apart ");
        trackList.put("Let it be","Let it be, Let it be");

        Set<String> keys = trackList.keySet();
        for(String key: keys){
            System.out.println(key+": "+trackList.get(key));
        }

    }


}