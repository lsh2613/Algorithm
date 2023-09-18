package custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 에라토스테네스의체 {

    public static void main(String[] args) {
        int n = 100;
        int[] primes = getPrime(n);
        System.out.println(Arrays.toString(primes));
    }

    // 에라토스테네스의 체
    // 약간 응용해서 2~n범위의 소수만을 배열로 리턴
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
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }
}

