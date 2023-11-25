import java.util.PriorityQueue;
import java.util.Scanner;

class Shark {
    int x;
    int y;
    int move;

    public Shark(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
public class b16236 {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] board;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N][N];
        Shark shark = null;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 9) {
                    shark = new Shark(i, j, 0);
                    board[i][j] = 0;
                }
            }

        int size = 2;
        int eat = 0; // 먹은 물고기 수
        int totalMove = 0; // 움직인 총 거리
        PriorityQueue<Shark> q = new PriorityQueue<>((s1, s2) -> {
            if (s1.move != s2.move) {
                return s1.move - s2.move;
            } else {
                if (s1.x != s2.x)
                    return s1.x - s2.x;
                return s1.y - s2.y;
            }
        });

        while (true) { // 더 이상 먹을 물고기가 없으면 종료
            q.clear();
            boolean[][] visit = new boolean[N][N];

            q.add(new Shark(shark.x, shark.y, 0)); // y좌표, x좌표, 이동한 거리
            visit[shark.x][shark.y] = true;

            boolean eatFood = false; // 상어가 먹이를 먹었는지 체크할 변수

            while (!q.isEmpty()) { // 먹을 수 있는 물고기를 찾는다. 찾았다면 eatFood = true가 됨
                shark = q.poll();

                if (board[shark.x][shark.y] != 0 && board[shark.x][shark.y] < size) { // 먹이가 있으면서 상어의 사이즈보다 작다면?
                    board[shark.x][shark.y] = 0; // 물고기를 제거
                    eat++;
                    totalMove += shark.move; // 움직인 거리를 총 움직인 거리에 추가
                    eatFood = true; // 먹이 먹었다고 체크
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = shark.x + dx[k];
                    int ny = shark.y + dy[k];

                    if (outOfBoard(nx, ny) || visit[nx][ny] || board[nx][ny] > size) {
                        continue;
                    }

                    q.add(new Shark(nx, ny, shark.move + 1));
                    visit[nx][ny] = true;
                }
            }

            if (!eatFood) // 물고기를 먹지 못했다면 더이상 먹을 물고기가 없다는 뜻
                break;

            if (size == eat) { // 사이즈와 먹이를 먹은 수가 동일하다면 상어의 크기를 증가
                size++;
                eat = 0;
            }
        }


        System.out.println(totalMove);

    }
    static boolean outOfBoard ( int x, int y){
        return x < 0 || y < 0 || x >= N || y >= N;
    }


}