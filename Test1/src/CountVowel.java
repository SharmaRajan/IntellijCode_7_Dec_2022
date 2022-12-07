import java.util.HashSet;
import java.util.Set;

public class CountVowel {

    public int countVowelStrings(int n) {
        int[][] arr = new int[n + 1][6];
        for (int i = 1; i <= n; ++i)
            for (int k = 1; k <= 5; ++k)
                arr[i][k] = arr[i][k - 1] + (i > 1 ? arr[i - 1][k] : 1);

        return arr[n][5];
    }
}
