package com.securelogin.model;

public class User {
    private Long id;
    private String username;
    private String passwordHash;
    private byte[] fingerprint;
    private Double lastLatitude;
    private Double lastLongitude;


    // Getters and setters
    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}
    
    public String getUsername(String username) { return username; }
    public void setUsername(String username) { this.username = username;}

    public String getPasswordHash() { return passwordHash;}
    public void setPasswordHash(String passwordHash) { this.passwordHash =  passwordHash;}

    public byte[] getFingerprint() { return fingerprint;}
    public void setFingerprint(byte[] fingerprint) { this.fingerprint = fingerprint;}

    public Double getLastLittude() { return lastLatitude;}
    public void setLastLatitude(Double lastlatitude) { this.lastLatitude = lastlatitude;}

    public Double getLastLongitude() { return lastlongitude; }
    public void setLastLongitude(Double lastlongitude) { this.lastLongitude = lastlongitude;}
}