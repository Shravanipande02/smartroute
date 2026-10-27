package com.smartroute.smartroute.service;

import com.smartroute.smartroute.model.GraphNode;
import com.smartroute.smartroute.repository.GraphNodeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GraphNodeService {
    private final GraphNodeRepository repository;

    public GraphNodeService(GraphNodeRepository repository) {
        this.repository = repository;
    }

    public GraphNode create(GraphNode node) {
        return repository.save(node);
    }

    public List<GraphNode> getAll() {
        return repository.findAll();
    }
}