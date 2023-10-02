package com.btlov._9_1_hw_autoconfiguration;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}