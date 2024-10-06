import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1859 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int max = a[n-1];
            long ans = 0;

            for(int i=n-2; i>=0; i--) {
                if(max>a[i])
                    ans += max-a[i];
                else
                    max = a[i];
            }
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.print(sb);
    }
}
