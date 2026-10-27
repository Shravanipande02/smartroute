package com.smartroute.smartroute.service;

import com.smartroute.smartroute.dto.*;
import com.smartroute.smartroute.model.*;
import com.smartroute.smartroute.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GraphEdgeService {
    private final GraphEdgeRepository edgeRepo;
    private final GraphNodeRepository nodeRepo;

    public GraphEdgeService(GraphEdgeRepository edgeRepo, GraphNodeRepository nodeRepo) {
        this.edgeRepo = edgeRepo;
        this.nodeRepo = nodeRepo;
    }

    @Transactional
    public GraphEdgeResponse create(GraphEdgeRequest req) {
        GraphNode from = nodeRepo.findById(req.fromNodeId())
                .orElseThrow(() -> new IllegalArgumentException("From node not found: " + req.fromNodeId()));
        GraphNode to = nodeRepo.findById(req.toNodeId())
                .orElseThrow(() -> new IllegalArgumentException("To node not found: " + req.toNodeId()));

        GraphEdge edge = new GraphEdge(null, from, to, req.distanceKm(), req.travelTimeMin());
        return toResponse(edgeRepo.save(edge));
    }

    @Transactional(readOnly = true)
    public List<GraphEdgeResponse> getAll() {
        return edgeRepo.findAll().stream().map(this::toResponse).toList();
    }

    private GraphEdgeResponse toResponse(GraphEdge e) {
        return new GraphEdgeResponse(e.getId(), e.getFromNode().getId(), e.getToNode().getId(),
                e.getDistanceKm(), e.getTravelTimeMin());
    }
}