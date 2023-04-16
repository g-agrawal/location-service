package com.mobility.locationservice.address.provider;


import com.mobility.locationservice.address.Address;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeAddressProviderService implements AddressProviderService {
    @Override
    public List<Address> getAddresses(String text) {
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(1, "ecospace, silk board", "bangalore, karnataka, india", 6.123456, 7.123456));
        addressList.add(new Address(2, "ecospace, bellandur", "bangalore, karnataka, india", 6.123456, 7.123456));
        addressList.add(new Address(3, "rmz, pech park", "bangalore, karnataka, india", 6.123456, 7.123456));
        addressList.add(new Address(4, "manyata, tech park", "bangalore, karnataka, india", 6.123456, 7.123456));
        List<Address> res = addressList.stream().filter(address -> address.getName().toLowerCase().contains(text) || address.getCompleteAddress().toLowerCase().contains(text)).toList();
        return res;
    }
}
