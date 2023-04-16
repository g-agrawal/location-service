package com.mobility.locationservice.zone.provider;

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
        zoneList.add(new Zone(101, "ABC", "Description ABC sdfasdf cvbxcvb erg ds gerg erg gs ser s vdf sdfg serg erg dfv "));
        zoneList.add(new Zone(120, "P QR", "Description P Q R"));
        zoneList.add(new Zone(143, "X Y Z", "Description X Y Z"));

        return zoneList;
    }
}
