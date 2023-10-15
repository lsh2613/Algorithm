//package 프로그래머스.kakao2023blind;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//public class 개인정보 {
//    /* 디버깅용
//    "2022.05.19"
//    ["A 6", "B 12", "C 3"]
//    ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
//    [1, 3]
//     */
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String today = "2022.05.19";
//        String[] terms = new String[]{
//                "A 6", "B 12", "C 3"
//        };
//        String[] privacies = new String[]{
//                "2021.05.02 A",
//                "2021.07.01 B",
//                "2022.02.19 C",
//                "2022.02.20 C"
//        };
//        System.out.println(Arrays.toString(solution.solution(today, terms, privacies)));
//    }
//}
//
//class Solution {
//    static List<Integer> answer = new ArrayList<>();
//    static HashMap<Character, Integer> termMap = new HashMap<>();
//
//    public int[] solution(String today, String[] terms, String[] privacies) {
//        for (String term : terms) {
//            String[] split = term.split(" ");
//            termMap.put(split[0].charAt(0), Integer.valueOf(split[1]));
//        }
//
//        for (int i = 0; i < privacies.length; i++) {
//            checkDestroyed(today, privacies[i], i + 1);
//        }
//
//        return answer.stream().mapToInt(Integer::intValue).toArray();
//    }
//
//    static void checkDestroyed(String today, String privacy, int seq) {
//        String[] todaySplit = today.split("[.]");
//        int todayYear = Integer.parseInt(todaySplit[0]);
//        int todayMon = Integer.parseInt(todaySplit[1]);
//        int todayDay = Integer.parseInt(todaySplit[2]);
//
//        String[] privacySplit = privacy.split(" ");
//        String[] privacyDate = privacySplit[0].split("[.]");
//        char term = privacySplit[1].charAt(0);
//        int privacyYear = Integer.parseInt(privacyDate[0]);
//        int privacyMon = Integer.parseInt(privacyDate[1]);
//        int privacyDay = Integer.parseInt(privacyDate[2]);
//
//        // year 맞추기
//        todayMon += (todayYear - privacyYear) * 12;
//
//        // mon 맞추기
//        todayDay += (todayMon - privacyMon) * 28;
//
//        int termMon = termMap.get(term);
//        if ((todayDay - privacyDay) >= termMon * 28) {
//            answer.add(seq);
//        }
//
//    }
//}