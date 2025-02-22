package meteordevelopment.meteorclient.systems.modules.comet;

import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import meteordevelopment.meteorclient.utils.player.PlayerUtils;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldEventS2CPacket;
import net.minecraft.text.BaseText;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

import java.util.UUID;

import static meteordevelopment.meteorclient.utils.Utils.sendToast;

public class CoordinateLogger extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final SettingGroup sgTeleports = settings.createGroup("Teleports");
    private final SettingGroup sgWorldEvents = settings.createGroup("World Events");

    public CoordinateLogger() {
        super(Categories.Comet, "CoordinateLogger", "Log coordinates when events world happen.");
    }

    private final Setting<Double> minDistance = sgGeneral.add(new DoubleSetting.Builder()
        .name("minimum-distance")
        .description("Minimum distance to log event.")
        .min(5)
        .max(100)
        .sliderMin(5)
        .sliderMax(100)
        .defaultValue(10)
        .build()
    );

    private final Setting<Boolean> players = sgTeleports.add(new BoolSetting.Builder()
        .name("players")
        .description("Logs player teleports.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Boolean> wolves = sgTeleports.add(new BoolSetting.Builder()
        .name("wolves")
        .description("Logs wolf teleports.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> enderDragons = sgWorldEvents.add(new BoolSetting.Builder()
        .name("ender-dragons")
        .description("Logs killed ender dragons.")
        .defaultValue(false)
        .build()
    );
    private final Setting<Boolean> endPortals = sgWorldEvents.add(new BoolSetting.Builder()
        .name("end-portals")
        .description("Logs opened end portals.")
        .defaultValue(false)
        .build()
    );
    private final Setting<Boolean> withers = sgWorldEvents.add(new BoolSetting.Builder()
        .name("withers")
        .description("Logs wither spawns.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> otherEvents = sgWorldEvents.add(new BoolSetting.Builder()
        .name("other-global-events")
        .description("Logs other global events.")
        .defaultValue(false)
        .build()
    );

    @EventHandler
    private void onPacketReceive(PacketEvent.Receive event) {
        if (event.packet instanceof EntityPositionS2CPacket) {
            EntityPositionS2CPacket packet = (EntityPositionS2CPacket) event.packet;

            try {
                Entity entity = mc.world.getEntityById(packet.getId());

                if (entity.getType().equals(EntityType.PLAYER) && players.get()) {
                    Vec3d packetPosition = new Vec3d(packet.getX(), packet.getY(), packet.getZ());
                    Vec3d playerPosition = entity.getPos();

                    if (playerPosition.distanceTo(packetPosition) >= minDistance.get()) {
                        sendToast("Player Teleported", String.valueOf(packetPosition));
                    }
                }

                else if (entity.getType().equals(EntityType.WOLF) && wolves.get()) {
                    Vec3d packetPosition = new Vec3d(packet.getX(), packet.getY(), packet.getZ());
                    Vec3d wolfPosition = entity.getPos();

                    UUID ownerUuid = ((TameableEntity) entity).getOwnerUuid();

                    if (ownerUuid != null && wolfPosition.distanceTo(packetPosition) >= minDistance.get()) {
                        sendToast("Wolf Teleport", String.valueOf(packetPosition));
                    }
                }
            } catch(NullPointerException ignored) {}
        } else if (event.packet instanceof WorldEventS2CPacket worldEventS2CPacket) {

            if (worldEventS2CPacket.isGlobal()) {
                if (PlayerUtils.distanceTo(worldEventS2CPacket.getPos()) <= minDistance.get()) return;

                switch (worldEventS2CPacket.getEventId()) {
                    case 1023:
                        if (withers.get()) sendToast("Wither Spawn", String.valueOf(worldEventS2CPacket.getPos()));
                        break;
                    case 1038:
                        if (endPortals.get()) sendToast("Endportal Activated", String.valueOf(worldEventS2CPacket.getPos()));
                        break;
                    case 1028:
                        if (enderDragons.get()) sendToast("Ender Dragon Killed", String.valueOf(worldEventS2CPacket.getPos()));
                        break;
                    default:
                        if (otherEvents.get()) sendToast("Unknown Event", String.valueOf(worldEventS2CPacket.getPos()));
                }
            }
        }
    }

    public BaseText formatMessage(String message, Vec3d coords) {
        BaseText text = new LiteralText(message);
        text.append(ChatUtils.formatCoords(coords));
        text.append(Formatting.GRAY + ".");
        return text;
    }
}
