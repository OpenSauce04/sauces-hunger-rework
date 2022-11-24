package saucesfoodrework;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import squeek.applecore.api.AppleCoreAPI;
import squeek.applecore.api.hunger.ExhaustionEvent;

public class ExhaustionEventHandler {
  @SubscribeEvent
	public void onExhaustionAddition(ExhaustionEvent.ExhaustionAddition event) {
	
    AppleCoreAPI.mutator.setExhaustion(event.player, 0f);

		if (event.player.getFoodStats().getSaturationLevel() > 0f) { // 
      AppleCoreAPI.mutator.setHunger(event.player, 20); // Allow healing, disable eating food
    } else {
      AppleCoreAPI.mutator.setHunger(event.player, 17); // Just enough to not allow natural health recovery
    }

  }
}