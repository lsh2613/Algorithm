//package 프로그래머스;
//
//import java.util.LinkedList;
//import java.util.Queue;
//class Node{
//    int x;
//    int y;
//    int time;
//    Node(int x, int y, int time){
//        this.x=x;
//        this.y=y;
//        this.time=time;
//    }
//}
//class Solution {
//    static int Lx, Ly, Ex, Ey;
//    static boolean[][] visited;
//    public int solution(String[] maps) {
//        int answer = 0;
//        int row = maps.length;
//        int col = maps[0].length();
//        int Sx=0, Sy=0;
//
//        for(int i=0; i<row; i++){
//            for(int j=0; j<col; j++){
//                if(maps[i].charAt(j)=='S'){
//                    Sx=i;
//                    Sy=j;
//                }
//                if(maps[i].charAt(j)=='L'){
//                    Lx=i;
//                    Ly=j;
//                }
//                if(maps[i].charAt(j)=='E'){
//                    Ex=i;
//                    Ey=j;
//                }
//            }
//        }
//
//        visited = new boolean[row][col];
//        answer+=bfs(maps,Sx,Sy,Lx,Ly);
//        visited = new boolean[row][col];
//        answer+=bfs(maps,Lx,Ly,Ex,Ey);
//
//        return answer<=0?-1:answer;
//    }
//
//    static int[] dx = {-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//
//    static int bfs(String[] maps, int startX, int startY, int targetX, int targetY){
//        visited[startX][startY]=true;
//        Queue<Node> q = new LinkedList<>();
//        q.add(new Node(startX,startY,0));
//
//        while(!q.isEmpty()){
//            Node now = q.poll();
//            int x=now.x;
//            int y=now.y;
//            if(x==targetX && y==targetY)
//                return now.time;
//
//            for(int i=0;i<4;i++){
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//
//                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length()
//                        || visited[nx][ny] || maps[nx].charAt(ny)=='X')
//                    continue;
//
//                visited[nx][ny]=true;
//                q.add(new Node(nx, ny, now.time+1));
//            }
//        }
//
//        return -1;
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        String[] board = {
//                "SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"
//        };
//
//        int result = solution.solution(board);
//        System.out.println("expect: " + result);
//    }
//}
