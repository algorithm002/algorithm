package id_1;

import java.util.PriorityQueue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/17  10:34
 * @描述      LeetCode : 703. 数据流中的第K大元素      https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class LeetCode_703_1 {
    public static void main(String[] args) {
//        KthLargest largest = new KthLargest(3, new int[]{4, 5, 8, 2});
//        System.out.println(largest.add(3));
//        System.out.println(largest.add(5));
//        System.out.println(largest.add(10));
//        System.out.println(largest.add(9));
//        System.out.println(largest.add(4));
        int year=20;
        int money=10000;
        double rate=0.05;
        System.out.println("-----------------------------------------------");
        comppounding(10,10000,0.05);
        comppounding(20,10000,0.05);
        comppounding(30,10000,0.05);
        System.out.println("-----------------------------------------------");
        comppounding(10,10000,0.08);
        comppounding(20,10000,0.08);
        comppounding(30,10000,0.08);
        System.out.println("-----------------------------------------------");
        comppounding(10,10000,0.1);
        comppounding(20,10000,0.1);
        comppounding(30,10000,0.1);
        System.out.println("-----------------------------------------------");
        comppounding(10,20000,0.05);
        comppounding(20,20000,0.05);
        comppounding(30,20000,0.05);
        System.out.println("-----------------------------------------------");
        comppounding(10,20000,0.08);
        comppounding(20,20000,0.08);
        comppounding(30,20000,0.08);
        System.out.println("-----------------------------------------------");
        comppounding(10,20000,0.1);
        comppounding(20,20000,0.1);
        comppounding(30,20000,0.1);
        System.out.println("-----------------------------------------------");
        comppounding(10,10000,0.045);
        comppounding(20,10000,0.045);
        comppounding(30,10000,0.045);
        System.out.println("-----------------------------------------------");
        comppounding(10,20000,0.045);
        comppounding(20,20000,0.045);
        comppounding(30,20000,0.045);
        comppounding(40,20000,0.045);
        comppounding(50,20000,0.045);
    }

    /**
     *  复利计算 小程序
     */
    private static void comppounding(int year,int money,double rate){
        double sum=0;
        for(int i=0;i<year;i++){
            double temp=sum+money;
            sum = temp * rate + temp;
//            System.out.println("年利率："+rate+",存款"+year+"年，第"+(i+1)+"年的钱："+sum);
        }
        System.out.println("年利率："+rate+",存款"+money+"元，第"+year+"年的钱："+sum);

//        System.out.println(sum);

    }

    /**
     *  Method 1 :  因为题目的特殊性，只有添加从操作，维护最大队列里面的最小值即可；
     *      小于最小值 不用添加进入队列
     *      大于最小值 ，最小值出队列，队列再添加当前值，以此类推
     */
    static class KthLargest {

        PriorityQueue<Integer> queue;
        int k=0;
        public KthLargest(int k, int[] nums) {
            queue=new PriorityQueue(k);
            this.k=k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if(queue.size()<k) queue.offer(val);
            else if (queue.peek()<val) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }
}
