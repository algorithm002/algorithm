# 学习笔记


## 做的这两道都是Trie树的题目

### leet_code 208 题目的意思为 构造Trie树的结构
 
这个题目要记住两点：

  1.TireNode 这种数据元素
```java
   class TrieNode{
        private TrieNode[] son;
        private boolean isWord;
        private char val;
        TrieNode(){
            son = new TrieNode[SIZE];
            isWord = false;
        }
    } 
    
```
  2. 三种操作
      insert startwith  search 
      
      
### leetcode 211 则是在208 的基础上增加了模式匹配
      
 利用了程序中递归 和循环遍历的小技巧       