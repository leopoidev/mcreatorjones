
package net.mcreator.jonemodv.block;

import net.minecraft.block.material.Material;

@JoneModVModElements.ModElement.Tag
public class NiggerBlock extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:nigger")
	public static final Block block = null;

	public NiggerBlock(JoneModVModElements instance) {
		super(instance, 46);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("nigger");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
