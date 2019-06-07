import lc_49_v1

f = lc_49_v1.group_anagrams

print(f(["eat", "tea", "tan", "ate", "nat", "bat"]),
      [
          ["ate", "eat", "tea"],
          ["nat", "tan"],
          ["bat"]
      ])
