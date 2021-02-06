
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class ChikenwingItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:chikenwing")
	public static final Item block = null;

	public ChikenwingItem(JoneModVModElements instance) {
		super(instance, 32);
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
			setRegistryName("chikenwing");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
