package net.spooketti;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.PersistentState;

public class DetPClass extends PersistentState {
    
    @Override
    public NbtCompound writeNbt(NbtCompound nbt) 
    {
        nbt.putLong("LastUlt",System.currentTimeMillis());
        nbt.putString("PlayerClass", "a");    
        return null;
    }
    
}
