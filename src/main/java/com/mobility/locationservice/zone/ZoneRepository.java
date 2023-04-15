package com.mobility.locationservice.zone;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository {
    List<Zone> findByLocationNear(Point point, Distance distance);
}
