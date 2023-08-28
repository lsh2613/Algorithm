package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] woods = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = Arrays.stream(woods).max().getAsInt();
        while (left < right) {
            int mid = (right + left) / 2;
//            long len = (long) Arrays.stream(woods).map(x -> x - mid).filter(x -> x > 0).sum();
            long len = 0;
            for (int wood : woods) {
                if (wood - mid > 0) {
                    len += wood - mid;
                }
            }

            if (len < m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left-1);

    }
}
