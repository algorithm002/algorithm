def group_anagrams(strs):
    m = {}
    for s in strs:
        k = ''.join(sorted(c for c in s))
        l = m.get(k, [])
        l.append(s)
        m[k] = l

    return list(m.values())
