package com.mobility.locationservice.zone.provider;

import com.mobility.locationservice.address.Address;
import com.mobility.locationservice.zone.Zone;
import com.mobility.locationservice.zone.ZoneRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeZoneRepository implements ZoneRepository {

    @Override
    public List<Zone> findByLocationNear(Point point, Distance distance) {
        List<Zone> zoneList = new ArrayList<>();
        zoneList.add(new Zone(102, "Mobility Zone ORR", "outer ring road, bellandur, ecospace, bangalore, karnataka, india", 7.123456, 8.123456));
        zoneList.add(new Zone(103, "Mobility Zone RMS", "ecospace, bangalore, karnataka, india", 7.123456, 8.123456));
        zoneList.add(new Zone(101, "Mobility Zone Hebbal", "hebbal, garden road, bangalore, karnataka, india", 9.123456, 10.123456));
        zoneList.add(new Zone(104, "Mobility Zone Marathahalli Bridge", "marathahalli, bangalore, karnataka, india", 5.123456, 6.123456));
        zoneList.add(new Zone(105, "Mobility Zone Spice Garden", "marathahalli, bangalore, karnataka, india", 5.123456, 6.123456));
        zoneList.add(new Zone(106, "Mobility Zone AECS Layout", "kundalahalli gate, aecs layout road, bangalore, karnataka, india", 3.123456, 4.123456));
        zoneList.add(new Zone(107, "Mobility Zone Kundalahalli Signal", "kundalahalli gate, thubarahalli, bangalore, karnataka, india", 3.123456, 4.123456));

        // search zones with point coordinates within distance range
        List<Zone> res = zoneList.stream().filter(zone -> zone.getLatitude() == point.getX() && zone.longitude == point.getY() ).toList();
        return res;
    }
}
