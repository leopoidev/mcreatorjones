
package net.mcreator.jonemodv.item;

@JoneModVModElements.ModElement.Tag
public class JonesSwordItem extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:jones_sword")
	public static final Item block = null;

	public JonesSwordItem(JoneModVModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 600;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 6;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.GOLDEN_HOE, (int) (1)));
			}
		}, 3, 0f, new Item.Properties().group(ItemGroup.TOOLS)) {

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("S W E E T S O D A"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("jones_sword"));
	}

}
