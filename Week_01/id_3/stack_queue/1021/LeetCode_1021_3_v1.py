def remove_outer_parentheses(S):
    stack = []
    r = []
    for c in S:
        if c == '(':
            stack.append(c)
            if len(stack) != 1:
                r.append(c)
        else:
            stack.pop()
            if len(stack) != 0:
                r.append(c)
    return ''.join(r)
