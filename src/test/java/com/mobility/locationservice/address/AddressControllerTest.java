package com.mobility.locationservice.address;

import com.mobility.locationservice.zone.ZoneController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public AddressService addressService;

    @Test
    void should_return_valid_address() throws Exception {
        String searchText = "ecospace";
        List<Address> resultList = new ArrayList<>();
        resultList.add(new Address(1, "ecospace, silk board", "bangalore, karnataka, india", 6.123456, 7.123456));
        resultList.add(new Address(2, "ecospace, bellandur", "bangalore, karnataka, india", 6.123456, 7.123456));

        when(addressService.getAddresses(searchText)).thenReturn(resultList);

        mockMvc.perform(get("/address/search").param("text", searchText))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(resultList.size()));
    }
}
