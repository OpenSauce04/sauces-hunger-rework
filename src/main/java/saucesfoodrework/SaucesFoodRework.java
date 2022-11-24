package saucesfoodrework;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import squeek.applecore.api.AppleCoreAPI;
import squeek.applecore.api.hunger.ExhaustionEvent;

@Mod(modid = SaucesFoodRework.MODID, version = SaucesFoodRework.VERSION, dependencies = "required-before:applecore;required-before:appleskin")
public class SaucesFoodRework
{

  // you also need to update the modid and version in two other places as well:
  //  build.gradle file (the version, group, and archivesBaseName parameters)
  //  resources/mcmod.info (the name, description, and version parameters)
  public static final String MODID = "saucesfoodrework";
  public static final String VERSION = "1.0.1";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
    MinecraftForge.EVENT_BUS.register(new ExhaustionEventHandler());
  }
}
