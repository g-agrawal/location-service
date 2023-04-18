package com.mobility.locationservice.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    public AddressService addressService;

    @GetMapping("/address/search")
    public ResponseEntity<List<Address>> getMatchAddresses(@RequestParam String text) {
        List<Address> addressList = addressService.getAddresses(text);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Get-Header", "ExampleHeader");
        return ResponseEntity.ok().headers(headers).body(addressList);
    }
}
