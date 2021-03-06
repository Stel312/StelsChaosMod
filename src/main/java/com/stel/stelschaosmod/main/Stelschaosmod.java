package com.stel.stelschaosmod.main;


import com.stel.stelschaosmod.entitytypes.TypeEntities;
import com.stel.stelschaosmod.events.EntityRegisterHandler;
import com.stel.stelschaosmod.events.ForgeEventHandler;
import com.stel.stelschaosmod.events.ModFeatures;
import com.stel.stelschaosmod.lib.Strings;
import com.stel.stelschaosmod.model.mob.ModelRedfish;
import com.stel.stelschaosmod.model.mob.ModelSpawnerMob;
import com.stel.stelschaosmod.render.RenderMob;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("stelschaosmod")
public class Stelschaosmod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static Stelschaosmod instance;
    public Stelschaosmod()
    {
        StelsConfig.init();
        registerEntities();
        MinecraftForge.EVENT_BUS.register(this);

        //Client
        MinecraftForge.EVENT_BUS.register(new EntityRegisterHandler());
        MinecraftForge.EVENT_BUS.register(new ModFeatures());

        // Forge
        MinecraftForge.EVENT_BUS.register(new ForgeEventHandler());
    }



    private void setup(final FMLCommonSetupEvent event) { }

    private void enqueueIMC(final InterModEnqueueEvent event) { }

    public static void registerEntities() {
        RenderingRegistry.registerEntityRenderingHandler(TypeEntities.redfishEntityType,  new RenderMob
                (Minecraft.getInstance().getRenderManager(), new ModelRedfish<>(), .25f, Strings.Redfish));
        RenderingRegistry.registerEntityRenderingHandler(TypeEntities.spawnerMobEntityType, new RenderMob
                (Minecraft.getInstance().getRenderManager(), new ModelSpawnerMob<>(), .75F, Strings.SpawnerMob));
        RenderingRegistry.registerEntityRenderingHandler(TypeEntities.gnomeEntityType, new RenderMob
                (Minecraft.getInstance().getRenderManager(), new ModelSpawnerMob<>(), .75F, Strings.Gnome));
    }
}
