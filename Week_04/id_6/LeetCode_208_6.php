<?php


class Trie
{
    public $root;

    /**
     * Initialize your data structure here.
     */
    function __construct()
    {
        $this->root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word)
    {
        if (!$word) return;

        $node = $this->root;
        for ($i = 0; $i < strlen($word); $i ++) {
            if (!isset($node->children[$word[$i]])) {
                $node->children[$word[$i]] = new TrieNode($word[$i]);
            }

            $node = $node->children[$word[$i]];
        }
        $node->is_word = true;
    }

    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word)
    {
        $node = $this->root;
        for ($i = 0; $i < strlen($word); $i ++) {
            if (!isset($node->children[$word[$i]])) return false;
            $node = $node->children[$word[$i]];
        }

        return $node->is_word;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix)
    {
        $node = $this->root;
        for ($i = 0; $i < strlen($prefix); $i ++) {
            if (!isset($node->children[$prefix[$i]])) return false;
            $node = $node->children[$prefix[$i]];
        }

        return true;
    }
}

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

/**
 * Your Trie object will be instantiated and called as such:
 * $obj = Trie();
 * $obj->insert($word);
 * $ret_2 = $obj->search($word);
 * $ret_3 = $obj->startsWith($prefix);
 */

$obj = new Trie();
$obj->insert('apple');
$ret_2 = $obj->search('apple');
$ret_3 = $obj->startsWith('app');
var_dump($obj, $ret_2, $ret_3);