"""
    参考答案 略做修改 两颗子树的对称比较，除了比较根节点外，还要比较t1.left是否与t2.right对称, t1.right 是否与t2.left对称
    DFS遍历的时候进行一些变体，使每次将需要对比的两个子树相邻入栈，每次也取出两个节点进行对比，当遇到一次不对称的节点就返回失败。
        1
       / \
      2   2
     / \ / \
    3  4 4  3
"""


def is_symmetric(root):
    stack = [root.left, root.right]
    while len(stack) > 0:
        n1 = stack.pop()
        n2 = stack.pop()
        if not n1 and not n2:
            continue
        if bool(n1) != bool(n2):
            return False
        if n1.val != n2.val:
            return False
        stack.append(n1.left)
        stack.append(n2.right)
        stack.append(n1.right)
        stack.append(n2.left)

    return True
