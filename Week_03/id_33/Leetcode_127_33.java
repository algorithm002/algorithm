/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList)  {
        if (!wordList.contains(endWord)) return 0;
        int level = 1;
        Set<String> set = new HashSet<>();
         for(String word: wordList){
             set.add(word);
         }
         Queue<String> queue = new LinkedList<>();
         queue.offer(beginWord);
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i = 0; i < size; i++){
                 String tmpWord = queue.poll();
                 char[] array = tmpWord.toCharArray();
                 for(int j = 0; j < array.length; j++){
                     char c = array[j];
                     for(char k = 'a'; k <= 'z'; k++){
                         array[j] = k;
                         String newWord = String.valueOf(array);
                         if(k != c &&set.contains(newWord)){
                             queue.offer(newWord);
                             set.remove(newWord);
                             if(newWord.equals(endWord)){
                                 return ++level;
                             }
                         }
                     }
                     array[j] = c;
                 }
             }
             level++;
         }
         return 0;
     }
}

