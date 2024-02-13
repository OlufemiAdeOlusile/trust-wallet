package com.trustWallet.config;

public class Configs {
    public static String APPIUM_URL = getConfigValue("trust_wallet.APPIUM_URL");
    public static String PLATFORM_NAME = getConfigValue("trust_wallet.PLATFORM_NAME");

    public static String DEVICE_NAME = getConfigValue("trust_wallet.DEVICE_NAME");

    public static String AUTOMATION_NAME = getConfigValue("trust_wallet.AUTOMATION_NAME");

    public static String UDID = getConfigValue("trust_wallet.UDID");

    public static String APP_PATH = getConfigValue("trust_wallet.APP_PATH");
    public static String AVD= getConfigValue("trust_wallet.AVD");

    static String getConfigValue(String path) {
        return ConfigResolver.getConfig().getString(path);
    }
}
