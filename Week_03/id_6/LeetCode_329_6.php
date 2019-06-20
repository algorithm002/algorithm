<?php


class Solution {

    public $visited = [];

    /**
     * @param Integer[][] $matrix
     * @return Integer
     */
    function longestIncreasingPath($matrix)
    {
        if (!$matrix) return 0;

        $len = 1;

        $width = count($matrix);
        $height = count($matrix[0]);

        for ($i = 0; $i < $width; $i ++) {
            for ($j = 0; $j < $height; $j ++) {
                $len = max($len, $this->dfs($matrix, $i, $j));
            }
        }

        return $len;
    }

    function dfs($m, $i, $j)
    {
        if (isset($this->visited[$i][$j])) return $this->visited[$i][$j];

        $x = [$i - 1, $i, $i + 1, $i];
        $y = [$j, $j - 1, $j, $j + 1];
        $width = count($m);
        $height = count($m[0]);
        $len = 1;

        for ($k = 0; $k < 4; $k ++) {
            if ($x[$k] < 0 || $y[$k] < 0 || $x[$k] > $width - 1 || $y[$k] > $height - 1 || $m[$x[$k]][$y[$k]] <= $m[$i][$j]) {
                continue;
            }
            $len = max($len, $this->dfs($m, $x[$k], $y[$k]) + 1);
        }

        $this->visited[$i][$j] = $len;
        return $len;
    }
}

$m = [[9,9,4],[6,6,8],[2,1,1]];
$m = [[0],[1],[5],[5]];
$sol = new Solution();
var_dump($sol->longestIncreasingPath($m));