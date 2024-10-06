package 프로그래머스;
class 혼자서하는틱택토 {
    public int solution(String[] board) {
        int answer = -1;

        int o = 0;
        int x= 0;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length();j++){
                if(board[i].charAt(j)=='O')
                    o++;
                if(board[i].charAt(j)=='X')
                    x++;
            }
        }

        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');

        // 둘 다 이기는 경우 존재X
        if(oWin && xWin) answer = 0;

            // O가 승리했을 경우 O갯수가 X갯수보다 하나 큼
        else if(oWin && !xWin){
            if(o==x+1) answer = 1;
            else answer = 0;
        }

        // X가 승리했을 경우 O와 X의 갯수가 동일해야 함
        else if(!oWin && xWin){
            if(o==x) answer = 1;
            else answer = 0;
        }

        // 아무도 승리하지 못했을 경우 o가 x랑 같거나 하나 더 큼
        else if(!oWin && !xWin){
            if (o==x || o==x+1) answer = 1;
            else answer = 0;
        }

        return answer;
    }

    static boolean isWin(String[] board, char c){
        // 행 열 체크
        for(int i=0; i<3; i++)
            if ((board[i].charAt(0)==c)&&(board[i].charAt(1)==c)&&(board[i].charAt(2)==c)
                    || (board[0].charAt(i)==c)&&(board[1].charAt(i)==c)&&(board[2].charAt(i)==c))
                return true;
        // 대각선 체크
        if((board[0].charAt(0)==c)&&(board[1].charAt(1)==c)&&(board[2].charAt(2)==c)
                || (board[0].charAt(2)==c)&&(board[1].charAt(1)==c)&&(board[2].charAt(0)==c))
            return true;

        return false;
    }
}
