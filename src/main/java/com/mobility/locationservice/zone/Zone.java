package com.mobility.locationservice.zone;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
public class Zone {
    public int zoneId;
    public String name;
    public String completeAddress;
    public double latitude;
    public double longitude;
    public int vehicleCount;
    public boolean availableAlways;
    public Date startDate;
    public Date endDate;
    public Zone(int zoneId, String name, String completeAddress, double latitude, double longitude) {
        this.zoneId = zoneId;
        this.name = name;
        this.completeAddress = completeAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}