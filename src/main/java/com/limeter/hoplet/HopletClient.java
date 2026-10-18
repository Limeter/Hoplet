package com.limeter.hoplet;

import net.fabricmc.api.ClientModInitializer;

public final class HopletClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        JumpDelayHandler.register();
    }
}