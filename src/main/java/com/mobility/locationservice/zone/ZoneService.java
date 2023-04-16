package com.mobility.locationservice.zone;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZoneService {
    List<Zone> getNearestZones(double lat, double lng);
}
