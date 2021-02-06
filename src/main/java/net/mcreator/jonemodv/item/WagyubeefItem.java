
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class WagyubeefItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:wagyubeef")
	public static final Item block = null;

	public WagyubeefItem(JoneModVModElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.2f)

							.meat().build()));
			setRegistryName("wagyubeef");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
