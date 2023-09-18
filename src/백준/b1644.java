package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] primes = getPrime(N);

        int start = 0, end = 0;
        int partialSum = 0;
        int cnt = 0;

        while (start <= end && end < primes.length) {
            if (partialSum == N) {
                cnt++;
                partialSum -= primes[start]; // 다른 값을 또 찾기 위해
                start++;
            }
            if (partialSum < N) {
                partialSum += primes[end];
                end++;
            }
            if (partialSum > N) {
                partialSum -= primes[start];
                start++;
            }
        }

        System.out.println(cnt);
    }

    // 에라토스테네스의 체
    static int[] getPrime(int n) {
        List<Integer> primes = new ArrayList<>();
        int temp[] = new int[n+1];
        int rootN = (int)Math.sqrt(n);

        // 연속적인 숫자로 초기화
        for(int i=2; i<=n; i++) {
            temp[i] = i;
        }
        // prime이 아닌 숫자 제거
        for(int i=2; i<=rootN; i++) {
            if(temp[i] != 0 ) {
                for(int j=i+i; j<=n; j+=i) {
                    temp[j] = 0;
                }
            }
        }
        // 소수인 값만 따로 저장
        for(int i=2; i<=n; i++) {
            if(temp[i] != 0) {
                primes.add(temp[i]);
            }
        }
        primes.add(0); // 투포인터 계산을 위해 마지막에 0을 추가
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }

}
