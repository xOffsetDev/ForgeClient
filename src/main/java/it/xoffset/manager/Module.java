package it.xoffset.manager;

public class Module {

    private String name;
    private int key;

    private boolean state;

    public Module(String name, int keybind){
        this.name = name;
        this.key = keybind;
    }

    public String getName() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean getState() {
        return state;
    }

    public void toggle() {
        this.state = !state;
        if(state) onEnable();
        else onDisable();
    }

    public void onEnable(){}
    public void onDisable(){}
    public void onUpdate(){}
    public void onRender(){}
    public void onRender3D() {}
}
