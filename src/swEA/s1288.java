package swEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s1288 {
    static int[] completeBit;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T;
        T=Integer.parseInt(br.readLine());
        int complete[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            completeBit = new int[10];
            int N = 0; //N번째 양
            int num = Integer.parseInt(br.readLine());
            int xN = 0;
            //입력받은 값에 해당하는 자릿수를 completeBit 인덱스에 넣기
            while (!Arrays.equals(completeBit, complete)) {
                N++;
                int tmp = xN = num * N; // N번째 양에 대한 값
                while (tmp != 0) {
                    int n = tmp % 10;
                    if (completeBit[n] == 0) {
                        completeBit[n] = 1;
                    }
                    tmp /= 10;
                }
            }
            sb.append("#" + test_case + " " + xN + "\n");
        }
        System.out.println(sb);
    }
}
