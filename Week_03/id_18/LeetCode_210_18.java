package Week_03.id_18;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author LiveForExperience
 * @date 2019/6/19 12:09
 */
public class LeetCode_210_18 {
    public static void main(String[] args) {
        LeetCode_210_18 test = new LeetCode_210_18();
        test.findOrder(2, new int[][]{{1,0}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] record = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr: prerequisites) {
            int des = arr[0];
            int src = arr[1];
            map.computeIfAbsent(src, k -> new ArrayList<>());
            map.get(src).add(des);

            record[des]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            Integer lesson = queue.poll();
            result[i++] = lesson;
            if (map.get(lesson) != null) {
                for (Integer desLesson: map.get(lesson)) {
                    if (--record[desLesson] == 0) {
                        queue.offer(desLesson);
                    }
                }
            }
        }

        return i == numCourses ? result: new int[0];
    }
}
