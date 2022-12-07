import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ArrayToCollection {

    public void read() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How many elements you want to add in the array: ");
        int n = Integer.parseInt(buffer.readLine());
        String[] name = new String[n];

        for (int i = 0; i < n; i++) {
            name[i] = buffer.readLine();
        }

        List<String> list = Arrays.asList(name);
        System.out.println();
        for (String li : list) {
            String str = li;
            System.out.println(str + " ");
        }
    }

}
