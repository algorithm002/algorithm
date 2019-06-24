<?php

class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $hash = [];
        $len = strlen($s);
        $count = $i = $j = 0;
        while ($i < $len && $j < $len) {
            if (!isset($hash[$s[$j]])) {
                $hash[$s[$j]] = 1;
                $j ++;
                $count = max($count, $j - $i);
            } else {
                unset($hash[$s[$i]]);
                $i ++;
            }
        }

        return $count;
    }
}

$sol = new Solution();
$s = "abcabcbb";
var_dump($sol->lengthOfLongestSubstring($s));