import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class Test{
    public static void main(String[] args) {
        int n = 10000;
        long count = Arrays.stream(getPrime(n)).count();
        long count2 = Arrays.stream(getPrime2(n)).count();

        System.out.println("count = " + count);
        System.out.println("count2 = " + count2);
    }
    static int[] getPrime(int n) {
        IntStream nums = IntStream.range(2, n + 1);

        IntStream primes = nums.filter(i -> i == 2 || i % 2 != 0)
                .filter(i -> i == 3 || i % 3 != 0)
                .filter(i -> i == 5 || i % 5 != 0)
                .filter(i -> i == 7 || i % 7 != 0);

        return IntStream.concat(primes, IntStream.of(0)).toArray();

    }
    static int[] getPrime2(int n) {
        ArrayList<Integer> prime = new ArrayList<>();
        int temp[] = new int[n+1];
        int rootN = (int)Math.sqrt(n);
        for(int i=2; i<=n; i++) {
            temp[i] = i;
        }
        for(int i=2; i<=rootN; i++) {
            if(temp[i] != 0 ) {
                for(int j=i+i; j<=n; j+=i) {
                    temp[j] = 0;
                }
            }
        }
        for(int i=2; i<=n; i++) {
            if(temp[i] != 0) {
                //System.out.println(temp[i]); 디버깅용
                prime.add(temp[i]);
            }
        }
        prime.add(0);
        return prime.stream().mapToInt(Integer::intValue).toArray();
    }

}