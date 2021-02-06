
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class FishinatubeItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:fishinatube")
	public static final Item block = null;

	public FishinatubeItem(JoneModVModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, JoneModVModElements.sounds.get(new ResourceLocation("jone_mod_v:salmoinatu")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("fishinatube");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
