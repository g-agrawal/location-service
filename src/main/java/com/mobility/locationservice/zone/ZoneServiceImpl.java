package com.mobility.locationservice.zone;

import com.mobility.locationservice.exception.MethodArgumentNotValidException;
import com.mobility.locationservice.exception.ZoneNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @SneakyThrows
    @Override
    public List<Zone> getNearestZones(double lat, double lng) {
        double radius = 1;
        if(lat == 0 || lng == 0) {
            throw new MethodArgumentNotValidException("lat = " + lat + "lng = " + lng);
        }
        Point point = new Point(lat, lng);
        Distance distanceKm = new Distance(radius, Metrics.KILOMETERS);
        List<Zone> zones = zoneRepository.findByLocationNear(point, distanceKm);
        if(zones.isEmpty()) {
            throw new ZoneNotFoundException("Zone not available at lat = " + lat + "lng = " + lng);
        }
        return zones;
    }
}
