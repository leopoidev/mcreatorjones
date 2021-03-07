
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class KingkuntaItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:kingkunta")
	public static final Item block = null;

	public KingkuntaItem(JoneModVModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, JoneModVModElements.sounds.get(new ResourceLocation("jone_mod_v:kingkunta")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("kingkunta");
		}

	}

}
