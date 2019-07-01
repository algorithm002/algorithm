<?php

class Solution {

    /**
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    function findContentChildren($g, $s)
    {
        if (empty($s) || empty($g)) return 0;

        sort($g);
        sort($s);
        $num = 0;
        foreach ($g as $v) {
            $num1 = 0;
            foreach ($s as $k => $v1) {
                if ($v1 >= $v) {
                    $num1 ++;
                    unset($s[$k]);
                    break;
                }
            }
            $num += $num1;
            if ($num1 == 0 || empty($s)) return $num;
        }
        return $num;
    }
}

$sol = new Solution();
$g= [1,2,3];
$s = [3];
var_dump($sol->findContentChildren($g, $s));