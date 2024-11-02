package it.unibo.generics.graph.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl implements Graph{

    private final Map<String, Set<String>> adjaciencyList;
    GraphImpl(){
        adjaciencyList = new HashMap<>();
    }
    
    @Override
    public void addEdge(Object source, Object target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addNode(Object node) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List getPath(Object source, Object target) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set linkedNodes(Object node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set nodeSet() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
