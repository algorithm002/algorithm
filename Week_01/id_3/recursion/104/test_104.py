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


import LeetCode_104_3_v1
import LeetCode_104_3_v2

# f = LeetCode_104_3_v1.max_depth
f = LeetCode_104_3_v2.max_depth


def check(nums, r):
    _r = f(build(nums))
    print(_r, r, _r == r)


check([3, 9, 20, None, None, 15, 7], 3)
check([0, 2, 4, 1, None, 3, -1, 5, 1, None, 6, None, 8], 4)
