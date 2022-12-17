package sauceshungerrework;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import squeek.applecore.api.AppleCoreAPI;
import squeek.applecore.api.hunger.ExhaustionEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;

@Mod(modid = SaucesHungerRework.MODID, version = SaucesHungerRework.VERSION, dependencies = "required-before:applecore;required-before:appleskin")
public class SaucesHungerRework
{

  // you also need to update the modid and version in two other places as well:
  //  build.gradle file (the version, group, and archivesBaseName parameters)
  //  resources/mcmod.info (the name, description, and version parameters)
  public static final String MODID = "sauceshungerrework";
  public static final String VERSION = "1.0.3";
  
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
    ConfigManager.sync(MODID, Type.INSTANCE);
    MinecraftForge.EVENT_BUS.register(new SaucesHungerRework());
    MinecraftForge.EVENT_BUS.register(new ExhaustionEventHandler());
  }

  @SubscribeEvent
  public void onConfigChangedEvent(OnConfigChangedEvent event)
  {
      if (event.getModID().equals(MODID))
      {
          ConfigManager.sync(MODID, Type.INSTANCE);
      }
  }

  @Config(modid = MODID, type = Type.INSTANCE)
  public static class Configs {
    @Name("Allow eating when hunger bar is not empty")
    public static boolean AllowEatingWhenNotHungry = false;
  }

}
