import sys
import random

my_graph = {} #mapping from int to a list of int

# Read the graph from stdin

for line in sys.stdin:
    input_numbers = [int(x) for x in line.strip().split()]
    vertex = input_numbers[0]
    for entry in input_numbers[1:]:
        if vertex in my_graph:
            my_graph[vertex].append(entry)
        else:
            my_graph[vertex]=[entry]

visited = set()
connected_components = []
def bfs(graph, entrypoint):
    graph_dist = {}
    for key in graph:
        graph_dist[key] = 2147483647
    # entrypoint = random.choice(list(graph.keys()))
    print("Starting from {}".format(entrypoint))

    # Setting up entrypoint
    to_visit = [entrypoint]
    visited.add(entrypoint)
    graph_dist[entrypoint] = 0

    result = []

    while to_visit:
        vertex = to_visit.pop(0) # Visit a vertex
        visited.add(vertex)
        result.append(vertex)
        for entry in graph[vertex]:
            if entry not in visited:
                to_visit.append(entry)
                visited.add(entry)
                graph_dist[entry] = graph_dist[vertex]+1

    return (result, graph_dist)

for key in my_graph.keys():
    if key not in visited:
        bfs_result, bfs_dist = bfs(my_graph, key)

        connected_components.append(bfs_result)

        print("BFS result: {}".format(bfs_result))

        for x in bfs_result:
            print("Distance from entrypoint: {}".format(bfs_dist[x]))

print("Connected components {}".format(connected_components))
