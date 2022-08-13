graph = {}
graph["st"] = {}
graph["st"]["a"] = 10
graph["a"] = {}
graph["a"]["c"] = 20
graph["b"] = {}
graph["b"]["a"] = 1
graph["c"] = {}
graph["c"]["b"] = 1
graph["c"]["fin"] = 30
graph["fin"] = {}

costs = {}
costs["a"] = 10
costs["b"] = float("inf")
costs["c"] = float("inf")
costs["fin"] = float("inf")

parents = {}
parents["a"] = "st"
parents["b"] = None
parents["c"] = None
parents["fin"] = None

print(graph)
print(costs)
print(parents)


processed = []

def find_cheapest(costs, processed):
    # finds the node that has the cheapest cost and that is not processed
    minimum = float("inf")
    cheapest = None
    for node in costs:
        cost = costs[node]
        if cost < minimum and node not in processed:
            minimum = cost
            cheapest = node
    return cheapest


node = find_cheapest(costs, processed)

while node is not None:
    neighbors = graph[node]
    for n in neighbors:
        new_cost = costs[node] + neighbors[n]
        if new_cost < costs[n]:
            parents[n] = node
            costs[n] = new_cost   
    processed.append(node)
    node = find_cheapest(costs, processed)

print("costs", costs)
print("parents", parents)


    
