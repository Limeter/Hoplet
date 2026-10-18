package com.limeter.hoplet;

import com.limeter.hoplet.mixin.LivingEntityAccessor;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public final class JumpDelayHandler {

    private JumpDelayHandler() {
    }

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                ((LivingEntityAccessor) client.player).hoplet$setJumpingCooldown(0);
            }
        });
    }
}