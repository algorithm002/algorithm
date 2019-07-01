<?php

class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n) {
        if ($n == 1) return 1;
        if ($n == 2) return 2;

        $sum[1] = 1;
        $sum[2] = 2;
        for ($i = 3; $i <= $n; $i ++) {
            $sum[$i] = $sum[$i - 1] + $sum[$i - 2];
        }

        return $sum[$n];    
    }
    
}