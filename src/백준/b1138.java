package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class b1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            result.add(0);
        }

        int[] tall = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = n-1; i >= 0; i--) {
            if (result.get(tall[i]) == 0) {
                result.remove(tall[i]);
                result.add(tall[i], i + 1);
            }
            else {
                result.add(tall[i], i+1);
            }
        }

        result.subList(0,n).forEach(i -> System.out.print(i + " "));
    }
}
