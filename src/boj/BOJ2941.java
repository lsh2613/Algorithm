package boj;

import java.util.Scanner;

public class BOJ2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int length = str.replaceAll("c=|c-|dz=|d-|dz=|d-|lj|nj|s=|z=", "a").length();
        System.out.println(length);
    }

}
