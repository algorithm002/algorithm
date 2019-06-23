//In a directed graph, we start at some node and every turn, walk along a directed edge of the graph. If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
//
// Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node. More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
//
// Which nodes are eventually safe? Return them as an array in sorted order.
//
// The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph. The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
//
//
//Example:
//Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//Output: [2,4,5,6]
//Here is a diagram of the above graph.
//
//
//
//
//
// Note:
//
//
// graph will have length at most 10000.
// The number of edges in the graph will not exceed 32000.
// Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
//
//

package com.llz.algorithm.algorithm2019.thirdweek;

import java.util.*;

public class LeetCode_802_2 {

    private List<Integer>[] linkList;

    /**
     * My original version by using topological sort.
     * <p>
     * Time complexity is O(N+E) and space complexity is O(N+E) either.
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodesByKahn(int[][] graph) {
        int[] degrees = new int[graph.length]; //out-degree
        linkList = new LinkedList[graph.length];
        for (int i = 0; i < graph.length; i++) {
            linkList[i] = new LinkedList<>();
        }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            degrees[i] = graph[i].length;
            if (graph[i].length == 0) {
                queue.add(i);
            } else {
                for (int j = 0; j < graph[i].length; j++) {
                    linkList[graph[i][j]].add(i);
                }
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.remove();
            list.add(node);
            for (int i = 0; i < linkList[node].size(); i++) {
                int lastNode = linkList[node].get(i);
                if (--degrees[lastNode] == 0)
                    queue.add(lastNode);
            }
        }
        list.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    /**
     * Referenced from discussion by using white-grey-black dfs method.
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodesByDFS(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0)
            return color[node] == 2;

        color[node] = 1;
        for (int nei : graph[node]) {
            if (color[node] == 2)
                continue;
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }

        color[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        //  Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
        int[] g0 = {1, 2};
        int[] g1 = {2, 3};
        int[] g2 = {5};
        int[] g3 = {0};
        int[] g4 = {5};
        int[] g5 = {};
        int[] g6 = {};
        int[][] graph = {g0, g1, g2, g3, g4, g5, g6};
        LeetCode_802_2 l = new LeetCode_802_2();
        System.out.println(l.eventualSafeNodesByDFS(graph));
    }
}
