package com.bestaford;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.level.Position;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.plugin.PluginBase;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModelAPI extends PluginBase {

    @Override
    public void onEnable() {
        Entity.registerEntity("Model", Model.class);
    }

    public static Skin createSkin(String name, Path skinPath, Path geometryPath) throws IOException {
        Skin skin = new Skin();
        skin.setSkinData(ImageIO.read(skinPath.toFile()));
        skin.setGeometryName("geometry." + name);
        skin.setGeometryData(new String(Files.readAllBytes(geometryPath)));
        return skin;
    }

    public static Model createModel(Position position, Skin skin) {
        CompoundTag nbt = Entity.getDefaultNBT(position);
        CompoundTag skinTag = new CompoundTag()
                .putByteArray("Data", skin.getSkinData().data)
                .putInt("SkinImageWidth", skin.getSkinData().width)
                .putInt("SkinImageHeight", skin.getSkinData().height)
                .putString("ModelId", skin.getSkinId())
                .putByteArray("SkinResourcePatch", skin.getSkinResourcePatch().getBytes(StandardCharsets.UTF_8))
                .putByteArray("GeometryData", skin.getGeometryData().getBytes(StandardCharsets.UTF_8))
                .putBoolean("IsTrustedSkin", true);
        nbt.putCompound("Skin", skinTag);
        return new Model(position.getChunk(), nbt);
    }
}