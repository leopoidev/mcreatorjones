
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class Bulletmp5Item extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:bulletmp_5")
	public static final Item block = null;

	public Bulletmp5Item(JoneModVModElements instance) {
		super(instance, 52);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bulletmp_5");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("bullet"));
		}

	}

}
