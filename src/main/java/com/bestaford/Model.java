package com.bestaford;

import cn.nukkit.entity.EntityHuman;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class Model extends EntityHuman {

    public Model(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
}