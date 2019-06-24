/**
 * @param {number[][]} dungeon
 * @return {number}
 * https://leetcode.com/problems/dungeon-game/
 */
var calculateMinimumHP = function(dungeon) {
    if (!dungeon || dungeon.length == 0 || dungeon[0].length == 0) return 0;
    let m = dungeon.length;
    let n = dungeon[0].length; 
    let health = buildArray(m,n);
     console.log(m);
      console.log(n);
    console.log(health);
    
    health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
    
    for(let i = m - 2; i >= 0; i--)
    {
        health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
    }
    for (let j = n - 2; j >= 0; j--) {
        health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
    }
    for (let i = m - 2; i >= 0; i--) {
        for (let j = n - 2; j >= 0; j--) {
            let down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
            let right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
            health[i][j] = Math.min(right, down);
        }
    }
    return health[0][0]; 
    
};

function buildArray(m,n)
{
    let result = new Array();
    for(let i = 0; i <m;i++)
    {
        let row= new Array();
        for(let j= 0;j<n;j++)
         { 
             row.push(0);
         }   
        result.push(row);
    }    
    return result;
}

let input =[[2],[1]];
console.log(calculateMinimumHP(input));


 