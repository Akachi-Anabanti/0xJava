package com.securelogin.service;

import com.securelogin.dao.UserDao;
import com.securelogin.model.User;
import com.securelogin.util.SecurityUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginServiceTest {
    @Mock
    private UserDao userDao;
    @Mock
    private BiometricService biometricService;
    @Mock
    private GeolocationService geolocationService;

    private LoginService loginService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        loginService = new LoginService(userDao, biometricService, geolocationService);
    }

    @Test
    public void testLogin_SuccessfulLogin() {
        String username = "testuser";
        String password = "password123";
        String hashedPassword = SecurityUtil.hashPassword(password);

        User mockUser = new User();
        mockUser.setUsername(username);
        mockUser.setPasswordHash(hashedPassword);
        mockUser.setFingerprint(new byte[]{1, 2, 3, 4, 5});
        mockUser.setLastLatitude(37.7749);
        mockUser.setLastLongitude(-122.4194);

        when(userDao.findByUsername(username)).thenReturn(mockUser);
        when(biometricService.verifyFingerprint(any(), any())).thenReturn(true);
        when(geolocationService.verifyLocation(anyDouble(), anyDouble())).thenReturn(true);

        assertTrue(loginService.login(username, password));

        verify(userDao).findByUsername(username);
        verify(biometricService).verifyFingerprint(any(), any());
        verify(geolocationService).verifyLocation(anyDouble(), anyDouble());
    }

    @Test
    public void testLogin_FailedLogin_WrongPassword() {
        String username = "testuser";
        String correctPassword = "password123";
        String wrongPassword = "wrongpassword";
        String hashedPassword = SecurityUtil.hashPassword(correctPassword);

        User mockUser = new User();
        mockUser.setUsername(username);
        mockUser.setPasswordHash(hashedPassword);

        when(userDao.findByUsername(username)).thenReturn(mockUser);

        assertFalse(loginService.login(username, wrongPassword));

        verify(userDao).findByUsername(username);
        verify(biometricService, never()).verifyFingerprint(any(), any());
        verify(geolocationService, never()).verifyLocation(anyDouble(), anyDouble());
    }

    // Add more test cases for other scenarios (e.g., failed biometric, failed geolocation)
}