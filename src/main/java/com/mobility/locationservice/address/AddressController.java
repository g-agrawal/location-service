package com.mobility.locationservice.address;

import com.mobility.locationservice.address.provider.AddressProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    public AddressProviderService addressService;

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type")
    @GetMapping("/address/search")
    public ResponseEntity<List<Address>> getMatchAddresses(@RequestParam String text) {
        List<Address> addressList = addressService.getAddresses(text);
        //List<Address> addressList = new ArrayList<>();
        System.out.println(text);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Get-Header", "ExampleHeader");
        return ResponseEntity.ok().headers(headers).body(addressList);
    }
}
