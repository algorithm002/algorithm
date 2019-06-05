def three_sum(nums):
    r = []
    if not nums:
        return r

    cache = {}
    dset = set()

    new_nums = []

    for n in nums:
        count = 1 + cache.get(n, 0)
        cache[n] = count
        if count <= 3:
            new_nums.append(n)

    nums = new_nums

    length = len(nums)
    for i in range(length):
        for j in range(i+1, length):
            n1 = nums[i]
            n2 = nums[j]
            if n1 == 0 and n2 == 0 and cache[0] < 3:
                continue
            s = n1 + n2
            if (-s == n1 or -s == n2) and cache.get(-s, 0) == 1:
                continue

            if cache.get(-s, 0):
                arr = [n1, n2, -s]
                arr.sort()
                ds = ','.join(map(str, arr))
                if ds not in dset:
                    dset.add(ds)
                    r.append(arr)

    return r
