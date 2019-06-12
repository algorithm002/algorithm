import LeetCode_297_3_v1

Codec = LeetCode_297_3_v1.Codec

codec = Codec()


def check(nums):
    r = codec.serialize(codec.deserialize(nums))
    print(r, r == nums)


check([1, 2, 3, None, None, 4, 5])
