def is_anagram(s, t):
    if len(s) != len(t):
        return False

    arr = [0] * 26
    m = ord('a')
    for c in s:
        arr[ord(c) % m] += 1

    for c in t:
        i = ord(c) % m
        if arr[i] == 0:
            return False
        arr[i] -= 1

    return True
