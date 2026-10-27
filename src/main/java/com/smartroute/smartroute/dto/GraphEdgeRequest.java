package com.smartroute.smartroute.dto;

import jakarta.validation.constraints.*;

public record GraphEdgeRequest(
        @NotNull Long fromNodeId,
        @NotNull Long toNodeId,
        @Positive double distanceKm,
        @Positive double travelTimeMin
) {}