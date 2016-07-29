from math import floor

class HeapSort(object):
    def __init__(self, lst=None):
        self.keys = [None]+lst
        self.idx = len(lst)
        print(self.idx)
        for x in range(floor(self.idx/2), 0, -1): # Skip size-1 heaps
            self.bubble_down(x)
            print(self.keys)
        while self.idx>1:
            self.exchange(1, self.idx)
            self.idx-=1
            self.bubble_down(1)

    def bubble_down(self, k):
        while 2 * k <= self.idx:  # Above corresponding last layer
            j = 2 * k  # left child
            if j < self.idx and self.cmp(j, j + 1):  # Right child is better
                j += 1
            if not self.cmp(k, j):
                break  # Restored heap property
            self.exchange(k, j)
            k = j # New position

    def cmp(self, x, y, operation=lambda x, y: x < y):
        return operation(self.keys[x], self.keys[y])

    def exchange(self, x, y):
        self.keys[x], self.keys[y] = self.keys[y], self.keys[x]    

    def sorted_array(self):
        return self.keys[1:]

def main():
    print(HeapSort(list("SORTEXAMPLE")).sorted_array())

if __name__ == '__main__':
    main()
