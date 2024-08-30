package com.securelogin.services;

import org.freedesktop.geoklue.Position;
import org.freedesktop.geoklue.PositionProvider;


public class GeolocationService {
    private static final double DISTANCE_THRESHOLD = 0.1; // 0.1 degree, roughly 11km

    public boolean verifyLocation(double storedLatitude, double storedLongitude) {
        try {
            Position currentPosition = getCurrentPosition();
            double distance = calculateDistance(storedLatitude, storedLongitude, currentPosition.getLatitude(), currentPosition.getLongitude());

            return distance <= DISTANCE_THRESHOLD;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Position getCurrentPosition() throws Exception {
        PositionProvider provider = PositionProvider.create();
        return provider.getCurrentPosition();
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Haversine Formula;
        double R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin( dLat/2) * Math.sin(dLat/2) +
        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
        Math.sin(dlon/2) * Math.sin(dlon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}