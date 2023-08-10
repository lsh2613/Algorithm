import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int[] nums = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int len = number.length()-k; // 구해야 하는 자릿수

        int maxIdx=-1;
        while(len!=0){
            int max=-1;
            int point = maxIdx;
            for(int i=point+1;i<=nums.length-len; i++){
                if(max<nums[i]){
                    max=nums[i];
                    maxIdx=i;
                }
            }
            answer.append(max);
            len--;
        }

        return answer.toString();
    }
}

class test{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };

        System.out.println(solution.solution("1231234",2));
    }
}