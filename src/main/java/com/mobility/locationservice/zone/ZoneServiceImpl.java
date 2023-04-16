package com.mobility.locationservice.zone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public List<Zone> getNearestZones(double lat, double lng) {
        double radius = 1;
        Point point = new Point(lat, lng);
        Distance distanceKm = new Distance(radius, Metrics.KILOMETERS);
        return zoneRepository.findByLocationNear(point, distanceKm);
    }
}
