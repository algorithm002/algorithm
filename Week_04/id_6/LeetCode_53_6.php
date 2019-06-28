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
        $max = 0;
        for ($i = 0; $i < count($nums); $i ++) {
            if ($max + $nums[$i] > $max) {
                $max = $max + $nums[$i];
            }
        }
    }
}