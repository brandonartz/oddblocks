package net.fabricmc.oddblocks.screens;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.oddblocks.screen_handlers.OddAutoMinerScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class OddAutoMinerScreen extends HandledScreen<OddAutoMinerScreenHandler> {
    //A path to the gui texture. In this example we use the texture from the dispenser
    private static final Identifier TEXTURE = new Identifier("oddblocks", "textures/gui/container/oddautominer.png");
    
    public OddAutoMinerScreen(OddAutoMinerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    
    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        int k;
        int i = this.x;
        int j = this.y;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        //Draws the background of the UI
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        if ((this.handler).isBurning()) {
            k = (this.handler).getFuelProgress();
            //Draws the fire onto the background
            this.drawTexture(matrices, i + 81, j + 31 - k, 176, 12 - k, 14, k + 1);
        }
    }
    
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
    
    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}

