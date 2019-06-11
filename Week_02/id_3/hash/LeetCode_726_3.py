n0, n9 = ord('0'), ord('9')
a, z = ord('a'), ord('z')
A, Z = ord('A'), ord('Z')

STATUS_INIT = 0
STATUS_ATOM = 1
STATUS_NUMBER = 2


class Solution:
    def countOfAtoms(self, formula: str) -> str:
        stack = []
        atom_map = {}
        cur_map = {}
        status = STATUS_INIT
        letter_list = []
        for c in formula:
            if c == '(' or c == ')':
                self.handle(letter_list, status, cur_map)
                self.merge_map(atom_map, cur_map)
                if c == '(':
                    stack.append(atom_map)
                    atom_map = {}
                    continue
                elif c == ')':
                    self.handle(letter_list, status, cur_map)
                    self.merge_map(atom_map, cur_map)
                    cur_map = atom_map
                    atom_map = stack.pop()
                    status = STATUS_INIT
                    continue

            v = ord(c)
            if A <= v <= Z:
                self.handle(letter_list, status, cur_map)
                self.merge_map(atom_map, cur_map)
                status = STATUS_ATOM
            elif n0 <= v <= n9:
                if status != STATUS_NUMBER:
                    self.handle(letter_list, status, cur_map)
                    status = STATUS_NUMBER

            letter_list.append(c)

        self.handle(letter_list, status, cur_map)
        self.merge_map(atom_map, cur_map)

        r = []
        for k in sorted(atom_map.keys()):
            v = atom_map[k]
            r.append('%s%s' % (k, v if v!= 1 else ''))
        return ''.join(r)

    def handle(self, letter_list, status, cur_map):
        if not letter_list:
            return

        s = ''.join(letter_list)
        if status == STATUS_NUMBER:
            n = int(s)
            for (k, v) in cur_map.items():
                cur_map[k] = v * n
        elif status == STATUS_ATOM:
            cur_map[s] = 1

        letter_list.clear()

    def merge_map(self, m1, m2):
        if not m2:
            return m1
        for (k, v) in m2.items():
            m1[k] = m1.get(k, 0) + v
        m2.clear()
        return m1


s1 = Solution()
print(s1.countOfAtoms('H2O') == 'H2O')
print(s1.countOfAtoms('Mg(OH)2') == 'H2MgO2')
print(s1.countOfAtoms('K4(ON(SO3)2)2') == 'K4N2O14S4')
