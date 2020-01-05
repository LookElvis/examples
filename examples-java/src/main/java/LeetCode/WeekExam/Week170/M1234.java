package LeetCode.WeekExam.Week170;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Elvis on 2020/1/5.
 */
public class M1234 {
    public static void main(String[] args) {
        System.out.println("a".compareTo("afpl"));
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends[i].length; j++) {
                max = Math.max(max, friends[i][j]);
            }
        }
        max++;
        int[][] path = new int[max][max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                path[i][j] = 100000000;
            }
        }
        for (int i = 0; i < friends.length; i++) {
            int from = i;
            for (int j = 0; j < friends[i].length; j++) {
                int to = friends[i][j];
                path[from][to] = 1;
            }
        }
        int[] shortest = dijstra(path, id);
        for (int i = 0; i < shortest.length; i++) {
            if (shortest[i] == level) {
                for (int j = 0; j < watchedVideos.get(i).size(); j++) {
                    String video = watchedVideos.get(i).get(j);
                    map.put(video, map.getOrDefault(video, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> mapping : list){
            res.add(mapping.getKey());
        }
//        return map.entrySet().stream().sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
//        .thenComparing(Map.Entry::getKey)).map(Map.Entry::getKey).collect(Collectors.toList());
        return res;
    }

    public static int[] dijstra(int[][] matrix, int source) {
        int[] shortest = new int[matrix.length];
        int[] visited = new int[matrix.length];
        shortest[source] = 0;
        visited[source] = 1;
        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < matrix.length; j++) {
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }
            shortest[index] = min;
            visited[index] = 1;
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                }
            }
        }
        return shortest;
    }
}
