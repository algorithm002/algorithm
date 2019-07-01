/*
 * @lc app=leetcode.cn id=720 lang=csharp
 *
 * [720] 词典中最长的单词
 */
using System;
using System.Collections.Generic;

public class Solution1 {
    // 方法1
    // 先排序，后将所有单词放入集合中，遍历每一个单词，
    // 然后对于每个单词进行每次去除末尾一个字母的循环操作，
    // 如果可以执行到单词长度为0，则与strRes进行比较，比strRes长，则替换strRes
    // public string LongestWord (string[] words) {
    //     if (words.Length == 1) {
    //         return words[0];
    //     }

    //     Array.Sort (words);
    //     string strRes = words[0];

    //     HashSet<string> hsWord = new HashSet<string> ();
    //     foreach (var word in words) {
    //         hsWord.Add (word);
    //     }

    //     foreach (var word in words) {
    //         if (word.Length <= 1 || word.Length <= strRes.Length) {
    //             continue;
    //         }
    //         string temp = word;
    //         while (temp.Length > 0) {
    //             if (!hsWord.Contains (temp)) {
    //                 break;
    //             }
    //             temp = temp.Substring (0, temp.Length - 1);
    //             if (temp.Length == 0 && strRes.Length < word.Length) {
    //                 strRes = word;
    //             }
    //         }
    //     }

    //     return strRes;
    // }

    // 方法2
    // 构建字典树（Trie），再使用深度优先遍历（dfs）遍历所有节点，找到最长单词
    // 注意点：需要存储字典树中每个节点对应的单词的位置，即代码中end，这样在深度优先比例时，可以直接从数组中取得对应单词
    // dfs，当前代码使用的是非递归，也可以使用递归
    // 此代码从国际版的官方解法中获得
    class Node {
        char c;
        public Dictionary<char, Node> children = new Dictionary<char, Node> ();
        public int end;
        public Node (char c) {
            this.c = c;
        }
    }

    class Trie {
        Node root;
        public string[] words;

        public Trie () {
            root = new Node ('0');
        }

        public void insert (string word, int index) {
            Node cur = root;
            for (int i = 0; i < word.Length; i++) {
                if (cur.children.ContainsKey (word[i])) {
                    if (cur.children[word[i]] == null) {
                        cur.children[word[i]] = new Node (word[i]);
                    }
                } else {
                    cur.children.Add (word[i], new Node (word[i]));
                }

                cur = cur.children[word[i]];
            }

            cur.end = index;
        }

        public string dfs () {
            string ans = "";
            Stack<Node> sk = new Stack<Node> ();
            sk.Push (root);
            while (sk.Count > 0) {
                Node node = sk.Pop ();
                if (node.end < 1 && node != root) {
                    continue;
                }
                if (node != root) {
                    string word = words[node.end - 1];
                    if (word.Length > ans.Length || word.Length == ans.Length && word.CompareTo (ans) < 0) {
                        ans = word;
                    }
                }

                foreach (var v in node.children.Values) {
                    sk.Push (v);
                }
            }

            return ans;
        }
    }

    public string LongestWord (string[] words) {
        Trie trie = new Trie ();
        int index = 0;
        foreach (var word in words) {
            trie.insert (word, ++index);
        }
        trie.words = words;

        return trie.dfs ();
    }
}