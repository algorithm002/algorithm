<?php

class MedianFinder {

    public $arr;

    /**
     * initialize your data structure here.
     */
    function __construct() {
        $this->arr = [];
    }

    /**
     * @param Integer $num
     * @return NULL
     */
    function addNum($num) {
        if (count($this->arr) == 0) {
            $this->arr[] = $num;
            return;
        }

        $left = 0;
        $right = count($this->arr) - 1;

        if ($this->arr[0] >= $num) {
            array_unshift($this->arr, $num);
            return;
        }

        if ($this->arr[$right] <= $num) {
            $this->arr[] = $num;
            return;
        }

        while ($left < $right) {
            $mid = (int)($left + $right) / 2;
            if ($num <= $this->arr[$mid]) {
                $right = $mid;
            } else {
                $left = $mid + 1;
            }
        }

        for ($i = count($this->arr); $i > $left; $i --) {
            $this->arr[$i] = $this->arr[$i - 1];
        }
        $this->arr[$left] = $num;
        return;
    }

    /**
     * @return Float
     */
    function findMedian() {
        $len = count($this->arr);
        if ($len & 1) {
            return $this->arr[(int)($len / 2)];
        }

        return (float)($this->arr[$len / 2 - 1] + $this->arr[$len / 2]) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * $obj = MedianFinder();
 * $obj->addNum($num);
 * $ret_2 = $obj->findMedian();
 */

$obj = new MedianFinder();
$obj->addNum(1);var_dump($obj->arr);
var_dump($obj->findMedian());
$obj->addNum(2);var_dump($obj->arr);
var_dump($obj->findMedian());
$obj->addNum(3);var_dump($obj->arr);
var_dump($obj->findMedian());
$obj->addNum(14);var_dump($obj->arr);
var_dump($obj->findMedian());
$obj->addNum(35);var_dump($obj->arr);
var_dump($obj->findMedian());
$obj->addNum(19);var_dump($obj->arr);
var_dump($obj->findMedian());
$obj->addNum(34);var_dump($obj->arr);
var_dump($obj->findMedian());