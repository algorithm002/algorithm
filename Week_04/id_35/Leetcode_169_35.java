package com.leecode.week04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 求众数 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * @author xuemin.zhu
 */
public class Leetcode_169_35 {

    public static void main(String[] args) {

        Leetcode_169_35 lc = new Leetcode_169_35();
        //System.out.println(lc.majorityElement(new int[]{3, 2, 3}));
        System.out.println(lc.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(lc.majorityElement(new int[]{1}));
        System.out.println(lc.majorityElement(new int[]{2,2}));
        System.out.println(lc.majorityElement(new int[]{6,5,5}));

    }

    /**
     * Boyer-Moore:
     * 思路说明：把所有数据都看成是众数和非众数两类,然后就像玩消消乐那样一个碰一个去抵消掉 这里是不一样的抵消掉
     * 因为众数是数量比较多的，把全部非众数灭掉之后还有剩，剩下的就是我们要找的众数了
     */
    public int majorityElement(int[] nums) {

        //题目中保证要有众数，两个元素的情况只能是两个一样的了
        if (nums.length == 1 || nums.length == 2) {
            return nums[0];
        }

        int majorIndex = 0;//首先选择0作为众数
        int majorCount = 0;//当前众数的计数个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[majorIndex]) {
                majorCount++;
            } else {
                majorCount--;
            }

            if (majorCount == 0) {
                //当前众数是0之后需要重新选举新的众数,i 会在经过majorCount时majorCount会变成1
                majorIndex = i + 1;

            }
        }

        return nums[majorIndex];
    }


    /**
     * 思路1：最直接的搞法就是先计算出每个数字出现的次数，再看看是不是超过n/2 这里想试试jdk8中新式写法^^
     */

    public int majorityElement_v1(int[] nums) {

        Map<String, Long> map = Arrays.stream(nums)
            .mapToObj(num -> new Tuple(String.valueOf(num), num))
            .collect(Collectors.groupingBy(Tuple::getKey, Collectors.counting()));

        List<Entry<String, Long>> entrys = map.entrySet().stream()
            .filter(s -> s.getValue() > nums.length / 2).collect(Collectors.toList());

        if (entrys.isEmpty() || entrys.size() != 1) {
            return -1;
        }

        return Integer.valueOf(entrys.get(0).getKey());
    }

    static class Tuple {

        private String key;
        private Integer val;

        public Tuple(String key, Integer val) {
            this.key = key;
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
