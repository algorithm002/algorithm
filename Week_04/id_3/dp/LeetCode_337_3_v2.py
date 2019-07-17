"""
DP的思路目前是广度优先策略用dict缓存父级的递归结果
不过卡住了，自从向叶的dp似乎最终很难汇集一个结果，得试试自叶向根了。
====================
看了各路答案，思路本题很难用递推处理 失败
"""


class Solution:
    def rob(self, root) -> int:
        if not root:
            return 0

        cache = {id(root): (0, 0)}
        queue = [root]

        result = 0
        while queue:
            _queue = []
            _cache = {}
            for node in queue:
                p1, p2 = cache[id(node)]
                r = (max(p1, p2), p1 + node.val)
                if not node.left and not node.right:
                    pass

        return result
