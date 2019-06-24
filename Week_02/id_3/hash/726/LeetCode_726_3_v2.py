n0, n9 = ord('0'), ord('9')
a, z = ord('a'), ord('z')
A, Z = ord('A'), ord('Z')

STATUS_INIT = 0
STATUS_ATOM = 1
STATUS_NUMBER = 2


class Solution:
    def countOfAtoms(self, formula: str) -> str:
        atom_map = self.parse(iter(formula))
        r = []
        for k in sorted(atom_map.keys()):
            r.append(k)
            v = atom_map[k]
            r.append(str(v) if v != 1 else '')
        return ''.join(r)

    def parse(self, iterator) -> dict:
        atom_map = {}
        cur_map = {}
        letters = []
        status = STATUS_ATOM
        while True:
            try:
                c = next(iterator)
                if ')' == c:
                    break

                if '(' == c:
                    self.handle(cur_map, letters, status)
                    self.merge(atom_map, cur_map)
                    cur_map = self.parse(iterator)
                    continue

                v = ord(c)

                if A <= v <= Z:
                    self.handle(cur_map, letters, status)
                    self.merge(atom_map, cur_map)
                    status = STATUS_ATOM
                elif n0 <= v <= n9 and status != STATUS_NUMBER:
                    self.handle(cur_map, letters, status)
                    status = STATUS_NUMBER

                letters.append(c)

            except StopIteration:
                break

        self.handle(cur_map, letters, status)
        self.merge(atom_map, cur_map)
        return atom_map

    def letters(self, letters):
        r = ''.join(letters)
        letters.clear()
        return r

    def atom(self, cur_map, letters):
        cur_map[self.letters(letters)] = 1

    def numbers(self, cur_map, letters):
        numbers = int(self.letters(letters))
        for (k, v) in cur_map.items():
            cur_map[k] = v * numbers

    def handle(self, cur_map, letters, status):
        if not letters:
            return
        if status == STATUS_NUMBER:
            self.numbers(cur_map, letters)
        else:
            self.atom(cur_map, letters)

    def merge(self, atom_map, cur_map):
        if not cur_map:
            return
        for (k, v) in cur_map.items():
            atom_map[k] = atom_map.get(k, 0) + v

        cur_map.clear()
