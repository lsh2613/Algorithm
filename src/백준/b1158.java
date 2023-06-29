package 백준;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class b1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }

        System.out.printf("<");
        int cnt=1;
        while (!list.isEmpty()) {
            if (cnt != k) {
                int tmp = list.get(0);
                list.remove(0);
                list.add(tmp);
                cnt++;
            } else {
                System.out.print(list.get(0));
                list.remove(0);
                if (!list.isEmpty()) {
                    System.out.print(", ");
                }
                cnt = 1;
            }
        }
        System.out.println(">");
    }
}
