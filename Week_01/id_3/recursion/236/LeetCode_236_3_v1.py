def lowest_common_ancestor(root, p, q):
    if not root or root.val == p.val or root.val == q.val:
        return root
    left = lowest_common_ancestor(root.left, p, q)
    right = lowest_common_ancestor(root.right, p, q)


    # 三目表达识
    if left and right:
        return root
    return left or right
