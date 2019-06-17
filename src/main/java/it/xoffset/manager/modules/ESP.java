package it.xoffset.manager.modules;

import ibxm.Player;
import it.xoffset.manager.Module;
import it.xoffset.utils.RenderUtils;
import it.xoffset.utils.Wrapper;
import net.minecraft.entity.Entity;
import org.lwjgl.input.Keyboard;

public class ESP extends Module {

    public ESP(){
        super("ESP", Keyboard.KEY_L);
    }

    @Override
    public void onRender3D() {
        Wrapper.mc.theWorld.loadedEntityList.stream()
                .filter(e->
                        e != Wrapper.mc.thePlayer &&
                        ((Entity)e).getDistanceToEntity(Wrapper.mc.thePlayer) < 20f
                )
                .forEach(e->RenderUtils.entityESPBox((Entity) e,1));
    }
}
