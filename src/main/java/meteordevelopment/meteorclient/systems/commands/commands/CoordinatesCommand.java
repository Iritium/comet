package meteordevelopment.meteorclient.systems.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.utils.Utils;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class CoordinatesCommand extends Command {
    public CoordinatesCommand() {
        super("coordinates", "Copies your coordinates to the clipboard.", "coords", "cc", "cords");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            mc.keyboard.setClipboard(mc.player.getBlockPos().getX() + ", " + mc.player.getBlockPos().getZ());
            Utils.sendToast("Coordinates", "Coordinates copied to your clipboard");
            return SINGLE_SUCCESS;
        });
    }
}
