一周刷题感想
比上周进步的地方：每道题多写了不同的解法，给出空间复杂度和时间复杂度。注意了代码的clean。
3:滑动窗口没做过类似题型，直接看答案
比较tricky的地方在于使用滑动窗口的优化版本解法，判断指针starter初始值i = Math.max(map.get(c) + 1, i);，为什么不直接是i=map.get(c)+1，这个很难想到，
只有在你遇到了tmmzuxt的test case，才会恍然大悟。
98：非常容易想到通过In Order Traverse获取整个BST的节点值list，再判断该list是否有序即可。题解中有只用traverse的方法获得答案，关键是要想到增加upper,lower这几个变量，并且在遍历过程中想到如何更新lower和upper。这个方法速度是最快的。
692:topk问题立马想到堆，很快实现出来，看了下解答用了java jdk8的内容用函数式编程的方式节省了相当多的代码。值得学习。
101:第二次做，用了两种解法，基本树的题目都是那个套路，要么递归要么迭代。这个巧的地方，在于需要想到用两个root（其中一个是mirror node）。
102:bfs做lever order基本都想得到，看到解法中有dfs，通过指定height这种想法挺有意思的。
103:和102不一样在于遍历完一层要反过来，我自己的解法不是很好用了两个queue，解法只用了一个queue，思路比我清晰，想到了利用list.add(0,value)这个方法，不需要改变queue的存储数据的方式。
111:用了5种方法，不停地重构，写出更优的代码。
235:比较简单，利用bst特性，traverse要好写很多。
236:第二次做，用递归方法仍然需要参考discussion，用迭代很快写出来了。所以得反复练习。递归要想到left，mid，right这样去遍历判断节点是否存在真的挺难的。我觉得有返回值的遍历都比没有返回值的难。
783:递归想到用个pre存放上一个值，比较的时候Math.min(root.val-pre.val, minDist）有点难想到。
983:比较简单。
下周改进的地方：争取刷更多的题，然后争取在deadline前留下更宽裕的时间。另外做算法题一定要focus,focus,focus,提升效率。