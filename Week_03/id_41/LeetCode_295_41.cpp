/*
 * @lc app=leetcode id=295 lang=cpp
 *
 * [295] Find Median from Data Stream
 * T(n) = O(1)
 * S(n) = O(N)
 */
class MedianFinder
{
public:
    /** initialize your data structure here. */
    MedianFinder()
    {
        
    }

    void addNum(int num)
    {
        small.push(num);
        large.push(-small.top());
        small.pop();
        if (small.size() < large.size())
        {
            small.push(-large.top());
            large.pop();
        }
    }

    double findMedian()
    {
        if (small.size() > large.size())
            return small.top();
        else
            return (small.top() - large.top()) / 2.0;
    }
private:
    priority_queue<long> small;
    priority_queue<long> large;    
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
