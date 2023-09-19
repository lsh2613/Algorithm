//package 프로그래머스;
//
//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        int minN=0;
//
//        int c=1;
//        while (n!=0){
//            if (n%10>=6) {
//                answer += 10 - n % 10;
//                n+=10-n%10;
//            }
//            else if (n%10==5 && n/10%10>=5){
//                answer += 10 - n % 10;
//                n+=10-n%10;
//            }
//            minN+=n%10*c; // 해당 자릿수에 맞게 minN에 copy
//            if (n==10)
//                minN+=n*c;
//            c*=10; // 다음 자릿수
//
//            n/=10; // 다음 자릿수
//        }
//
//        while(minN!=0){
//            answer += minN%10;
//            minN/=10;
//        }
//
//        return answer;
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        int w[] = {100, 100, 100, 150, 150, 200, 300};
//
//        int result = solution.solution(95);
//        System.out.println("expect: " + result);
//    }
//}
