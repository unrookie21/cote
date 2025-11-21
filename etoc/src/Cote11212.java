import java.util.*;

public class Cote11212 {
    class Solution {

        static class Process implements Comparable<Process> {
            public int requestStart;
            public int workingTime;
            public int processNumber;

            public Process(int start, int workingTime, int number){
                this.requestStart = start;
                this.workingTime = workingTime;
                this.processNumber = number;
            }

            @Override
            public int compareTo(Process o){
                if (this.workingTime == o.workingTime){
                    // 작업 소요시간이 같으면, 작업 요청 시각 으로 비교
                    if (this.requestStart == o.requestStart){
                        // 작업 요청 시간도 같으면, 작업 번호로 비교
                        return this.processNumber - o.processNumber;
                    } else {
                        return this.requestStart - o.requestStart;
                    }
                } else{
                    return this.workingTime - o.workingTime;
                }

            }

        }
        public int solution(int[][] jobs) {

            // jobs 를 작업 요청 시간 오름차순으로 정렬해놓자.
            Arrays.sort(jobs, (a,b) -> a[0] - b[0]);

            PriorityQueue<Process> waitingQ = new PriorityQueue<>(); // 최소 힙, 정렬 기준 정의완료

            int currentTime = 0;
            int jobIdx = 0;
            int totalTurnaround = 0;
            int completedJobs = 0;

            // 모든 작업이 완료될때까지 아래의 과정을 반복
            while (completedJobs < jobs.length){

                // 큐에 작업을 추가해야된다. (작업 요청) 근데, 어떤 작업을 추가해야될까?
                // currentTime 보다 작거나 같은 놈들을 추가해야겠지.
                while(jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime){
                    waitingQ.offer(new Process(jobs[jobIdx][0], jobs[jobIdx][1],
                            jobIdx));
                    jobIdx++;
                }

                // 근데, 작업 요청 시작 시간이 현재시간 보다 큰 경우에는, 아직 큐가 비어있을 수도 잇어.
                // 그럼 다음 작업 요청 시작 시간으로 점프하자는 것.
                if (waitingQ.isEmpty()){
                    currentTime = jobs[jobIdx][0];
                    continue;
                }

                // 이제 waiting q 에서 우선순위가 높은 작업을 깨내서 처리하자.
                Process process = waitingQ.poll();
                currentTime += process.workingTime;
                int turnaround = currentTime - process.requestStart;
                totalTurnaround += turnaround;
                completedJobs++;
            }
            // 모든 작업이 완료된 상태
            return totalTurnaround / jobs.length;
        }
    }
}
