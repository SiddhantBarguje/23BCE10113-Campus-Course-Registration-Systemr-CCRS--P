import networkx as nx
import matplotlib.pyplot as plt

def run_dijkstra(G, source, title):
    """Run Dijkstra's algorithm and plot the directed graph."""
    print(f"\n--- {title} ---")
    print("Edges (with weights):")
    for u, v, data in G.edges(data=True):
        print(f"{u} -> {v}, weight: {data['weight']}")
    
    # Check for negative weights
    has_negative = any(d['weight'] < 0 for u, v, d in G.edges(data=True))
    if has_negative:
        print("\nError: Dijkstra cannot handle negative weight edges or negative cycles!")
    else:
        # Run Dijkstra
        shortest_paths = nx.single_source_dijkstra_path(G, source)
        shortest_distances = nx.single_source_dijkstra_path_length(G, source)
        print(f"\nShortest paths from node {source}:")
        for node in shortest_paths:
            print(f"{node}: Path: {shortest_paths[node]}, Distance: {shortest_distances[node]}")
    
    # Plot graph with arrows
    pos = nx.spring_layout(G)
    nx.draw(G, pos, with_labels=True, node_color='lightblue', node_size=2000, arrows=True)
    edge_labels = {(u, v): d['weight'] for u, v, d in G.edges(data=True)}
    nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels)
    plt.title(title)
    plt.show()


# ======================
# Input-driven graph
print("=== Input-Driven Dijkstra's Algorithm ===\n")

num_edges = int(input("Enter number of edges: "))
G = nx.MultiDiGraph()  # Directed graph with possible multiple edges

print("Enter edges in the format: node1 node2 weight")
for i in range(num_edges):
    u, v, w = input(f"Edge {i+1}: ").split()
    w = float(w)
    G.add_edge(u, v, weight=w)

source = input("Enter the source node: ")
run_dijkstra(G, source, "Input-Driven Directed Graph")
