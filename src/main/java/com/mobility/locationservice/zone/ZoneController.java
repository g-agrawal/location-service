package com.mobility.locationservice.zone;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private ZoneService zoneService;

    Logger log = LoggerFactory.getLogger(ZoneController.class);

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type")
    @GetMapping("/zones/nearBy")
    public ResponseEntity<List<Zone>> getNearByZones(@RequestParam double lat, @RequestParam double lng) {
        log.info("Request received for lat/lng");
        List<Zone> zones = zoneService.getNearestZones(lat, lng);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Get-Header", "ExampleHeader");
        return ResponseEntity.ok().headers(headers).body(zones);
    }
}
