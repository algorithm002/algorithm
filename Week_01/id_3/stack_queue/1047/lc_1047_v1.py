def remove_duplicates(S):
    if not S:
        return None
    stack = [None]
    for c in S:
        if c == stack[-1]:
            stack.pop()
        else:
            stack.append(c)
    return ''.join(stack[1:])


print(remove_duplicates('abbaca'), 'ca')
