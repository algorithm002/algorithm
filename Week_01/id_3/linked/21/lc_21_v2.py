# 本代码按python语法进行优化 查看之前得提交可以看到更远古的写法


def merge(l1, l2):
    if not l1 or not l2:
        return l1 or l2

    if l1.val > l2.val:
        l1, l2 = l2, l1
    l1.next = merge(l1.next, l2)
    return l1
