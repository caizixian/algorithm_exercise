class MaxHeap(object):
    def __init__(self, lst=None, max_size=65535):
        self.keys = [None] * max_size
        self.max_size = max_size
        self.idx = 0
        if not lst:
            lst = []

        for x in lst:
            self.insert(x)

    def exchange(self, x, y):
        self.keys[x], self.keys[y] = self.keys[y], self.keys[x]

    def extract_max(self):

        max_key = self.keys[1]
        self.exchange(1, self.idx)
        self.keys[self.idx] = None
        self.bubble_down(1)
        self.idx -= 1

        return max_key

    def insert(self, item):
        assert self.idx + 1 <= self.max_size - 1
        self.idx += 1
        self.keys[self.idx] = item
        self.bubble_up(self.idx)

    def __len__(self):
        return self.idx

    def cmp(self, x, y, operation=lambda x, y: x < y):
        return operation(self.keys[x], self.keys[y])

    def bubble_up(self, k):
        while k > 1 and self.cmp(k / 2, k):  # Not root and better than parent
            self.exchange(k / 2, k)
            k = k / 2 # New position

    def bubble_down(self, k):
        while 2 * k <= self.idx:  # Above corresponding last layer
            j = 2 * k  # left child
            if j < self.idx and self.cmp(j, j + 1):  # Right child is better
                j += 1
            if not self.cmp(k, j):
                break  # Restored heap property
            self.exchange(k, j)
            k = j # New position


def main():
    pq = MaxHeap(list("SORTEXAMPLE"))
    assert pq.extract_max() == 'X'
    assert len(pq) == 10
    pq.insert('Y')
    pq.insert('Z')
    assert len(pq) == 12
    assert pq.extract_max() == 'Z'
    assert pq.extract_max() == 'Y'
    assert pq.extract_max() == 'T'
    assert pq.extract_max() == 'S'
    assert pq.extract_max() == 'R'
    print("All tests passed.")


if __name__ == '__main__':
    main()
