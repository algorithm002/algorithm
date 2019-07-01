<?php

class WordDictionary
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
     * Adds a word into the data structure.
     * @param String $word
     * @return NULL
     */
    function addWord($word)
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     * @param String $word
     * @return Boolean
     */
    function search($word)
    {
        if (!$word) return true;
        $node = $this->root;
        return $this->searchRec($word, $node, 0);
    }

    /**
     * @param $word
     * @param TrieNode $node
     * @param $pos
     * @return boolean
     */
    private function searchRec($word, $node, $pos)
    {
        if ($pos == strlen($word)) return $node->is_word;
        if ($word[$pos] == '.') {
            $pos ++;
            foreach ($node->children as $child) {
                if ($this->searchRec($word, $child, $pos)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!isset($node->children[$word[$pos]])) return false;
        }

        return $this->searchRec($word, $node->children[$word[$pos]], $pos + 1);
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
 * Your WordDictionary object will be instantiated and called as such:
 * $obj = WordDictionary();
 * $obj->addWord($word);
 * $ret_2 = $obj->search($word);
 */

$obj = new WordDictionary();
$obj->addWord('at');
$obj->addWord('and');
$obj->addWord('an');
$obj->addWord('add');
var_export($obj);
var_dump($obj->search('a'));
var_dump($obj->search('.at'));
$obj->addWord('bat');
var_export($obj);
var_dump($obj->search('.at'));
var_dump($obj->search('b..'));
