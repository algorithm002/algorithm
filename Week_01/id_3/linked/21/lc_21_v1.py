def merge(l1, l2):
    root = None
    tmp = None
    while l1 and l2:
        if l1.val > l2.val:
            _t = l2
            l2 = l2.next
        else:
            _t = l1
            l1 = l1.next

        if not root:
            root = _t
        else:
            tmp.next = _t
        tmp = _t

    if tmp:
        tmp.next = l1 or l2
    else:
        root = l1 or l2

    return root
