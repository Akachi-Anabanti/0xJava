package com.securelogin.services;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class BiometricService {
    private static final double THRESHOLD = 40;

    public boolean verifyFingerprint(byte[] storedTemplate, byte[] providedFingerprint) {
        FingerprintTemplate candidate = new FingerprintTemplate().dpi(500).create(providedFingerprint);

        FingerprintTemplate probe = new FingerprintTemplate().dpi(500).create(storedTemplate);

        double score = new FingerprintMatcher().index(probe).match(candidate);

        return score >= THRESHOLD;
    }
}