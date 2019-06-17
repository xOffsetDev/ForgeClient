package it.xoffset;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import it.xoffset.manager.ModuleManager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="")
public class Main {

    private static ModuleManager moduleManager;
    private static Events events;

    @Mod.EventHandler
    public void fmlInitialization(FMLInitializationEvent event) {
        this.moduleManager = new ModuleManager();
        this.events = new Events();
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(events);
        FMLCommonHandler.instance().bus().register(events);

    }

    public static ModuleManager getModuleManager() {
        return moduleManager;
    }

    public static Events getEvents() {
        return events;
    }
}
