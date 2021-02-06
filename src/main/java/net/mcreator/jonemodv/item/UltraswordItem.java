
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class UltraswordItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:ultrasword")
	public static final Item block = null;

	public UltraswordItem(JoneModVModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 7;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.GOLDEN_APPLE, (int) (1)));
			}
		}, 3, 0f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("The best sword in the game. That's it"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("ultrasword"));
	}

}
