## 前言

### 题目1
[Leetcode#26 移除数组中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

### 难点分析
> 这道题目的难点在于对空间复杂度的限制，不能使用外部辅助的数据结构，必须在原地完成这个操作。

### 解题思路
> 首先想到先把"原地删除数组中某一个给定位置的元素"的这个方法抽象出来。由于数组对删除可添加元素并不是非常友好，这个操作的复杂度为O(n)，从给定的位置index开始，每一个元素要依次等于后面的元素。这一步细节在于，由于需要有一个i+1的判断，所以i的取值上限为array.length-1。接下来的思路是明确触发这个删除操作的时机，大致的思路是，对于数组中的所有元素，用一个for循环，判断所有在它后面的元素，如果元素不相等，则将number的统计值加一，同时退出当前元素的判断。如果后面的元素和当前元素相等，就调用之前我们封装的删除特定位置的数组元素的方法，删除。这里的难点同样在于原地操作，删除后需要对原始数组有一个状态的更新。包括两部分：1.总的需要判断的数组长度减1。2.待判断元素的下表不能增加，因为已经删了一个了，所以下一个其实就是当前。

### 参考代码AC
```Java
class Solution {
    public int removeDuplicates(int[] nums) {
        int numbers = 0;
        int arrayLength = nums.length;
        for (int i=0; i<arrayLength; i++) {
            for(int j=i+1; j<arrayLength; j++) {
                if(nums[i]!=nums[j]) {
                    numbers ++;
                    break;
                } else if (nums[i] == nums[j]){
                    removeElementArray(nums, j);
                    arrayLength = arrayLength-1;
                    j = j-1;
                }
            }
        }
        return numbers+1;
    }

    public void removeElementArray(int[] array, int index) {
        for (int i=index; i<array.length-1; i++) {
            array[i] = array[i+1];
        }
    }
}
```

### 题目2
[Leetcode#189 旋转数组](https://leetcode-cn.com/problems/rotate-array/)
### 难点分析
>这道题目的难点在于对空间复杂度的限制，不能使用外部辅助的数据结构，必须在原地完成这个操作。其次题目中的有些测试用例K可能大于数组长度，这样就需要引入取模操作。

### 解题思路
>解决这种数组的题目，特别是下标操作比较绕的题目，比较好的方式就是多举一些例子。我在做这道题的时候，其实一开始没有想到要求模。有些边界的情况其实可以通过多提交几次来添加。大体的思路是首先把那些需要移到右边的节点保存下来，然后从后往前把ｎ－ｋ个元素移到后边，最后再把空出来的那些空位用之前保存下来的那些元素补上。

### 参考AC代码
```Java
class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k%nums.length;
        }
        int[] rememberArray = new int[k];
        int j = 0;
        for (int i = nums.length-k; i< nums.length; i++) {
            rememberArray[j] = nums[i];
            j++;
        }
        for (int i=nums.length-k-1; i>=0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i=0; i<k; i++) {
            nums[i] = rememberArray[i];
        }
    }
}
```
