
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class LongironaxedeodorantItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:longironaxedeodorant")
	public static final Item block = null;

	public LongironaxedeodorantItem(JoneModVModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.7f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("longironaxedeodorant"));
	}

}
