import sys
import random

my_graph = {} #mapping from int to a list of int

# Read the graph from stdin

for line in sys.stdin:
    tokens = line.strip().split()
    if tokens[1] == "S": # Sink vertex
        my_graph[int(tokens[0])] = None
    else:
        input_numbers = [int(x) for x in tokens]
        vertex = input_numbers[0]
        for entry in input_numbers[1:]:
            if vertex in my_graph:
                my_graph[vertex].append(entry)
            else:
                my_graph[vertex]=[entry]

def topo_sort(topo_graph):
    visited = set()
    f_value={}
    current_label = len(topo_graph)
    result = []

    def dfs(graph, entrypoint):
        nonlocal current_label
        visited.add(entrypoint)
        result.append(entrypoint)
        if graph.get(entrypoint, None) is None:
            f_value[entrypoint]=current_label
            current_label-=1
            return
        for vertex in graph[entrypoint]:
            if vertex not in visited:
                dfs(graph, vertex)
        f_value[entrypoint]=current_label
        current_label-=1
        return

    for entry in topo_graph.keys():
        if entry not in visited:
            dfs(topo_graph,entry)
    return f_value
    
print(my_graph)
print(topo_sort(my_graph))