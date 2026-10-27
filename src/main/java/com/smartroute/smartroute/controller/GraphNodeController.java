package com.smartroute.smartroute.controller;

import com.smartroute.smartroute.model.GraphNode;
import com.smartroute.smartroute.service.GraphNodeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/nodes")
public class GraphNodeController {
    private final GraphNodeService service;

    public GraphNodeController(GraphNodeService service) {
        this.service = service;
    }

    @PostMapping
    public GraphNode create(@RequestBody GraphNode node) {
        return service.create(node);
    }

    @GetMapping
    public List<GraphNode> getAll() {
        return service.getAll();
    }
}