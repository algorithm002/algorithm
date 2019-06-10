"""
    参考答案 两颗子树的对称比较，除了比较根节点外，还要比较t1.left是否与t2.right对称, t1.right 是否与t2.left对称
    在进行深度优先遍历的时候，每次针对要进行判断是否是镜像的子树进行迭代
        1
       / \
      2   2
     / \ / \
    3  4 4  3
"""


def is_symmetric(root):
    return is_mirror(root.left, root.right)


def is_mirror(t1, t2):
    if not t1 and not t2:
        return True
    if bool(t1) != bool(t2):
        return False
    if t1.val != t2.val:
        return False

    return is_mirror(t1.left, t2.right) and is_mirror(t1.right, t2.left)
