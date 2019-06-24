"""
Week2做过 这里整理一下思路
最简单的方式是BFS加上结果部分倒序
复杂的方式则是在BFS的时候就进行倒序，减少一次倒序操作
BFS由于有倒序层，而在倒序迭代倒序层的同时又要保证下一层顺序遍历。
所以倒序层需要使用队列由后向前插入数据，并且先右后左
例如 [1,2,3]倒序遍历,3的子节点[e,f]先f后e的插入队列前端
这次使用collections的队列
"""
import collections


class Solution:
    def zigzagLevelOrder(self, root):
        if not root:
            return []
        results = []
        queue = collections.deque([root])
        while queue:
            need_reverse = len(results) % 2 == 1
            result = []
            if need_reverse:
                for _ in range(len(queue)):
                    node = queue.pop()
                    if not node:
                        continue
                    result.append(node.val)
                    node.right and queue.appendleft(node.right)
                    node.left and queue.appendleft(node.left)
            else:
                for _ in range(len(queue)):
                    node = queue.popleft()
                    if not node:
                        continue
                    result.append(node.val)
                    node.left and queue.append(node.left)
                    node.right and queue.append(node.right)
            results.append(result)

        return results
