/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package meteordevelopment.meteorclient.systems.modules.comet;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.friends.Friends;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.DisconnectS2CPacket;
import net.minecraft.text.LiteralText;

public class AutoLeave extends Module {
    public enum Mode {
        Logout,
        Command
    }

    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Integer> range = sgGeneral.add(new IntSetting.Builder()
        .name("range:")
        .description("Disconnects if player is in your range.")
        .defaultValue(5)
        .range(1, 128)
        .sliderRange(1, 10)
        .build()
    );

    private final Setting<Boolean> ignoreFriends = sgGeneral.add(new BoolSetting.Builder()
        .name("ignore-friends")
        .description("Ignore your added friends.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Boolean> toggleOff = sgGeneral.add(new BoolSetting.Builder()
        .name("toggle-off")
        .description("Disables auto-leave after logout.")
        .defaultValue(true)
        .build()
    );

    public AutoLeave() {
        super(Categories.Comet, "auto-leave", "Automatically leaves when a player is in range.");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof PlayerEntity) {
                if (entity.getUuid() != mc.player.getUuid() && mc.player.distanceTo(entity) < range.get()) {
                    if (ignoreFriends.get() && Friends.get().isFriend((PlayerEntity) entity)) return;

                    mc.player.networkHandler.onDisconnect(new DisconnectS2CPacket(new LiteralText("[Comet Autoleave] Player detected in configed range.")));

                    if (toggleOff.get()) this.toggle();
                }
            }
        }
    }
}
