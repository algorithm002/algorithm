def merge(l1, l2):
    if l1 and l2:
        if l1.val < l2.val:
            r = l1
            l1 = l1.next
        else:
            r = l2
            l2 = l2.next
        r.next = merge(l1, l2)
        return r
    else:
        return l1 or l2
