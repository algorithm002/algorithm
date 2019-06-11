//https://leetcode.com/problems/longest-substring-without-repeating-characters/

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if(!s) return 0;
    if(s.length==1 || s.length==0) return s.length;
    let hash = new Map();  
    let max= 0; 
    for (let index = 0; index < s.length; index++) {
        let start = index;
        let length = 0;
        while(start < s.length)
        {
            if(!hash.get(s.charAt(start))) 
            {
                hash.set(s.charAt(start),1);
                length ++;
                max = Math.max(max,length);
                start++;
            }
            else
            {
                max = Math.max(max,length);
                hash.clear();
                break;
            }

        }
        
    }
    
    return max;

};

let input = "au";
console.log(lengthOfLongestSubstring(input));
