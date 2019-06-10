def three_sum(nums):
    r = []
    if not nums or len(nums) < 3:
        return r

    cache = {}
    dset = set()

    new_nums = []

    for n in nums:
        count = 1 + cache.get(n, 0)
        cache[n] = count
        if n and count <= 2:
            new_nums.append(n)

    zero_count = cache.get(0, 0)
    if zero_count >= 3:
        r.append([0, 0, 0])

    if zero_count > 0:
        new_nums.append(0)

    nums = new_nums
    nums.sort()

    length = len(nums)
    for i in range(length):
        n1 = nums[i]
        # n1 >= 0 时说明已经遍历把有效的数据都进行遍历，继续遍历已经发生重复
        if n1 >= 0:
            break
        for j in range(i+1, length):
            n2 = nums[j]
            if n1 == 0 and n2 == 0 and cache[0] < 3:
                continue
            s = -(n1 + n2)

            # 迭代顺序是从小到大的
            # 当-sum(n1,n2)的结果小于n2时 说明已经迭代出现了重复 -sum必然在之前已经迭代过
            if s < n2:
                break

            if (s == n1 or s == n2) and cache.get(s, 0) == 1:
                continue

            if cache.get(s, 0):
                arr = [n1, n2, s]
                ds = '%s,%s' % (n1, n2)
                if ds not in dset:
                    dset.add(ds)
                    r.append(arr)

    return r
