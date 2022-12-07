import java.util.ArrayList;

public class ReverseSubArray {

    public void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
//        ArrayList<Integer> arr1 = new ArrayList<>();
//        if(k > arr.size()){
//            for(int x = arr.size() - 1; x >= 0; x--) {
//                arr1.add(arr.get(x));
//            }
//        }else {
//            for (int j = k - 1; j >= 0; j--) {
//                //System.out.print(arr.get(j) + " ");
//                arr1.add(arr.get(j));
//            }
//
//            for (int a = arr.size() - 1; a >= k; a--) {
//                //System.out.print(arr.get(a) + " ");
//                arr1.add(arr.get(a));
//            }
//        }
//        arr.clear();
//        arr.addAll(arr1);
//        for(int val : arr)
//            System.out.print(val + " ");


        for (int i = 0; i < n; i += k)
        {
            int left = i;

            // to handle case when k is not multiple
            // of n
            int right = Math.min(i + k - 1, n - 1);
            int temp;

            // reverse the sub-array [left, right]
            while (left < right)
            {
                temp= arr.get(left);
                arr.add(left,arr.get(right));
                //arr[right]=temp;
                arr.add(right,temp);
                left+=1;
                right-=1;
            }
        }
        for(int val: arr)
            System.out.print(val + " ");
    }

}
