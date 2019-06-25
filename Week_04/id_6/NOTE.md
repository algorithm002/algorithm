# 学习笔记

### 208
- 定义节点类，根节点定义为空，数据结构为 
```php
class TrieNode
{
    public $children = [];
    public $is_word = false;
    public $val = null;

    function __construct($val = null)
    {
        $this->val = $val;
    }
}
```
- insert时，构建Trie树，最后一个节点 `is_word`设置为true，代表这里是单词结尾。
- search时，遍历单词每一个字符，依次从根节点判断下来，当有一个节点不匹配则判断不存在，到最后一个节点，若is_word为true，那么判断为找到。
- startWith原理同search类似，只是不用最后判断is_word。


### 211
同样是`字典树`的问题，只是由于涉及到通配符`.`，所以遇到`.`时需要递归求解。

### 212 
在`208`题trie树的基础上，使用trie树+DFS实现。  
基于words构建trie树，遍历board二维数组，对每一个遍历到的点，进行深度优先dfs搜索，成功匹配的点标记为已访问入visited数组，保证不重复访问之前遍历到的点。  
在每一个点遍历结束后，要记得清空visited已访问数组。  
基于一个点向上下左右四个方向进行DFS搜索时，每当一个方向DFS结束后，要重置当前点的visited值为0，切记！（在这里卡了我好久才发现问题）

