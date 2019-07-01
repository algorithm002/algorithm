<?php

class Solution {

    /**
     * @param Integer[] $prices
     * @param Integer $fee
     * @return Integer
     */
    function maxProfit($prices, $fee)
    {
        if (count($prices) <= 1) return 0;

        $min = $prices[0];
        $profit = 0;
        for ($i = 1; $i < count($prices); $i ++) {
            if ($prices[$i] < $min) {
                $min = $prices[$i];
            }

            if ($prices[$i] - $min > $fee) {
                $profit += ($prices[$i] - $min - $fee);
                $min = $prices[$i] - $fee;
            }
        }

        return $profit;
    }
}

$prices = [1, 3, 2, 8, 4, 9];
$fee = 2;
$sol = new Solution();
var_dump($sol->maxProfit($prices, $fee));