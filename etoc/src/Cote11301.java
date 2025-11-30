import java.util.*;

public class Cote11301 {

    static int answer = 0;

    public static class State{
        // screen의 이모티콘 개수, clipboard 의 이모티콘 개수, 현재까지 이모티콘 만드는데 걸리는 시간을 State 객체로 관리하자
        public int screen;
        public int clipboard;
        public int time;

        public State(int screen, int clipboard, int time){
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static void BFS(State initialState, boolean[][] visited, int S){
        Queue<State> queue = new ArrayDeque<>();

        visited[initialState.screen][initialState.clipboard] = true;
        queue.offer(initialState);

        while(!queue.isEmpty()){
            State curState = queue.poll();

            int screen = curState.screen;
            int clipboard = curState.clipboard;
            int time = curState.time;

            // 탐색 종료 조건
            if (screen == S){
                answer = time;
                return;
            }

            // 연산 1 : screen, clipboard -> screen, screen
            if(!visited[screen][screen]){
                queue.offer(new State(screen,screen,time+1));
                visited[screen][screen] = true;
            }
            // 연산 2 : screen, clipboard -> screen + clipboard , clipboard
            if(clipboard > 0 && screen + clipboard <= S && !visited[screen+clipboard][clipboard]){
                queue.offer(new State(screen+clipboard, clipboard, time+1));
                visited[screen+clipboard][clipboard] = true;
            }
            // 연산 3: 화면에 잇는 이모티콘 중 하나 삭제하기. screen, clipboard -> screen -1 , clipboard
            if (screen > 0 && !visited[screen-1][clipboard]){
                queue.offer(new State(screen-1, clipboard, time + 1));
                visited[screen-1][clipboard] = true;
            }
        }
        // BFS 탐색 종료
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        // 방문배열 정의하자
        boolean[][] visited = new boolean[S+1][S+1];

        // 처음 상태 : 화면 이모티콘 개수 1, 클립 보드 개수 0 , 시간 0
        State initialState = new State(1,0,0);

        // 정답
        BFS(initialState, visited, S);
        System.out.print(answer);

    }
}
