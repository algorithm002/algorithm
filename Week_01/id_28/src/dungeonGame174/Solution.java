package dungeonGame174;

public class Solution {
    Integer[][] cache;
    public int calculateMinimumHP(int[][] dungeon) {

        cache=new Integer[dungeon.length][dungeon[0].length];
        return Math.max(1,getMinNum(0,0,dungeon)-dungeon[0][0]);
    }

    public int getMinNum(int i,int j,int[][] dungeon){
        if(cache[i][j]!=null){
            return cache[i][j];
        }
        if(i==dungeon.length-1&&j==dungeon[0].length-1){
            cache[i][j]=1;
        }else if(i==dungeon.length-1){
            cache[i][j]=Math.max(1,getMinNum(i,j+1,dungeon)-dungeon[i][j+1]);
        }else if(j==dungeon[0].length-1){
            cache[i][j]=Math.max(1,getMinNum(i+1,j,dungeon)-dungeon[i+1][j]);
        }else {
            cache[i][j]=Math.max(1,Math.min(getMinNum(i,j+1,dungeon)-dungeon[i][j+1],getMinNum(i+1,j,dungeon)-dungeon[i+1][j]));
        }
        return cache[i][j];
    }
}
