package cote2026feb;

import java.util.*;
public class Cote02051 {

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {


            int[] mailRecievedCount = new int[id_list.length];


            Map<String, Set<String>> reportMap = new HashMap<>();
            Map<String, Integer> reportCountMap = new HashMap<>();

            for (String reportInfo : report){

                String[] splitedInfo = reportInfo.split(" ");
                String reportId = splitedInfo[0];
                String reportedId = splitedInfo[1];

                if (!reportMap.containsKey(reportId)){
                    Set<String> set = new HashSet<>();
                    set.add(reportedId);
                    reportMap.put(reportId, set);
                } else {
                    Set<String> toCheckId = reportMap.get(reportId);

                    toCheckId.add(reportedId);
                    reportMap.put(reportId, toCheckId);

                }

            }


            for (Set<String> set : reportMap.values()){
                for (String reportedId : set){
                    reportCountMap.put(reportedId, reportCountMap.getOrDefault(reportedId, 0) + 1);
                }
            }



            for (int userIdx = 0; userIdx < id_list.length; userIdx++){

                String userId = id_list[userIdx];
                int mailRecieved = 0;
                if (reportMap.containsKey(userId)){
                    Set<String> reportedIdsByUser = reportMap.get(userId);
                    for (String reportedId : reportedIdsByUser){
                        if (reportCountMap.get(reportedId) >= k){
                            mailRecieved++;
                        }
                    }
                    mailRecievedCount[userIdx] = mailRecieved;
                }



            }


            return mailRecievedCount;

        }
    }
}
