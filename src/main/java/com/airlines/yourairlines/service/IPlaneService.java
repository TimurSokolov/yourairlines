package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.enums.PlaneState;

public interface IPlaneService extends ICrudService<Plane> {
    PlaneState getPlaneState(Long planeId);
}
