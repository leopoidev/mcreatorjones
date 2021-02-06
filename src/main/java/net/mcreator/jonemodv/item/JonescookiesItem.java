
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class JonescookiesItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:jonescookies")
	public static final Item block = null;

	public JonescookiesItem(JoneModVModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(7).saturation(0.3f).setAlwaysEdible()

							.build()));
			setRegistryName("jonescookies");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 36;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("gives you sped and streng"));
		}

	}

}
