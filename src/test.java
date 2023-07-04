import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /**
         * 입력 예시
         * 5
         * 8 9 2 1 6
         */
        int[] oneLine = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("oneLine = " + Arrays.toString(oneLine));
        /**
         * 5
         * 8
         * 9
         * 2
         * 1
         * 6
         */
        n = Integer.parseInt(br.readLine());
        int[] multiLine = br.lines().limit(n).mapToInt(Integer::parseInt).toArray();
        System.out.println("multiLine = " + Arrays.toString(multiLine));

    }
}
