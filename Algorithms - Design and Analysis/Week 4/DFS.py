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
result = []

def dfs(graph, entrypoint):
    visited.add(entrypoint)
    result.append(entrypoint)
    for vertex in my_graph[entrypoint]:
        if vertex not in visited:
            dfs(graph, vertex)

dfs(my_graph,1)

print(result)