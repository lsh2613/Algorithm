import java.util.*;

class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    static int bfs(int[][] maps){
        int depth=0;
        int w=maps.length;
        int h=maps[0].length;
        boolean[][] visited = new boolean[w][h];
        visited[0][0]=true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));

        while(!q.isEmpty()){
            Node now = q.poll();
            depth++;

            for(int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(visited[nx][ny] || nx<0 || ny<0 || nx>=w || ny>=h
                        || maps[nx][ny]==0)
                    continue;

                if(nx==w-1 && ny==h-1)
                    return depth;
                q.add(new Node(nx, ny));
            }
        }
        return -1;
    }

}