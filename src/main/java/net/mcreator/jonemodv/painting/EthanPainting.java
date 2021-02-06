
package net.mcreator.jonemodv.painting;

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
