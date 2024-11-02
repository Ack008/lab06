package it.unibo.generics.graph.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.*;

public class GraphImpl <N> implements Graph<N>{
    private final Map<N, Set<N>> adjacencyMap;
    TypeOfPathSearch typeOfPath;

    public GraphImpl(){
        this(TypeOfPathSearch.DEPTH_FIRST);
    }

    public GraphImpl(TypeOfPathSearch type){
        typeOfPath = type;
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

    List<N> bfs(N source, N target){
        if(source.equals(target)){
            return List.of(source);
        }
        List<N> stack = new LinkedList<>();
        Set<N> visited = new HashSet<>();
        Map<N,N> fatherSonMap = new HashMap<>();
        visited.add(source);
        stack.addFirst(source);
        fatherSonMap.put(source, null);
        N nextNode = source;
        while(!stack.isEmpty() && !nextNode.equals(target)){
            nextNode = stack.removeFirst();
            for(var adjacentNode : adjacencyMap.get(nextNode)){
                if(!visited.contains(adjacentNode)){
                    fatherSonMap.put(adjacentNode, nextNode);
                    stack.addFirst(adjacentNode);
                }
            }
            visited.add(nextNode);
        }
        List<N> path = new LinkedList<>();
        N node = target;
        while(node != null){
            path.addFirst(node);
            node = fatherSonMap.get(node);
        }
        return path;
    }

    @Override
    public List<N> getPath(N source, N target) {
        if(source == null || target == null){
            throw new IllegalArgumentException();
        }
        return bfs(source, target);
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return new HashSet<>(adjacencyMap.get(node));
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(adjacencyMap.keySet());
    }

}
