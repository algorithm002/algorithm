<?php

class Solution {

    public $sets = [];
    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function subsets($nums)
    {
        $this->backTracing($nums, [], 0);
        return $this->sets;
    }

    private function backTracing($nums, $tmp, $i)
    {
        $this->sets[] = $tmp;
        for ($j = $i; $j < count($nums); $j ++) {
            $tmp[$j] = $nums[$j];
            $this->backTracing($nums, $tmp, $j + 1);
            unset($tmp[$j]);
        }
    }
}

$nums = [1,2,3];
$sol = new Solution();
var_dump($sol->subsets($nums));