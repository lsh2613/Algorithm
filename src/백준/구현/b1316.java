package 백준.구현;

import java.util.Arrays;
import java.util.Scanner;

public class b1316 {
    public static void main(String[] args) {
        /**
         * 테스트케이스는 다 맞는데 제출하면 틀림
         * 왜 틀린지 모르겠음
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while (n-- > 0) {
            String str = sc.next();
            if (isGroupWord(str)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isGroupWord(String str) {
        // a부터 0번 인덱스, z는 122-97=25번 인덱스
        int[] alphabetCount = new int['z' - 'a' + 1]; //0~3은 3-0+1개
        Arrays.fill(alphabetCount, 0);
        char prev = '\0';
        for (int i = 0; i < str.length(); i++) {
            char strToChar = str.charAt(i);
            if (prev == '\0') { //str의 첫 단어일 경우 이전값으로 등록
                prev = strToChar;
            } else if (i == str.length()-1) { // 이전값과 현재값이 달라져 알파벳이 바꼇다면 이전값을 등장횟수를 증가
                alphabetCount[strToChar - 'a']++;
            }else if (prev != strToChar) { // 마지막 단어는 무조건 등장한 단어이므로 하나 증가
                alphabetCount[prev-'a']++;
                prev = strToChar;
            }
        }
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
