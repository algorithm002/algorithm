<?php


class Solution {

    /**
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid)
    {
        if (empty($grid)) return 0;

        $sum = 0;
        $width = count($grid);
        $height = count($grid[0]);
        for ($i = 0; $i < $width; $i ++) {
            for ($j = 0; $j < $height; $j ++) {
                if ($grid[$i][$j] == '1') {
                    $sum ++;
                    $this->bfs($grid, $i, $j);
                }
            }
        }

        return $sum;
    }

    function bfs(&$grid, $i, $j)
    {
        $x = [$i - 1, $i, $i + 1, $i];
        $y = [$j, $j - 1, $j, $j + 1];
        $width = count($grid);
        $height = count($grid[0]);

        for ($k = 0; $k < 4; $k ++) {
            if ($x[$k] < 0 || $y[$k] < 0 || $x[$k] > $width - 1 || $y[$k] > $height - 1 || $grid[$x[$k]][$y[$k]] == '0') {
                continue;
            }

            $grid[$x[$k]][$y[$k]] = '0';
            $this->bfs($grid, $x[$k], $y[$k]);
        }
    }
}

$grid = [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]];
$sol = new Solution();
var_dump($sol->numIslands($grid));