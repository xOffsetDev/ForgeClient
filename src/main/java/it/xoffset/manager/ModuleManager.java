package it.xoffset.manager;

import it.xoffset.manager.modules.ESP;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module>  modules = new ArrayList<Module>();

    public ModuleManager(){
        getModules().add((new ESP()));
    }

    public Module getModuleByClass(final Class<Module> module){
        return modules.stream().filter(m->m.getClass().equals(module.getClass())).findFirst().get();
    }

    public Module getModuleByName(String name){
        return modules.stream().filter(m->m.getName().equals(name)).findFirst().get();
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
}
