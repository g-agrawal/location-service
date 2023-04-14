package com.mobility.locationservice.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private int id;
    private String name;
    private String completeAddress;
    private double latitude;
    private double longitude;
    public Address() {
    }
    public Address(int id, String name, String completeAddress, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.completeAddress = completeAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
