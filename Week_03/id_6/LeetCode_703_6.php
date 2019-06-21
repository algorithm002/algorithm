<?php

class KthLargest {

    public $nums = [];
    public $k;

    /**
     * @param Integer $k
     * @param Integer[] $nums
     */
    function __construct($k, $nums) {
        $this->k = $k;
        $this->nums = $this->quick_sort($nums);
    }

    /**
     * @param Integer $val
     * @return Integer
     */
    function add($val) {
        if (count($this->nums) == 0) {
            $this->nums[] = $val;
            return $val;
        }

        if ($val <= $this->nums[$this->k - 1]) {
            return $this->nums[$this->k - 1];
        }

        $arr = array_slice($this->nums, 0, $this->k);
        $this->nums = array_merge($this->binary_sort($arr, $val), array_slice($this->nums, $this->k - 1));
        return $this->nums[$this->k - 1];
    }

    function quick_sort($arr) {
        $len = count($arr);

        if ($len <= 1)
            return $arr;

        $left = $right = array();
        $mid_value = $arr[0];

        for ($i = 1; $i < $len; $i++)
            if ($arr[$i] > $mid_value)
                $left[] = $arr[$i];
            else
                $right[] = $arr[$i];

        return array_merge($this->quick_sort($left), (array)$mid_value, $this->quick_sort($right));
    }

    function binary_sort($arr, $num)
    {
        $left = 0;
        $right = count($arr) - 1;

        if ($arr[0] <= $num) {
            array_unshift($arr, $num);
            return $arr;
        }

        if ($arr[$right] >= $num) {
            $arr[] = $num;
            return $arr;
        }

        while ($left < $right) {
            $mid = (int)($left + $right) / 2;
            if ($num > $arr[$mid]) {
                $right = $mid;
            } else {
                $left = $mid + 1;
            }
        }

        for ($i = count($arr); $i > $left; $i --) {
            $arr[$i] = $arr[$i - 1];
        }
        $arr[$left] = $num;
        return $arr;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * $obj = KthLargest($k, $nums);
 * $ret_1 = $obj->add($val);
 */

$obj = new KthLargest(3, [4,5,8,2]);
var_dump($obj->add(3));
var_dump($obj->add(5));
var_dump($obj->add(10));
var_dump($obj->add(9));
var_dump($obj->add(4));