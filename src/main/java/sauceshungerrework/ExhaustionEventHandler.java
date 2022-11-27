package sauceshungerrework;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import squeek.applecore.api.AppleCoreAPI;
import squeek.applecore.api.hunger.ExhaustionEvent;


public class ExhaustionEventHandler {

  private void HandleExhaustion(EntityPlayer player, float deltaSaturation) {

    if (player.getFoodStats().getSaturationLevel() + deltaSaturation > 0f) { 
      AppleCoreAPI.mutator.setHunger(player, 20); // Allow healing, disable eating food
    } else {
      AppleCoreAPI.mutator.setHunger(player, 17); // Just enough to not allow natural health recovery
      AppleCoreAPI.mutator.setExhaustion(player, 0);
    }

  }

  @SubscribeEvent
	public void onExhaustionAddition(ExhaustionEvent.ExhaustionAddition event) {
    HandleExhaustion(event.player, 0f);
  }
  @SubscribeEvent
	public void onExhausted(ExhaustionEvent.Exhausted event) {
    HandleExhaustion(event.player, event.deltaSaturation);
  }

  @SubscribeEvent
	public void onExhaustingAction(ExhaustionEvent.ExhaustingAction event) {
    event.deltaExhaustion = 0f;
  }
  
}