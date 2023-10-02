package com.btlov._9_1_hw_autoconfiguration;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}

