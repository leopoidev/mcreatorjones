
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class JonesingotItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:jonesingot")
	public static final Item block = null;

	public JonesingotItem(JoneModVModElements instance) {
		super(instance, 18);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("jonesingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
