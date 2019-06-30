<?php

class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) 
    {
        if (count($prices) <= 1) return 0;
        
        $dp[0] = 0;
        for ($i = 1; $i < count($prices); $i ++) {
            $dp[$i] = $dp[$i - 1];
            for ($j = $i - 1; $j >= 0; $j --) {
                $profit = $prices[$i] - $prices[$j];
                if ($profit < 0) continue;
                if ($j >= 2) {
                    $dp[$i] = max($profit + $dp[$j - 2], $dp[$i]);
                } else {
                    $dp[$i] = max($profit, $dp[$i]);
                }
            }
        }
        
        return $dp[count($prices) - 1];
    }
}

$prices = [1,2];
$sol = new Solution();
var_dump($sol->maxProfit($prices));