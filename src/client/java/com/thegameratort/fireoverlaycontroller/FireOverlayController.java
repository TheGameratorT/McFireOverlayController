package com.thegameratort.fireoverlaycontroller;

import com.thegameratort.fireoverlaycontroller.config.FireOverlayControllerConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class FireOverlayController implements ClientModInitializer {
    private static FireOverlayControllerConfig config;

    @Override
    public void onInitializeClient() {
        System.out.println("Fire Overlay Controller started.");
        ConfigHolder<FireOverlayControllerConfig> configHolder = AutoConfig.register(FireOverlayControllerConfig.class, Toml4jConfigSerializer::new);
        FireOverlayController.config = configHolder.getConfig();
    }

    public static FireOverlayControllerConfig getConfig() {
        return FireOverlayController.config;
    }
}
