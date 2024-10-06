package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11651 {
    static class Point implements Comparable<백준.Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(백준.Point other) {
            // y에 대한 오름차순 정렬
            if (this.y != other.y) {
                return this.y - other.y;
            }
            // y 값이 같은 경우 x에 대한 오름차순 정렬
            return this.x-other.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            points[n] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points);
        Arrays.stream(points).forEach(i -> sb.append(i.x + " " + i.y+"\n"));
        System.out.println(sb);
    }
}
