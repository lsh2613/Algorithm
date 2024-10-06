package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S1230 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int numCnt = Integer.parseInt(br.readLine());
//            List<String> list = Arrays.stream(br.readLine().split(" ")).toList();
            List<String> list = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
            LinkedList<String> nums = new LinkedList<>(list);

            int commandCnt = Integer.parseInt(br.readLine());
            StringTokenizer commands = new StringTokenizer(br.readLine());
            while (commands.hasMoreTokens()) {
                String command = commands.nextToken();

                //삽입, x부터 y개의 s값 넣기
                if (command.equals("I")) {
                    int x = Integer.parseInt(commands.nextToken());
                    int y = Integer.parseInt(commands.nextToken());
                    for (int i = 0; i < y; i++) {
                        list.add(x, commands.nextToken());
                        x++;
                    }
                }
                // x부터 y개의 값 삭제
                if (command.equals("D")) {
                    int x = Integer.parseInt(commands.nextToken());
                    int y = Integer.parseInt(commands.nextToken());
                    for (int i = 0; i < y; i++) {
                        list.remove(x);
                    }
                }
                // 맨뒤에 y개의 s를 삽입
                if (command.equals("A")) {
                    int y = Integer.parseInt(commands.nextToken());
                    for (int i = 0; i < y; i++) {
                        list.add(commands.nextToken());
                    }
                }
            }
            System.out.printf("#%d ",test_case);
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
