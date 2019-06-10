def remove_outer_parentheses(S):
    count = 0
    r = []
    for c in S:
        if c == '(':
            count += 1
            if count != 1:
                r.append(c)
        else:
            count -= 1
            if count != 0:
                r.append(c)
    return ''.join(r)
