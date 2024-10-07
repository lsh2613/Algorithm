package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });
        Arrays.stream(strs)
                .distinct()
                .forEach(i -> System.out.println(i));
    }
}
