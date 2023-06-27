import java.util.Arrays;
import java.util.Scanner;

public class test {
    static int x = -1, y = -1;
    static int graph[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (x != 0 || y != 0) {
            x = sc.nextInt();
            y = sc.nextInt();
            graph = new int[x][y];

            for (int i = 0; i < x; i++) {
                String str = sc.next();
                for (int j = 0; j < y; j++) {
                    graph[i][j] = str.charAt(j*2);
                }
            }

            for (int arr[] :
                    graph) {
                System.out.println(Arrays.toString(arr));
            };
        }
    }

}