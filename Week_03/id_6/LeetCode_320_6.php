<?php


class Solution {

    /**
     * @param Integer $n
     * @param Integer[][] $edges
     * @return Integer[]
     */
    function findMinHeightTrees($n, $edges)
    {
        if ($n == 1) return [0];

        $adj = [];
        foreach ($edges as $edge) {
            $adj[$edge[0]][] = $edge[1];
            $adj[$edge[1]][] = $edge[0];
        }

        $leaves = [];
        for ($i = 0; $i < $n; $i ++) {
            if (count($adj[$i]) == 1) {
                $leaves[] = $i;
            }
        }

        while ($n > 2) {
            $n -= count($leaves);
            foreach ($leaves as $k => $leaf) {
                $root = current($adj[$leaf]);
                $key = array_search($leaf, $adj[$root]);
                unset($adj[$root][$key]);
                unset($leaves[$k]);
                if (count($adj[$root]) == 1) {
                    $leaves[] = $root;
                }
            }
        }

        return $leaves;
    }
}

$n = 4;
$edges = [[1, 0], [1, 2], [1, 3]];
$n = 6;
$edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]];

$n = 11;
$edges = [[0,1],[0,2],[2,3],[0,4],[2,5],[5,6],[3,7],[6,8],[8,9],[9,10]];

$sol = new Solution();
var_dump($sol->findMinHeightTrees($n, $edges));