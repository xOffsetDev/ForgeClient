package it.xoffset;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import it.xoffset.manager.Module;
import it.xoffset.utils.RenderUtils;
import it.xoffset.utils.Wrapper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.input.Keyboard;

public class Events {

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent e) {
        Main.getModuleManager().getModules().stream().filter(Module::getState).forEach(Module::onUpdate);
    }

    @SubscribeEvent
    public void onRender(TickEvent.RenderTickEvent e) {
        int y = 2;
        for(Module m : Main.getModuleManager().getModules()){
            if(!m.getState()) return;
            Wrapper.fr.drawString(m.getName(),2,2 + (y*2), RenderUtils.rainbow(1f).getRGB());
            y += 2;
        }

        Main.getModuleManager().getModules().stream().filter(Module::getState).forEach(Module::onRender);
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent  e) {
        Main.getModuleManager().getModules().stream().filter(module-> Keyboard.isKeyDown(module.getKey())).forEach(Module::toggle);
    }

    @SubscribeEvent
    public void onRender3D(RenderWorldLastEvent e){
        Main.getModuleManager().getModules().stream().filter(Module::getState).forEach(Module::onRender3D);
    }

}
