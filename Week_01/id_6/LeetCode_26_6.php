<?php


class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums)
    {
        $flag = 1;
        $num = $nums[0];
        for ($i = 1; $i < count($nums); $i ++) {
            if ($nums[$i] == $num) {
                unset($nums[$i]);
            } else {
                $num = $nums[$i];
                $flag++;
            }
        }

        return $flag;
    }
}

$nums = [0,0,1,1,1,2,2,3,3,4];
$sol = new Solution();
echo $sol->removeDuplicates($nums);