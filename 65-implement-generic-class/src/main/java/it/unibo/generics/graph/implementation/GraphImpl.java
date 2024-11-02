package it.unibo.generics.graph.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl <N> implements Graph<N>{
    private final Map<N, Set<N>> adjacencyMap;

    GraphImpl(){
        adjacencyMap = new HashMap<>();
    }

    @Override
    public void addEdge(N source, N target) {
        if(source != null && target != null){
            if(!adjacencyMap.containsKey(target)){
                throw new IllegalArgumentException("target node wasn't added");
            }
            if(!adjacencyMap.containsKey(source)){
                throw new IllegalArgumentException("source node wasn't added");
            }
            adjacencyMap.get(source).add(target);
        }
    }

    @Override
    public void addNode(N node) {
        if(node == null){
            throw new IllegalArgumentException("L'argomento è nullo");
        }
        if(!adjacencyMap.containsKey(node)){
            adjacencyMap.put(node, new HashSet<>());
        }
        
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return new HashSet<>(adjacencyMap.get(node));
    }

    @Override
    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        return null;
    }

}
