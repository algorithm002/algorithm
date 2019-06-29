<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function maxSubArray($nums)
    {
        if (!$nums) return 0;

        $sum = 0;
        $max = $nums[0];
        for ($i = 0; $i < count($nums); $i ++) {
            if ($sum > 0) {
                $sum += $nums[$i];
            } else {
                $sum = $nums[$i];
            }
            $max = max($max, $sum);
        }

        return $max;
    }
}

$sol = new Solution;
$nums = [-2,1,-3,4,-1,2,1,-5,4];
var_dump($sol->maxSubArray($nums));