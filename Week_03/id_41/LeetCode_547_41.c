/*
 * @lc app=leetcode id=547 lang=c
 *
 * [547] Friend Circles
 * T(n) = O(MSize)
 * S(n) = O(MSize)
 */

#define MAX_NUM_STUDENTS (200)

static void makeSet(int *roots, int MSize)
{
    for (int i = 0; i < MSize; i++)
    {
        roots[i] = i;
    }
}

static int find(int *roots, int i)
{
    if (roots[i] == i)
        return i;

    while (i != roots[i])
    {
        roots[i] = roots[roots[i]];
        i = roots[i];
    }    
    return roots[i];
}

static void unionCircles(int** M, int* circles, int MSize)
{
    for (int i = 0; i < MSize - 1; i++)
    {
        for (int j = i + 1; j < MSize; j++)
        {
            int rootI = find(circles, i);
            int rootJ = find(circles, j);
            if (M[i][j] == 1)
            {
                circles[rootI] = rootJ;
            }
        }
    }
}

static int getCirCleCount(int* circles, int MSize)
{
    int count = 0;
    for (int i = 0; i < MSize; i++)
    {
        if (circles[i] == i)
            count++;
    }
    return count;
}

int findCircleNum(int** M, int MSize, int* MColSize){
    int circlesNum = 0;
    int circles[MAX_NUM_STUDENTS] = {0};
    if (MSize == 0 || *MColSize == 0)
        return 0;

    makeSet(circles, MSize);
    unionCircles(M, circles, MSize);
    circlesNum = getCirCleCount(circles, MSize);
    return circlesNum;
}
