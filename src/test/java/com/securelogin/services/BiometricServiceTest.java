package com.securelogin.services;

import org.junit.before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;


public class biometricServiceTest {

    private BiometericService biometricService;

    @before
    public void setUp() {
        biometricService = new BiometericService();
    }

    @Test
    public void testVerifyFingerprint_MatchingFingerprints() {
        byte[] storeTemplate = {1, 2, 3, 4, 5};
        byte[] providedFingerprint = {1, 2, 3, 4, 5};

        assertTrue(biometricService.verifyFingerprint(storeTemplate, providedFingerprint));
    }

    @Test
    public void testVerifyFingerprint_NonMatchingFingerprints() {
        byte[] storedTemplate = {1, 2,3 ,4, 5};
        byte[] providedFingerprint = {6, 7, 8, 9, 10};

        assertFalse(biometricService.verifyFingerprint(storedTemplate, providedFingerprint));
    }
}