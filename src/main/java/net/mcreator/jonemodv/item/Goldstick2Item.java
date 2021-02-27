
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class Goldstick2Item extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:goldstick_2")
	public static final Item block = null;

	public Goldstick2Item(JoneModVModElements instance) {
		super(instance, 47);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("goldstick_2");
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
			list.add(new StringTextComponent("gold"));
		}

	}

}
