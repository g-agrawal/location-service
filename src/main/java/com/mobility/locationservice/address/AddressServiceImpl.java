package com.mobility.locationservice.address;

import com.mobility.locationservice.address.provider.AddressProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressProviderService addressProviderService;

    @Override
    public List<Address> getAddresses(String text) {
        return addressProviderService.getAddresses(text);
    }
}