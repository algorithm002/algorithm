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


import lc_101_v1
import lc_101_v2
import lc_101_v3

# f = lc_101_v1.is_symmetric
f = lc_101_v2.is_symmetric
# f = lc_101_v3.is_symmetric


def check(nums):
    print(f(build(nums)))


check([1, 2, 2, 3, 4, 4, 3])
check([1, 2, 2, None, 3, None, 3])
