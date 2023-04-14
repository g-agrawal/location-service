package com.mobility.locationservice.address.provider;

import com.mobility.locationservice.address.Address;

import java.util.List;

public interface AddressProviderService {
    List<Address> getAddresses(String text);
}
