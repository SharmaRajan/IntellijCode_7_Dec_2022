import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class CollectionElementCompare {

    public void compare()   {
        String[] coins = {"Penny", "Nickel","dime", "Quarter","dollar"};
        Set set = new TreeSet();

        for(int i = 0; i < coins.length; i++)   {
            set.add(coins[i]);
        }

        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set,String.CASE_INSENSITIVE_ORDER));

        System.out.println();
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set,String.CASE_INSENSITIVE_ORDER));
    }

}
