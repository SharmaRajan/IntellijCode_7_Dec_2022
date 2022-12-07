import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("1's are " + hammingWeight(00000101));
        //System.out.println(subtractProductAndSum(234));
        //int[] arr = {1,2,3,0,0,0};
        ///int[] arr2 = {2,5,6};

        //for(int arr1: twoSum(arr,6))
            //System.out.println(arr1);

        //merge(arr,3,arr2,3);
        //CountVowel count = new CountVowel();
        //System.out.println(count.countVowelStrings(3));
        //ArrayList<String> arr = new ArrayList<>();
        //Collection collection = List.of(new String[]{ "out","laughing", "loud"});
        //arr.addAll(collection);

        //System.out.println(acronymFor(arr));
        //acronymFor(arr);

        ArrayList<Integer> integerArrayList = new ArrayList<>(List.of(1,2,3,4,5));
        ReverseSubArray reverseSubArray = new ReverseSubArray();
        reverseSubArray.reverseInGroups(integerArrayList,5,77);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count += 1;
        }
        return count;
    }
    public static int subtractProductAndSum(int n) {
        int sum = 0, rem = 0, product = 1;
        while(n != 0){
            rem = n % 10;
            sum += rem;
            product *= rem;
            n /=10;
        }
        return product - sum;
    }

    public static int[] twoSum(int[] nums, int target) {
//        int[] arr = new int[2];
//        for(int i = 0; i < nums.length -1; i++)    {
//            for(int j = i + 1; j < nums.length; j++)    {
//                if(nums[i] + nums[j] == target){
//                    arr[0] = i;
//                    arr[1] = j;
//                }
//            }
//        }
//        return arr;

        // add the values of the array as keys to the map
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int complement = target - nums[i];
            // The main idea is if num[i] + its completment == target
            if (numMap.containsKey(complement))
                return new int[] {numMap.get(complement), i} ;
            else
                numMap.put(nums[i],i);
        }
        // else return empty array
        return new int[] {};
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

//        int i = 0, j = 0, k = 0;
//        int[] arr1 = nums1;
//        int[] arr2 = nums2;
//
//        while(i < m && j < n)   {
//            if (arr1[i] < arr2[j]) {
//                nums1[k] = arr1[i];
//                k++;
//                i++;
//            }else{
//                nums1[k] = arr2[j];
//                k++;
//                j++;
//            }
//        }
//        for(;i < m; i++)    {
//            nums1[k] = arr1[i];
//            k++;
//        }
//        for(;j < n; j++)    {
//            nums1[k] = arr2[j];
//            k++;
//        }
//
//        for(int val : nums1)
//            System.out.print(val + " ");


        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }


        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
        for(int val: nums1)
            System.out.print(val + " ");
    }

    public static String acronymFor(ArrayList<String> arrayList)  {
        char[][] arr = new char[arrayList.size()][];
        for(int i = 0; i < arrayList.size(); i++)   {
            for(int j = 0; j < arrayList.size(); j++)   {
                arr[j] = arrayList.get(j).toCharArray();
            }
        }

        char[] val = new char[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++)   {
            val[i] = arr[i][0];
        }
        String character = String.copyValueOf(val).toUpperCase();
        return character;
    }

}