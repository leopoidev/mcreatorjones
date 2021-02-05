
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class LongdiamondaxeItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:longdiamondaxe")
	public static final Item block = null;

	public LongdiamondaxeItem(JoneModVModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4.5f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -4f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("longdiamondaxe"));
	}

}
