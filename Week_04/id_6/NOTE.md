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