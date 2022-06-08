/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package meteordevelopment.meteorclient.systems.commands.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.command.CommandSource;
import net.minecraft.text.LiteralText;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class CoordinatesCommand extends Command {
    public CoordinatesCommand() {
        super("coordinates", "Copies your coordinates to the clipboard.", "coords", "cc", "cords");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            mc.keyboard.setClipboard(mc.player.getBlockPos().getX() + ", " + mc.player.getBlockPos().getZ());
            sendToast("Coordinates", "Coordinates copied to your clipboard");
            return SINGLE_SUCCESS;
        });
    }
}
