package learn;

import java.util.*;

public class StartCode {

    public void create()    {

        /*
        Creating collections
        1) Type Safe Collections - same type of elements(objects) are added to collection
        2)Un Type Safe Collections - different types of elements are added to collection
         */

        //Type Safe Collection
        ArrayList<String> names = new ArrayList<>();//Generic type of Collection
        names.add("Rajan");
        names.add("Ravi");
        names.add("Durgesh");
        System.out.println(names);

        //Un Type Safe Collection
        LinkedList list = new LinkedList();
        list.add("Sachin");
        list.add(101);
        list.add(256.90);
        list.add(true);
        //System.out.println(list);

        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

    }

}
