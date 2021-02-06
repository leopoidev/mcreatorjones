
package net.mcreator.jonemodv.block;

import net.minecraft.block.material.Material;

@JoneModVModElements.ModElement.Tag
public class TropicleafBlock extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:tropicleaf")
	public static final Block block = null;

	public TropicleafBlock(JoneModVModElements instance) {
		super(instance, 39);

		FMLJavaModLoadingContext.get().getModEventBus().register(new BlockColorRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new ItemColorRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(DrugsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
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

	private static class ItemColorRegisterHandler {
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public void itemColorLoad(ColorHandlerEvent.Item event) {
			event.getItemColors().register((stack, index) -> {
				return FoliageColors.getDefault();
			}, block);
		}
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.LEAVES).sound(SoundType.VINE).hardnessAndResistance(0.4f, 10f).setLightLevel(s -> 0)
							.slipperiness(0.2f).notSolid().setOpaque((bs, br, bp) -> false));

			setRegistryName("tropicleaf");
		}

		@OnlyIn(Dist.CLIENT)
		public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			super.animateTick(state, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (true)
				for (int l = 0; l < 5; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.7000000014901161D;
					double d4 = (random.nextFloat() - 0.5D) * 0.7000000014901161D;
					double d5 = (random.nextFloat() - 0.5D) * 0.7000000014901161D;
					world.addParticle(LeafyeParticle.particle, d0, d1, d2, d3, d4, d5);
				}
		}

	}

}
