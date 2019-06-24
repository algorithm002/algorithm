<?php


class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k)
    {
        if ($k == 0) return;
        $len = count($nums);
        $k %= $len;

        $this->reverse($nums, 0, $len - 1);
        $this->reverse($nums, 0, $k - 1);
        $this->reverse($nums, $k, $len - 1);

        return;
    }

    /**
     * revert an array
     *
     * @param $nums
     * @param $start
     * @param $end
     */
    private function reverse(&$nums, $start, $end)
    {
        while ($start < $end) {
            $tmp = $nums[$start];
            $nums[$start] = $nums[$end];
            $nums[$end] = $tmp;

            $start ++;
            $end --;
        }

        return;
    }
}

$nums = [1,2,3,4,5,6,7];
$sol = new Solution();
$sol->rotate2($nums, 3);
var_export($nums);