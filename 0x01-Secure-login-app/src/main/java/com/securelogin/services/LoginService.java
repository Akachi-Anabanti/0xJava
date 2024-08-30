package com.securelogin.services;

import com.securelogin.dao.UserDao;
import com.securelogin.model.User;
import com.securelogin.util.SecurityUtil;

public class LoginService {
    private UserDao userDao;
    private BiometericService biometricService;
    private GeolocationService geolocationService;

    public LoginService() {
        this.userDao = new UserDao();
        this.biometricService = new BiometericService();
        this.geolocationService = new GeolocationService();
    }

    public boolean login(String usernmame, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }
        if (!SecurityUtil.verifyPassword(password, user.getPasswordHash())) {
            return false;
        }

        if (!biometricService.verifyFingerprint(user.getFingerprint())) {
            return false;
        }

        if (!geolocationService.verifyLocation(user.getLastLittude(), user.getLastLongitude)) {
            return false;
        }
        updateUserLocation(user);
        return true;
    }

    private byte[] getCurrentFingerprint() {
        // TODO: interface with real fingerprint hardware
        return new byte[]{1, 2, 3, 4, 5};
    }

    private void updateUserLocation(User user) {
        try {
            Position currentPosition = geolocationService.getCurrentPosition();
            user.setLatitude(currentPostion.getLatitude());
            user.setLastLongitude(currentPosition.getLongitude());
            userDao.updateLocation(user);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}