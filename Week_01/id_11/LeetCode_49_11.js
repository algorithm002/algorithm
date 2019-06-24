/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    
    let anaSet = {}
    
    strs.forEach(str => {
        let sortedStr = Array.from(str).sort().join()
        if(anaSet[sortedStr]){
            anaSet[sortedStr].push(str)
        }
        else{
            anaSet[sortedStr] = []  
            anaSet[sortedStr].push(str)
        }
        
    })
    
    let arr = []
    console.log(anaSet)
    Object.keys(anaSet).forEach(ana => {
        arr.push(anaSet[ana])
    })
    return arr
};