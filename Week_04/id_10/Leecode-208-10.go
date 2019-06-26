package leecode

type Trie struct {
	words  []*Trie
	val    byte
	is_end bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	root := Trie{words: make([]*Trie, 26), is_end: false}
	return root
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	root := this
	for i := 0; i < len(word); i++ {
		c := word[i] - 'a'
		if root.words[c] == nil {
			root.words[c] = &Trie{words: make([]*Trie, 26), val: word[i], is_end: false}
		}
		root = root.words[c]
	}
	root.is_end = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	root := this
	for i := 0; i < len(word); i++ {
		c := word[i] - 'a'
		if root.words[c] != nil {
			root = root.words[c]
		} else {
			return false
		}
	}
	return root.is_end
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	root := this
	for i := 0; i < len(prefix); i++ {
		c := prefix[i] - 'a'
		if root.words[c] != nil {
			root = root.words[c]
		} else {
			return false
		}
	}
	return true
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
