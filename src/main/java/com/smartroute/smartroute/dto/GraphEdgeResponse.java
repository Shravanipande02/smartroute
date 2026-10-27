package com.smartroute.smartroute.dto;

public record GraphEdgeResponse(
        Long id, Long fromNodeId, Long toNodeId,
        double distanceKm, double travelTimeMin
) {}