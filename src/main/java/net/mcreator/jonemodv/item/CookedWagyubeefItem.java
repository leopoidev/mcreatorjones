
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class CookedWagyubeefItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:cooked_wagyubeef")
	public static final Item block = null;

	public CookedWagyubeefItem(JoneModVModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f)

							.build()));
			setRegistryName("cooked_wagyubeef");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("its a pain"));
		}

	}

}
