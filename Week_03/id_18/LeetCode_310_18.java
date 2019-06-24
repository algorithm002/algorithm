package Week_03.id_18;

import java.util.*;

/**
 * @author LiveForExperience
 * @date 2019/6/24 11:59
 */
public class LeetCode_310_18 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<>());
        }
        for (int[] edge: edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();
            for (int leave: leaves) {
                int node = list.get(leave).iterator().next();
                list.get(node).remove(leave);
                if (list.get(node).size() == 1) {
                    newLeaves.add(node);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
