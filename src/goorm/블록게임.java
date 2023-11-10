import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Posiotion {
    int x;
    int y;

    public Posiotion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(char dir) {
        switch (dir) {
            case 'R':
                this.x++;
                break;
            case 'L':
                this.x--;
                break;
            case 'U':
                this.y++;
                break;
            case 'D':
                this.y--;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Posiotion other = (Posiotion) obj;  // 형변환

        // x와 y의 값이 같은지 비교하여 true 또는 false 반환
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        int result = 17;  // 초기 해시 코드 값을 선택합니다. 임의의 정수를 선택할 수 있습니다.

        // 필드 값으로 해시 코드를 계산하는 방식을 선택합니다. 예를 들어, 31은 일반적으로 사용되는 소수입니다.
        result = 31 * result + x;
        result = 31 * result + y;

        return result;
    }
}

class 블록게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Posiotion, Integer> posToIdx = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String dir = " " + br.readLine(); // " ": (0,0)좌표에 대한 dir
        int[] values = Arrays.stream(
                ("1 " + br.readLine()).split( " ")) // "1 ": (0,0)좌표에 대한 val 값
                .mapToInt(Integer::parseInt).toArray();
        Posiotion[] positions = new Posiotion[values.length];
        int sum = 0;

        Posiotion cur = new Posiotion(0, 0);
        for (int i = 0; i < n+1; i++) {
            cur.move(dir.charAt(i));

            // 이미 존재하는데 삭제되지 않은 블럭이라면 해당 블럭 idx~i-1까지 블럭 삭제(idx -> -1로)
            if (posToIdx.containsKey(cur) && posToIdx.get(cur) != -1) {  // -1은 이미 삭제된 좌표
                Integer idx = posToIdx.get(cur);
                for (int j = idx; j <= i - 1; j++) {
                    posToIdx.put(positions[j], -1);
                    sum -= values[j];
                    values[j] = 0;
                }
            }
            // 현재 좌표에 대한 정보 저장
            positions[i] = new Posiotion(cur.x, cur.y);
            sum += values[i];
            posToIdx.put(new Posiotion(cur.x, cur.y), i);
        }
        System.out.println(sum);
    }
}