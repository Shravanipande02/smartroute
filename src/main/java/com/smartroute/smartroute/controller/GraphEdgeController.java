package com.smartroute.smartroute.controller;

import com.smartroute.smartroute.dto.GraphEdgeRequest;
import com.smartroute.smartroute.dto.GraphEdgeResponse;
import com.smartroute.smartroute.service.GraphEdgeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/edges")
public class GraphEdgeController {
    private final GraphEdgeService service;

    public GraphEdgeController(GraphEdgeService service) {
        this.service = service;
    }

    @PostMapping
    public GraphEdgeResponse create(@Valid @RequestBody GraphEdgeRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<GraphEdgeResponse> getAll() {
        return service.getAll();
    }
}