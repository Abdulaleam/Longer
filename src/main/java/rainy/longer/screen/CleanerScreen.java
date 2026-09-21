package rainy.longer.screen;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import rainy.longer.Longer;

public class CleanerScreen extends AbstractContainerScreen<CleanerMenu> {

    private static final Identifier GUI_TEXTURE =
            Identifier.fromNamespaceAndPath(Longer.MOD_ID, "textures/gui/cleaning/gui.png");

    private static final Identifier ARROW_TEXTURE =
            Identifier.fromNamespaceAndPath(Longer.MOD_ID, "textures/gui/cleaning/arrow_progress.png");

    public CleanerScreen(CleanerMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0,
                imageWidth, imageHeight, 256, 256);

        renderProgressArrow(graphics, x, y);
    }

    private void renderProgressArrow(GuiGraphicsExtractor graphics, int x, int y) {
        if (menu.isCrafting()) {
            graphics.blit(RenderPipelines.GUI_TEXTURED, ARROW_TEXTURE, x + 73, y + 35, 0, 0,
                    menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }
}