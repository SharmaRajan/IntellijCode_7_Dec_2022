import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //System.out.println(average(arr));

        //System.out.println(numRollsToTarget(2,6,7));
        //System.out.println(numRollsToTarget(30,30,500));
//        int[] arr3 = relativeSortArray(arr,arr1);
//        for(int i = 0; i < arr3.length; i++)   {
//            System.out.println(arr3[i]);
//        }
        //System.out.println((relativeSortArray(arr,arr1)).toString());


//        try{
//            ArrayToCollection array = new ArrayToCollection();
//            array.read();
//            //ArrayToCollection.read();//Non static method
//        }catch(Exception exc)   {
//            System.out.println(exc);
//        }

        //CollectionElementCompare compareColl = new CollectionElementCompare();
        //compareColl.compare();

        int[] arr = {4000,3000,1000,2000};
        int[] arr1 = {124, 5670, 2315, 5480};
//        String[] str = {"Red","Green","Blue"};
//        //1st method
//        List stringList = Arrays.asList(str);
//        System.out.println(stringList);
//
//        List integerList = Arrays.asList(arr);
//        List<Integer> list = new ArrayList<>(integerList);
//
//
//        //2nd method
//        List<String> stringList1 = new ArrayList<>();
//        Collections.addAll(stringList1,str);
//        System.out.println(stringList1);
//
//        //3rd method
//        for(String string: str){
//            stringList1.add(string);
//        }
//        System.out.println(stringList1);

        //Applicable for int, long, double arrays
        List<Integer> integerList1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        for(Integer num: integerList1)
            System.out.print(num + " ");
        System.out.println();
    }

    public static double average(int[] salary) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double sum = 0;
        int count = 0;
        for(int i = 0; i < salary.length; i++)  {
            min = Math.min(salary[i],min);
            max = Math.max(salary[i],max);
        }

        for(int i = 0; i < salary.length; i++)  {
            if((min != salary[i]) && (max != salary[i]))    {
                sum = sum + salary[i];
            }
        }
        return sum/(salary.length - 2);
    }


    public static int[] relativeSortArray(Integer[] arr1, Integer[] arr2) {
       Arrays.sort(arr1);
        int[] arr = new int[arr1.length + arr2.length + 1];
        return arr;
    }



    public static int numRollsToTarget(int n, int k, int target) {
        int count = 0, i = 1;
//        for( i = 1; i <= n; i++)  {
//            for(int j = 6; j >= 1; j--) {
//                if(target == (i + j))
//                    count++;
//            }
//        }
//        return count;

        while(i <= n)    {
            int a = k;
            for(int j = 1; j <= 6; j++,a--) {
                if(target == (j + a))
                    count++;
            }
            i++;
        }
        return count;
    }
}
