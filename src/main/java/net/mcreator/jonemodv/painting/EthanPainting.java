
package net.mcreator.jonemodv.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.jonemodv.JoneModVModElements;

@JoneModVModElements.ModElement.Tag
public class EthanPainting extends JoneModVModElements.ModElement {
	public EthanPainting(JoneModVModElements instance) {
		super(instance, 44);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("ethan"));
	}
}
