package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1074 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); //행
        int c = Integer.parseInt(st.nextToken()); //열
        int len = (int) Math.pow(2, N); //한 변의 길이

        devideAndConquer(len, r, c);
        System.out.println(count);
    }

    private static void devideAndConquer(int len, int r, int c) {
        if(len == 1)
            return;


        if(r < len/2 && c < len/2) {
            devideAndConquer(len/2, r, c);
        }
        else if(r < len/2 && c >= len/2) {
            count += len * len / 4;
            devideAndConquer(len/2, r, c - len/2);
        }
        else if(r >= len/2 && c < len/2) {
            count += (len * len / 4) * 2;
            devideAndConquer(len/2, r - len/2, c);
        }
        else {
            count += (len * len / 4) * 3;
            devideAndConquer(len/2, r - len/2, c - len/2);
        }
    }
}
