class Node(object):
    def __init__(self, key, parent=None):
        self.key = key
        self.parent = parent
        self.left = None
        self.right = None

    def delete_child(self, key):
        if self.left and self.left.key == key:
            self.left = None
        else:
            if self.right and self.right.key == key:
                self.right = None


class BinarySearchTree(object):
    def __init__(self):
        self.root = None

    def keys(self):
        def walk(root_node):
            if root_node:
                for x in walk(root_node.left):
                    yield x
                yield root_node.key
                for x in walk(root_node.right):
                    yield x

        return walk(self.root)

    def search(self, key):
        def walk(root_node, key):
            if (not root_node) or root_node.key == key:
                return root_node
            if key < root_node.key:
                return walk(root_node.left, key)
            else:
                return walk(root_node.right, key)

        return walk(self.root, key)

    def min(self, root_node=None):
        def walk(root_node):
            if not root_node.left:
                return root_node
            else:
                return walk(root_node.left)

        if not root_node:
            root_node = self.root
        return walk(root_node)

    def max(self, root_node=None):
        def walk(root_node):
            if not root_node.right:
                return root_node
            else:
                return walk(root_node.right)

        if not root_node:
            root_node = self.root

        return walk(root_node)

    def successor(self, key):
        # the smallest key greater than key
        node_to_search = self.search(key)
        if node_to_search.right:
            return self.min(node_to_search.right)
        parent = node_to_search.parent
        while (not parent) and node_to_search == parent.right:
            node_to_search = parent
            parent = node_to_search.parent
        return parent

    def predecessor(self, key):
        # the largest key smaller than key
        node_to_search = self.search(key)
        if node_to_search.left:
            return self.max(node_to_search.left)
        parent = node_to_search.parent
        while (not parent) and node_to_search == parent.left:
            node_to_search = parent
            parent = node_to_search.parent
        return parent

    def insert(self, key):
        def walk(root_node):
            if not root_node:
                return Node(key)
            if key < root_node.key:
                root_node.left = walk(root_node.left)
                root_node.left.parent = root_node
            if key > root_node.key:
                root_node.right = walk(root_node.right)
                root_node.right.parent = root_node
            return root_node

        if not self.root:
            self.root = Node(key)
        else:
            walk(self.root)

    def delete(self, key):
        node_to_delete = self.search(key)
        # Easy case, no child
        if (not node_to_delete.left) and (not node_to_delete.right):
            node_to_delete.parent.delete_child(key)
            return
        # Medium case, one child
        if node_to_delete.right and (not node_to_delete.left):
            node_to_delete = node_to_delete.right
            return
        if node_to_delete.left and (not node_to_delete.right):
            node_to_delete = node_to_delete.left
            return
        # Difficult case, two child
        predecessor = self.predecessor(key)
        predecessor.key, node_to_delete.key = node_to_delete.key, predecessor.key
        node_to_delete = predecessor
        if node_to_delete.right:
            node_to_delete = node_to_delete.right
            return
        else:
            node_to_delete.parent.delete_child(key)
            return

    def __repr__(self):
        return str(self.root)


def main():
    my_tree = BinarySearchTree()
    nums = ['s', 'e', 'x', 'a', 'r', 'c', 'h', 'm', 'p']
    for x in nums:
        my_tree.insert(x)
    print(my_tree.root)
    for key in my_tree.keys():
        print(key)
    print(my_tree.predecessor('e').key)
    my_tree.delete('e')
    for key in my_tree.keys():
        print(key)


if __name__ == '__main__':
    main()
