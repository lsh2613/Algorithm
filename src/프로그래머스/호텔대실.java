//package 프로그래머스;
//
//import java.util.Arrays;
//class Solution {
//    static final int MAX_TIME = 24*60+10;
//
//    static int hToM(int h, int m){
//        if(m>=60){
//            h++;
//            m-=60;
//        }
//        return h*60+m;
//    }
//
//    public int solution(String[][] book_time) {
//        int[] timeTable= new int[MAX_TIME];
//
//        // timeTable 초기화
//        for(int i=0; i<book_time.length; i++){
//            int startTime[] = Arrays.stream(book_time[i][0].split(":"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//            int startM = hToM(startTime[0], startTime[1]);
//
//            int endTime[] = Arrays.stream(book_time[i][1].split(":"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//            int endM = hToM(endTime[0], endTime[1]+10);
//
//            timeTable[startM]++;
//            timeTable[endM]--;
//        }
//
//        int answer=0;
//        // 누적합 계산 및 최댓값 찾기
//        for(int i=1; i<MAX_TIME; i++){
//            timeTable[i]+=timeTable[i-1];
//            answer = Math.max(timeTable[i], answer);
//        }
//
//        return answer;
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        String[] board = {
//                "SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"
//        };
//
//        int result = solution.solution(board);
//        System.out.println("expect: " + result);
//    }
//}
