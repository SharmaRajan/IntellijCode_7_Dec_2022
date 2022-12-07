import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
//        Date date = new Date();
//        Date date1 = new Date(2022);
//        Date date2 = new Date(2000);
//
//        checkDateFormat(date);
//        checkDateFormat(date1);
//        checkDateFormat(date2);

        int[] nums = {1,7,3,6,5,2};
        System.out.println(pivotIndex(nums));

        RotateArray arr = new RotateArray();
        arr.rotate(nums,2);

//        List<String> names = Arrays.asList("Rajan","Abhishek", "Ravi","Sahil","Ravi");
//
//        Set<String> filtered = names.stream().collect(Collectors.toSet());
//
//        Set<String> noDuplicates = names.stream().collect(Collectors.toSet());
//        System.out.println(noDuplicates);
//        System.out.println(filtered);
    }

    public static void checkDateFormat(Date date){
//        Date date = new Date();
        //Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        //date = calendar.getTime();

//        Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(req.getDate());

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        System.out.println("IST time: " + sdf.format(date));

        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("GMT time: " + sdf1.format(date));
        System.out.println();
//        System.out.println("GMT time: " + date);
    }

    public static int pivotIndex(int[] nums) {
                int sum = 0, leftsum = 0;
                for (int x: nums) sum += x;
                for (int i = 0; i < nums.length; ++i) {
                    if (leftsum == sum - leftsum - nums[i]) return i;
                    leftsum += nums[i];
                }
                return -1;
    }

        public static boolean isIsomorphic(String s, String t) {

            int[] mappingDictStoT = new int[256];
            Arrays.fill(mappingDictStoT, -1);

            int[] mappingDictTtoS = new int[256];
            Arrays.fill(mappingDictTtoS, -1);

            for (int i = 0; i < s.length(); ++i) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                // Case 1: No mapping exists in either of the dictionaries
                if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                    mappingDictStoT[c1] = c2;
                    mappingDictTtoS[c2] = c1;
                }

                // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
                // it doesn't match in either of the dictionaries or both
                else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                    return false;
                }
            }

            return true;
        }

}