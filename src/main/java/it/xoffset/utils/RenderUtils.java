package it.xoffset.utils;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RenderUtils {

    public static Color rainbow(float offset) {
        float hue = ((float) System.nanoTime() + offset) / 1.0E10F % 1.0F;
        long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 1.0F, 1.0F)).intValue()),
                16);
        Color c = new Color((int) color);
        return new Color(c.getRed() / 255.0F, c.getGreen() / 255.0F, c.getBlue() / 255.0F, c.getAlpha() / 255.0F);
    }

    public static Color rainbow(long offset, float fade) {
        float hue = (float) (System.nanoTime() + offset) / 1.0E10F % 1.0F;
        long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 0.6F, 1.0F)).intValue()),
                16);
        Color c = new Color((int) color);
        return new Color(c.getRed() / 255.0F * 0, c.getGreen() / 255.0F * 0, c.getBlue() / 255.0F * 0,
                c.getAlpha() / 255.0F / 2);
    }

    public static int alpha(int color, float a){
        float r = (color >> 16 & 0xFF) / 255.0F;
        float g = (color >> 8 & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        return new Color(r, g, b, a).getRGB();
    }

    public static void entityESPBox(Entity entity, float width) {
        double x = entity.boundingBox.minX - 0.05 - RenderManager.renderPosX;
        double y = entity.boundingBox.minY - RenderManager.renderPosY;
        double z = entity.boundingBox.minZ - 0.05 - RenderManager.renderPosZ;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(width);
        float update = System.currentTimeMillis() % 2000 / 1000F;
        float r = (float)Math.sin(update * (float)Math.PI);
        float g = (float)Math.sin((update + 4F / 3F) * (float)Math.PI);
        float b = (float)Math.sin((update + 8F / 3F) * (float)Math.PI);
        GL11.glColor3f(r,g,b);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);

        RenderGlobal.drawOutlinedBoundingBox(AxisAlignedBB.getBoundingBox(
                x,
                y,
                z,
                x + entity.width + 0.1,
                y + entity.height + 0.1,
                z + entity.width + 0.1
        ), -1);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
