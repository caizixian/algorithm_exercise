from math import log, ceil
from random import choice
from copy import deepcopy
vertices_ori = []
edges_ori = []

#Answer: 17

class Edge:
    def __init__(self, vertex_a, vertex_b):
        self.vertex_a = vertex_a
        self.vertex_b = vertex_b

    def __eq__(self, other):
        if not isinstance(other, self.__class__):
            return False
        if (self.vertex_a, self.vertex_b) == (other.vertex_a, other.vertex_b):
            return True
        if (self.vertex_b, self.vertex_a) == (other.vertex_a, other.vertex_b):
            return True
        return False

    def __ne__(self, other):
        return not self.__eq__(other)

    def __repr__(self):
        return "Edge({}, {})".format(self.vertex_a, self.vertex_b)

    def __reversed__(self):
        return Edge(self.vertex_b, self.vertex_a)


with open("kargerMinCut.txt") as input_file:
    for line in input_file:
        numbers = line.strip().split('\t')
        vertex = numbers[0]
        vertices_ori.append(vertex)
        for other_end in numbers[1:]:
            edge = Edge(vertex, other_end)
            if edge not in edges_ori:
                edges_ori.append(edge)

print("Vertices {}".format(vertices_ori))
print("Edges {}".format(edges_ori))

min_cut = len(edges_ori)

iter_time = int(ceil(len(vertices_ori) * len(vertices_ori) * log(len(vertices_ori))))
print("Need to try {} times".format(iter_time))

for count in range(iter_time):
    print("#{}/{}:".format(count, iter_time-1))
    vertices = deepcopy(vertices_ori)
    edges = deepcopy(edges_ori)
    while (len(vertices)>2):
        random_edge = choice(edges)
        #print("{} chosen".format(random_edge))
        vertex_a = random_edge.vertex_a
        vertex_b = random_edge.vertex_b

        # Fuse two vertices
        vertices.remove(vertex_b)
        while random_edge in edges:
            edges.remove(random_edge)

        reversed_edge = reversed(random_edge)

        while reversed_edge in edges:
            edges.remove(reversed_edge)

        # Fuse to vertex_a
        for edge in edges:
            if edge.vertex_a == vertex_b:
                edge.vertex_a = vertex_a
            if edge.vertex_b == vertex_b:
                edge.vertex_b = vertex_a

        #print("Fused result:")
        #print("Vertices {}".format(vertices))
        #print("Edges {}".format(edges))

    print("{} edges remaining".format(len(edges)))
    if len(edges)<min_cut:
        min_cut = len(edges)

print("Min-cut {}".format(min_cut))
