/**
 * Приложение по uri http://localhost:8080/profile передает в контроллер либо бин "productionProfile", либо бин "devProfile"
 */
package com.btlov._9_1_hw_autoconfiguration;

public interface SystemProfile {
    String getProfile();
}