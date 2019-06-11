//https://leetcode.com/problems/top-k-frequent-words/
/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function(words, k) {
    let hash = new Map();
    words.forEach(word => {
        if(hash.get(word))
        {
            hash.set(word,hash.get(word)+1);
        }
        else
        {
            hash.set(word,1);
        }
    });  
    let array= new Array();
    hash.forEach(
        function(value, key, map)
        {
            let node= new CustomerNode(key,value); 
            array.push(node); 
        }
    ) 
    array.sort(function(a,b){
        if(a.count==b.count)
        {
            if(a.val < b.val)
            {
                return -1;
            }
            else
            return 1; 
        }
        return   b.count- a.count ;
    }
    )   
    
    let result = new Array();
    let index=0;
    while(k>0)
    {
        result.push(array[index].val);
        index++;
        k--;
    }
    return result;
};

function CustomerNode(val,count) {
     this.val = val;
     this.count = count
}
let words = ["glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"];

let k = 14

console.log(topKFrequent(words,k));
