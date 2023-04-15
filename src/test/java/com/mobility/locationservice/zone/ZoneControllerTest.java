package com.mobility.locationservice.zone;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobility.locationservice.LocationServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@WebMvcTest(ZoneController.class)
public class ZoneControllerTest {
    @MockBean
    private ZoneRepository zoneRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_return_list_of_zones_with_filter() throws Exception {
        List<Zone> zones = new ArrayList<>();
        zones.add(new Zone(101, "ABC", "Description ABC"));
        zones.add(new Zone(120, "P QR", "Description P Q R"));
        zones.add(new Zone(143, "X Y Z", "Description X Y Z"));
        double lat = 6.123456;
        double lng = 7.123456;
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("lat", "6.123456");
        paramsMap.add("lng", "7.123456");

        Point point = new Point(lat, lng);
        Distance distanceKm = new Distance(2, Metrics.KILOMETERS);

        when(zoneRepository.findByLocationNear(point, distanceKm)).thenReturn(zones);
        mockMvc.perform(get("/zones/nearBy").params(paramsMap))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(zones.size()));
    }
}
