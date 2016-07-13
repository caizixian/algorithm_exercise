from collections import defaultdict
from functools import reduce
from operator import add
import sys

class WeightedEdge(object):
    def __init__(self, v, w, weight):
        self.v = v
        self.w = w
        self.weight = weight

    def origin(self):
        return self.v

    def destination(self):
        return self.w

    def __repr__(self):
        return "{} -> {} ({})".format(self.v, self.w, self.weight)


class WeightedDirectedGraph(object):
    def __init__(self):
        self.adjacency = defaultdict(list)
        self._vertices = set()

    def add_edge(self, edge):
        self.adjacency[edge.origin()].append(edge)
        self._vertices.add(edge.origin())
        self._vertices.add(edge.destination())

    def adj(self, v):
        return self.adjacency[v]

    def edges(self):
        return reduce(add, self.adjacency.values(), [])

    def vertices(self):
        return self._vertices

    def __repr__(self):
        result_str = ""
        for vertex in self.vertices():
            for connected_vertex in self.adj(vertex):
                result_str += "{} -> {}, ".format(vertex, connected_vertex)
        return result_str


def dijkstra(graph, entrypoint):
    visited_vertices = {entrypoint}
    dist_to = {entrypoint: 0}
    path_to = {entrypoint: str(entrypoint)}
    total_vertices = set(graph.vertices())

    def calc_best_edge(edges):
        min_score=2147483647
        min_edge = None
        for edge in edges:
            current_score = dist_to[edge.origin()]+edge.weight
            if current_score<min_score:
                min_score = current_score
                min_edge = edge
        return min_edge

    while visited_vertices != total_vertices:
        edges = filter(lambda x: x.destination() not in visited_vertices,
                       reduce(add,
                              map(graph.adj, visited_vertices),
                              []))
        selected_edge = calc_best_edge(edges)
        visited_vertices.add(selected_edge.destination())
        dist_to[selected_edge.destination()] = dist_to[
                                                   selected_edge.origin()] + selected_edge.weight
        path_to[selected_edge.destination()] = path_to[
                                                   selected_edge.origin()] + "->" + str(
            selected_edge.destination())
    return (dist_to, path_to)

def main():
    entrypoint = sys.argv[1]
    my_graph = WeightedDirectedGraph()
    for line in sys.stdin:
        tokens = line.strip().split('\t')
        origin = tokens[0]
        for edge in tokens[1:]:
            destination = edge.split(',')[0]
            weight = int(edge.split(',')[1])
            assert weight>=0
            my_graph.add_edge(WeightedEdge(origin, destination, weight))
    dist_to, path_to = dijkstra(my_graph, entrypoint)
    print("Distance To:\n{}".format(dist_to))
    print("Path To:\n{}".format(path_to))
    for entry in ['7','37','59','82','99','115','133','165','188','197']:
        print(dist_to[entry])

    # Answer: 2599,2610,2947,2052,2367,2399,2029,2442,2505,3068

if __name__ == '__main__':
    main()
