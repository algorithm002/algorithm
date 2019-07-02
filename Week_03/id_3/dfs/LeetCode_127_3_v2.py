"""
似乎DFS不行, 时间不受控制，试试双向BFS
"""


class Solution:
    def ladderLength(self, begin, end, word_list) -> int:
        if not begin or not end or not word_list or end not in word_list:
            return 0

        word_graph = {}
        for w in word_list:
            for i in range(len(w)):
                k = w[0:i] + '*' + w[i+1:]
                arr = word_graph.get(k, [])
                arr.append(w)
                word_graph[k] = arr

        begin_set = set()
        end_set = set([end])
        count = 0
        begin_queue = [begin]
        end_queue = [end]

        while begin_queue or end_queue:
            if count % 2 == 0:
                queue = begin_queue
                cur_set, target_set = begin_set, end_set
            else:
                queue = end_queue
                cur_set, target_set = end_set, begin_set

            _queue = []
            for w in queue:
                for i in range(len(w)):
                    k = w[0:i] + '*' + w[i+1:]
                    if k not in word_graph:
                        continue
                    for sw in word_graph[k]:
                        if sw in cur_set:
                            continue
                        if sw in target_set:
                            return count + 2
                        else:
                            cur_set.add(sw)
                            _queue.append(sw)
            if count % 2 == 0:
                begin_queue = _queue
            else:
                end_queue = _queue
            count += 1

        return 0


s = Solution()
print(s.ladderLength("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
print(s.ladderLength("hit", "cog", ["hot", "dot", "dog", "lot"]))
print(s.ladderLength("hot", "dog", ["hot", "dog"]))
