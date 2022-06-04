package com.sw.service;

public class SWUtils {

    private static Boolean isActive = true;

    public static void toggleService() {
        isActive = !isActive;
    }

    public static Boolean isActive() {
        return isActive;
    }
}
