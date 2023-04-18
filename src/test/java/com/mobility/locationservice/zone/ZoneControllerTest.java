package com.mobility.locationservice.zone;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebMvcTest(ZoneController.class)
public class ZoneControllerTest {

    @MockBean
    private ZoneService zoneService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_return_list_of_zones_with_filter() throws Exception {
        List<Zone> zones = new ArrayList<>();
        zones.add(new Zone(106, "Mobility Zone AECS Layout", "kundalahalli gate, aecs layout road, bangalore, karnataka, india", 3.123456, 4.123456));
        zones.add(new Zone(107, "Mobility Zone Kundalahalli Signal", "kundalahalli gate, thubarahalli, bangalore, karnataka, india", 3.123456, 4.123456));

        double lat = 3.123456;
        double lng = 4.123456;
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("lat", "3.123456");
        paramsMap.add("lng", "4.123456");

        when(zoneService.getNearestZones(lat, lng)).thenReturn(zones);

        mockMvc.perform(get("/zones/nearBy").params(paramsMap))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(zones.size()));
    }
}
