import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] ints = new int[N];
        int[] sortedInts = new int[N];

        for (int i = 0; i < N; i++)
            sortedInts[i] = ints[i]= Integer.parseInt(input[i]);

        Arrays.sort(sortedInts);
        for (int i = 0; i < N; i++) {
            int idx = Arrays.binarySearch(sortedInts, ints[i]);
            System.out.print(idx+" ");
        }

    }
}