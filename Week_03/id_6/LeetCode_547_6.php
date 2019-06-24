<?php


class Solution {

    public $visited = [];
    /**
     * @param Integer[][] $M
     * @return Integer
     */
    function findCircleNum($M)
    {
        if (!$M) return 0;

        $sum = 0;
        for ($i = 0; $i < count($M); $i ++) {
            if (!isset($this->visited[$i])) {
                $this->bfs($M, $i);
                $sum ++;
            }
        }

        return $sum;
    }

    function bfs($m, $i)
    {
        for ($j = 0; $j < count($m); $j ++) {
            if ($m[$i][$j] == '1' && !isset($this->visited[$j])) {
                $this->visited[$j] = 1;
                $this->bfs($m, $j);
            }
        }
    }
}

$M = [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]];
$sol = new Solution();
var_dump($sol->findCircleNum($M));