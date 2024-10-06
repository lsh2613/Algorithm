import java.util.Arrays;
import java.util.Stack;

class 과제진행하기 {
    static class Task {
        String name;
        int startTime;

        int needTime;

        public int getStartTime() {
            return startTime;
        }

        public Task(String name, int startTime, int needTime) {
            this.name = name;
            this.startTime = startTime;
            this.needTime = needTime;
        }

    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<Task> stack = new Stack<>();
        Task tasks[] = new Task[plans.length];
        int totalTime=0;

        // Task 초기화
        for(int i=0;i<plans.length;i++){
            String time[] = plans[i][1].split(":");
            int min=Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            int need = Integer.parseInt(plans[i][2]);
            totalTime+=need;
            tasks[i]=new Task(plans[i][0], min, need);
        }

        // 시작시간 기준 정렬
        Arrays.sort(tasks, (a,b)->a.startTime-b.startTime);

        int c=0; //answer 초기화용
        for(int i=0; i<tasks.length-1; i++){
            Task cur = tasks[i];
            Task next = tasks[i+1];
            // 현재 수업의 시작+필요시간보다 다음 수업 시작시간이 더 빠르면
            // 수업을 못 끝내므로 필요시간을 줄이고 stack에 추가
            if (next.startTime < cur.startTime+cur.needTime){
                cur.needTime-=next.startTime-cur.startTime;
                stack.push(cur);
            }
            // 수업을 끝낼 수 있으면 정답에 추가하고 다음 수업이 진행되기 전 남은시간 동안
            // 스택에 있는 수업 진행하기
            else{
                answer[c++]=cur.name;
                int restTime = next.startTime-(cur.startTime+cur.needTime);

                while(!stack.isEmpty()){
                    if (restTime<=0) break;
                    cur = stack.pop();
                    // 스택에서 뽑은 현재 수업의 필요시간 < 남은시간이면 현재 수업 끝내고 남은시간 줄임
                    if (cur.needTime <= restTime){
                        restTime-=cur.needTime;
                        answer[c++]=cur.name;
                    }
                    // 못 끝내면 현재 수업의 필요시간만 줄이고 다시 스택에 넣음
                    else{
                        cur.needTime -= restTime;
                        stack.push(cur);
                        break;
                    }
                }
            }
        }

        // 마지막 수업 추가 후 남은 스택 출력
        stack.push(tasks[tasks.length-1]);
        while(!stack.isEmpty()){
            Task t = stack.pop();
            answer[c++]=t.name;
        }


        return answer;
    }
}
