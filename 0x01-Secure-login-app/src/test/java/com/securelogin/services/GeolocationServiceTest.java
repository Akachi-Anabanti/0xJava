package com.securelogin.services;

import org.freedesktop.geoklue.Position;
import org.freedesktop.geoklue.PositionProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MocedStatic;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.beans.Transient;


public class GeolocationServiceTest {
    private GeolocationService geolocationService;
    private PositionProvider mockedProvider;

    @Before
    public void setUp() {
        geolocationService = new GeolocationService();
        mockedProvider = mock(PositionProvider.class);
    }

    @Test
    public void testVerifyLocation_WithinThreshold() throws Exception {
        Position mockPosition = new Position(37.7749, -122.4194, 0);
        when(mockedProvider.getCurrentPosition()).thenReturn(mockPosition);

        try (MockedStatic<PositionProvider> mockedStatic = Mockito.mockStatic(PositionProvider.class)) {
            mockedStatic.when(PositionProvider::create).thenReturn(mockedProvider);
            assertTrue(geolocationService.verifyLocation(37.7749, -122.4194));
        }
    }
    
}
