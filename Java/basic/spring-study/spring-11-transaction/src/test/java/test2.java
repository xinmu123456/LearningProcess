import java.util.ArrayList;
import java.util.Iterator;

/**
 * author: xinmu
 * date: 2022/4/11
 * time: 9:55
 */


public class test2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbs = new ArrayList<>();
        numbs.add(4);
        numbs.add(11);
        numbs.add(4);

        System.out.println(numbs);

        Iterator<Integer> it=numbs.iterator();

        while(it.hasNext()) {
            if (it.next()<10){
                it.remove();
            }
        }

        System.out.println(numbs);


    }
}
