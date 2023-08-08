class sol1 {
    static boolean[] vs;
    static String[] words;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        this.words=words;
        vs = new boolean[words.length];

        dfs(begin, target, 1);
        return answer;
    }

    static void dfs(String now, String target, int cnt){
        if(now.equals(target)){
            answer=cnt;
            return;
        }

        for(int i=0; i<words.length; i++){
            if(vs[i]||!canChange(now, words[i])) continue;

            vs[i]=true;
            dfs(words[i], target, cnt++);
            vs[i]=false;
        }
    }

    static boolean canChange(String s1, String s2){
        int cnt=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i))
                cnt++;
        }
        return cnt==s1.length()-1?true:false;
    }

    public static void main(String[] args) {
        sol1 solution = new sol1();
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int result = solution.solution("hit", "cog", words);
        System.out.println("XOR 결과: " + result);
    }
}