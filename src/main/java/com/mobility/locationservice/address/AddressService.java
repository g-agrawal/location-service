package com.mobility.locationservice.address;

import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    public List<Address> getAddresses(String text);
}
