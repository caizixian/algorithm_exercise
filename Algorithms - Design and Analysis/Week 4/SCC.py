import sys
import resource

class DirectedGraph(object):
    def __init__(self, vertex_count):
        self.vertex_count = vertex_count
        self.adjacency = {}
        for x in range(1, vertex_count + 1):
            self.adjacency[x] = []

    def add_edge(self, v, w):
        self.adjacency[v].append(w)

    def adj(self, v):
        return self.adjacency[v]

    def vertices(self, order=lambda x: -x):
        vertex_lst = list(self.adjacency.keys())
        vertex_lst.sort(key=order)
        return vertex_lst

    def __reversed__(self):
        rev_graph = DirectedGraph(self.vertex_count)
        for vertex in self.vertices():
            for connected_vertex in self.adj(vertex):
                rev_graph.add_edge(connected_vertex, vertex)

        return rev_graph

    def __repr__(self):
        result_str = ""
        for vertex in self.vertices():
            for connected_vertex in self.adj(vertex):
                result_str += "{} -> {}, ".format(vertex, connected_vertex)
        return result_str



class SCC(object):
    visited = set()
    running_order_counter = 0
    running_order = {}
    temp_comp = []
    scc = []

    def __init__(self, graph):
        rev_graph = reversed(graph)
        self.dfs_loop(rev_graph)  # 1st pass
        self.visited = set()
        #print(self.running_order)
        self.scc=[]
        self.find_scc(graph, self.running_order)  # 2nd pass
        print(sorted([len(x) for x in self.scc]))

    def dfs(self, graph, entrypoint):
        self.temp_comp.append(entrypoint)
        self.visited.add(entrypoint)
        for v in graph.adj(entrypoint):
            if v not in self.visited:
                self.dfs(graph, v)
        self.running_order_counter += 1
        self.running_order[entrypoint] = self.running_order_counter

    def dfs_loop(self, graph):
        for x in graph.vertices():
            if x not in self.visited:
                self.dfs(graph, x)
                self.scc.append(self.temp_comp)
                self.temp_comp = []

    def find_scc(self, graph, identifier):
        new_graph = DirectedGraph(graph.vertex_count)

        # Populate new graph with id instead of original label
        for vertex in graph.vertices():
            for connected_vertex in graph.adj(vertex):
                new_graph.add_edge(identifier[vertex],
                                   identifier[connected_vertex])
        # print(new_graph)
        self.dfs_loop(new_graph)


def main():
    sys.setrecursionlimit(10 ** 6)
    resource.setrlimit(resource.RLIMIT_STACK,
                       (resource.RLIM_INFINITY, resource.RLIM_INFINITY))

    vertex_count = int(sys.argv[1])
    my_graph = DirectedGraph(vertex_count)

    for line in sys.stdin:
        tokens = line.strip().split()

        input_numbers = [int(x) for x in tokens]
        vertex = input_numbers[0]
        for entry in input_numbers[1:]:
            my_graph.add_edge(vertex, entry)

    #print(my_graph)
    SCC(my_graph)


if __name__ == "__main__":
    main()
    # Answer: 434821,968,459,313,211
