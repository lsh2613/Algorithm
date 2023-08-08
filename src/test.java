import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer==-1? 0 : answer;
    }

    static boolean[] vs;
    static int bfs(String begin, String target, String[] words){
        int len = words.length;
        vs= new boolean[len];

        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        int cnt=0;
        while(!q.isEmpty()){
            for(int j=0;j<q.size();j++){
                String now = q.poll();

                if(now.equals(target))
                    return cnt;

                for(int i=0;i<len;i++){
                    // 방문을 했거나, 다음 단어로 바뀔 수 없으면 생략
                    if(vs[i]||!canChange(now, words[i])) continue;

                    q.offer(words[i]);
                }
            }
            cnt++;
        }
        return -1;

    }

    static boolean canChange(String s1, String s2){
        int cnt=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i))
                cnt++;
        }
        return cnt==s1.length()-1?true:false;
    }
}