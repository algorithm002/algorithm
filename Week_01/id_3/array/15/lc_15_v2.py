def three_sum(nums):
    nums, r = sorted(nums), set()
    for i in [i for i in range(len(nums)-2) if i < 1 or nums[i] > nums[i-1]]:
        d = {-nums[i]-n: j for j, n in enumerate(nums[i + 1:])}
        r.update([(nums[i], n, -nums[i]-n) for j, n in enumerate(nums[i+1:]) if n in d and d[n] > j])
    return list(map(list, r))
