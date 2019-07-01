<?php


class Solution
{
    public $ret = [];
    public $trie;

    function __construct()
    {
        $this->trie = new Trie();
    }

    /**
     * @param String[][] $board
     * @param String[] $words
     * @return String[]
     */
    function findWords($board, $words)
    {
        if (!$board || !$words) return [];

        // make trie
        foreach ($words as $word) {
            $this->trie->insert($word);
        }

        for ($i = 0; $i < count($board); $i ++) {
            for ($j = 0; $j < count($board[0]); $j ++) {
                $visited = [];

                if (!$this->trie->startsWith($board[$i][$j])) {
                    continue;
                }

                if ($this->trie->search($board[$i][$j])) {
                    if (!in_array($board[$i][$j], $this->ret)) {
                        $this->ret[] = $board[$i][$j];
                    }
                }

                $visited[$i][$j] = 1;
                $start = $board[$i][$j];
                $this->dfs($board, $start, $visited, $i, $j);
            }
        }

        sort($this->ret);
        return $this->ret;
    }

    function dfs($board, $start, $visited, $i, $j)
    {
        $x = [$i - 1, $i, $i + 1, $i];
        $y = [$j, $j - 1, $j, $j + 1];
        $width = count($board);
        $height = count($board[0]);

        for ($k = 0; $k < 4; $k ++) {
            if ($x[$k] < 0 || $y[$k] < 0 || $x[$k] > $width - 1 || $y[$k] > $height - 1 || (isset($visited[$x[$k]][$y[$k]]) && $visited[$x[$k]][$y[$k]] == 1)) {
                continue;
            }

            $_start = $start . $board[$x[$k]][$y[$k]];
            if (!$this->trie->startsWith($_start)) {
                continue;
            }

            if ($this->trie->search($_start)) {
                if (!in_array($_start, $this->ret)) {
                    $this->ret[] = $_start;
                }
            }

            $visited[$x[$k]][$y[$k]] = 1;
            $this->dfs($board, $_start, $visited, $x[$k], $y[$k]);
            $visited[$x[$k]][$y[$k]] = 0;
        }
    }
}

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

$board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]];
$words = ["oath","pea","eat","rain"];
$board = [['a', 'a']];
$words = ['a'];
$board = [["b","a","a","b","a","b"],["a","b","a","a","a","a"],["a","b","a","a","a","b"],["a","b","a","b","b","a"],["a","a","b","b","a","b"],["a","a","b","b","b","a"],["a","a","b","a","a","b"]];
$words = ["bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"];
$sol = new Solution();
var_export($sol->findWords($board, $words));
//var_export($sol->trie);