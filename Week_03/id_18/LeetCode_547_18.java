package Week_03.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/22 19:07
 */
public class LeetCode_547_18 {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    private class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int n) {
            while (n != this.parent[n]) {
                this.parent[n] = this.parent[this.parent[n]];
                n = this.parent[n];
            }
            return n;
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            count--;
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        LeetCode_547_18 solution = new LeetCode_547_18();
        int res = solution.findCircleNum(M);
        System.out.println(res);
    }
}
