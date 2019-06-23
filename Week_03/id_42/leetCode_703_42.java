public class leetCode_703_42 {
    // 主要利用了java 建立 最小堆的技巧
    int[] heap;
    int count;
    int capacity;
    public leetCode_703_42(int k, int[] nums) {
        heap = new int[k];
        capacity = k;
        count = 0;
        for (int i:nums){
            add(i);
        }
    }

    private void shiftUp(int i){
        while(i>0){
            if(heap[i]<heap[(i-1)/2]){
                swap(i,(i-1)/2);
            }
            i=(i-1)/2;
        }
    }

    private void shiftDown(){
        int i = 0;
        while(2*i+1<count){
            i = i*2 +1;
            if(i+1<count &&heap[i]>heap[i+1]){
                i++;
            }
            if(heap[(i-1)/2]>heap[i]){
                swap((i-1)/2,i);
            }
        }
    }

    private void swap(int i,int j){
        int cup = heap[i];
        heap[i] = heap[j];
        heap[j] = cup;
    }

    public int add(int val) {
        if(count < capacity){
            heap[count++]=val;
            shiftUp(count -1);
        }else if (val > heap[0]){
            heap[0] =val;
            shiftDown();
        }
        return heap[0];
    }

}
