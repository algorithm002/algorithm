
    var mergeTwoLists = function (l1, l2) {
    let pHead = null,
     pHead1 = l1,
     pHead2 = l2,
     p1 = l1,
     p2 = l2,
     p = null;
    if (!l1) {
        return l2;
    } else if (!l2) {
        return l1;
    }

    if (l1.val < l2.val) {
        pHead = p1;
        p = p1;
        p1 = p1.next;
    } else {
        pHead = p2;
        p = p2;
        p2 = p2.next;
    }

    while (p1 && p2) {
        if (p1.val < p2.val) {
            p.next = p1;
            p = p.next;
            p1 = p1.next;
        } else {
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }
    }

    if (p1) {
        p.next = p1;
    } else if (p2) {
        p.next = p2;
    }

    return pHead;
};
