package com.mobility.locationservice.zone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZoneController {



    //localhost:3000
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type")
    @GetMapping("/zones/nearBy")
    public ResponseEntity<List<Zone>> getNearByZones(@RequestParam double lat, @RequestParam double lng) {
        List<Zone> zoneList = new ArrayList<>();
        zoneList.add(new Zone(101, "ABC", "Description ABC sdfasdf cvbxcvb erg ds gerg erg gs ser s vdf sdfg serg erg dfv "));
        zoneList.add(new Zone(120, "P QR", "Description P Q R"));
        zoneList.add(new Zone(143, "X Y Z", "Description X Y Z"));

        Point point = new Point(lat, lng);
        Distance distanceKm = new Distance(2, Metrics.KILOMETERS);
        //List<Zone> zones = zoneRepository.findByLocationNear(point, distanceKm);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Get-Header", "ExampleHeader");
        return ResponseEntity.ok().headers(headers).body(zoneList);
    }
}
