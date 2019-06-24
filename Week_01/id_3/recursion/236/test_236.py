class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def build(nums):
    if not nums:
        return None

    return build_node(nums, 1)


def build_node(nums, i):
    if len(nums) < i or nums[i-1] is None:
        return None
    node = TreeNode(nums[i-1])
    node.left = build_node(nums, 2 * i)
    node.right = build_node(nums, 2 * i + 1)
    return node


import lc_236_v1

f = lc_236_v1.lowest_common_ancestor


def check(nums, p, q, r):
    _r = f(build(nums), TreeNode(p), TreeNode(q))
    print(_r.val, r, _r.val == r)


check([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4], 5, 1, 3)
check([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4], 5, 7, 5)
