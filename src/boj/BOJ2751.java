package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int n = Integer.parseInt(br.readLine());
//        ArrayList<Integer> list = new ArrayList<>();
//        while (n-- > 0) {
//            list.add(Integer.parseInt(br.readLine()));
//        }
//        Collections.sort(list);
//        list.forEach(i -> sb.append(i).append("\n"));
//        System.out.println(sb);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        while (n-- > 0) {
            ints[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ints);
        Arrays.stream(ints).forEach(i->sb.append(i).append("\n"));
        System.out.println(sb);
    }
}
