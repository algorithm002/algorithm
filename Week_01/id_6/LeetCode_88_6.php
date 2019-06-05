<?php

class Solution
{

    /**
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    function merge(&$nums1, $m, $nums2, $n)
    {
        $len = $m + $n;
        while ($m > 0 && $n > 0) {
            if ($nums1[$m - 1] > $nums2[$n - 1]) {
                $nums1[$len - 1] = $nums1[$m - 1];
                $m --;
            } else {
                $nums1[$len - 1] = $nums2[$n - 1];
                $n --;
            }
            $len --;
        }

        while ($n > 0) {
            $nums1[$len - 1] = $nums2[$n - 1];
            $n --;
            $len --;
        }

        return;
    }
}

$nums1 = [2,0];
$m = 1;

$nums2 = [1];
$n = 1;
/*
$nums1 = [1,2,3,0,0,0];
$m = 3;

$nums2 = [2,5,6];
$n = 3;*/

$sol = new Solution();
$sol->merge($nums1, $m, $nums2, $n);
var_export($nums1);
