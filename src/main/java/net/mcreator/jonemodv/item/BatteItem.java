
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class BatteItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:batte")
	public static final Item block = null;

	public BatteItem(JoneModVModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 2.3999999999999995f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.WOODEN_AXE, (int) (1)));
			}
		}, 3, -2f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {

			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				ItemStack retval = new ItemStack(this);
				retval.setDamage(itemstack.getDamage() + 1);
				if (retval.getDamage() >= retval.getMaxDamage()) {
					return ItemStack.EMPTY;
				}
				return retval;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("cheap and \u00E9fficase"));
			}

		}.setRegistryName("batte"));
	}

}
