package com.limeter.hoplet;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hoplet.MODID, value = Dist.CLIENT)
public final class JumpDelayHandler {

    @SubscribeEvent
    public static void onClientTickEnd(TickEvent.ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            mc.player.noJumpDelay = 0;
        }
    }
}
