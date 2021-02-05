
package net.mcreator.jonemodv.block;

import net.minecraft.block.material.Material;

@JoneModVModElements.ModElement.Tag
public class TropicalvineBlock extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:tropicalvine")
	public static final Block block = null;

	public TropicalvineBlock(JoneModVModElements instance) {
		super(instance, 37);

		FMLJavaModLoadingContext.get().getModEventBus().register(new BlockColorRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(DrugsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
	}

	private static class BlockColorRegisterHandler {
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public void blockColorLoad(ColorHandlerEvent.Block event) {
			event.getBlockColors().register((bs, world, pos, index) -> {
				return world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault();
			}, block);
		}
	}

	public static class CustomBlock extends PaneBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.LEAVES).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("tropicalvine");
		}

		@Override
		public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
			return true;
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
