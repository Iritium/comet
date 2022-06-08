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
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.player.FindItemResult;
import meteordevelopment.meteorclient.utils.player.InvUtils;
import meteordevelopment.meteorclient.utils.Utils;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.Items;

public class AutoFrameDupe extends Module {
    public enum Mode {
        Logout,
        Command
    }

    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Integer> range = sgGeneral.add(new IntSetting.Builder()
        .name("range:")
        .description("Reach range for item frame.")
        .defaultValue(5)
        .range(1, 5)
        .sliderRange(1, 5)
        .build()
    );

    private final Setting<Boolean> toggleOff = sgGeneral.add(new BoolSetting.Builder()
        .name("toggle-off")
        .description("Disables dupe if you're kicked.")
        .defaultValue(true)
        .build()
    );

    public AutoFrameDupe() {
        super(Categories.Comet, "auto-frame-dupe", "Automatically does the sweetanarchy.net item-frame dupe.");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {

        FindItemResult itemResult = InvUtils.findInHotbar(Items.ITEM_FRAME, Items.GLOW_ITEM_FRAME);
        if (!itemResult.found()) {
            Utils.sendToast("Item Frame Dupe", "No item frames in your hotbar!");
            toggle();
            return;
        }

        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof ItemFrameEntity) {
                Utils.sendToast("Item Frame Dupe", "Detected Frame, now duping!");
            }
        }

    }
}
