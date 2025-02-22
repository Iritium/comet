/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package meteordevelopment.meteorclient.systems.hud.modules;

import meteordevelopment.meteorclient.renderer.GL;
import meteordevelopment.meteorclient.renderer.Renderer2D;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.hud.HUD;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import net.minecraft.util.Identifier;

import static meteordevelopment.meteorclient.utils.Utils.WHITE;

public class CometLogo extends HudElement {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> scale = sgGeneral.add(new DoubleSetting.Builder()
        .name("scale")
        .description("The scale of the logo.")
        .defaultValue(4)
        .min(0.1)
        .sliderRange(0.1, 10)
        .build()
    );

    private final Identifier TEXTURE = new Identifier("meteor-client", "textures/banner.png");

    public CometLogo(HUD hud) {
        super(hud, "Comet Logo", "Shows the Comet logo in the HUD.");
    }

    @Override
    public void update(HudRenderer renderer) {
        box.setSize(33 * scale.get(), 12 * scale.get());
    }

    @Override
    public void render(HudRenderer renderer) {
        GL.bindTexture(TEXTURE);
        Renderer2D.TEXTURE.begin();
        Renderer2D.TEXTURE.texQuad(box.getX(), box.getY(), box.width, box.height, WHITE);
        Renderer2D.TEXTURE.render(null);
    }
}
