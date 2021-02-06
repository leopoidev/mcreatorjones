
package net.mcreator.jonemodv.block;

import net.minecraft.block.material.Material;

@JoneModVModElements.ModElement.Tag
public class GasolineBlock extends JoneModVModElements.ModElement {

	@ObjectHolder("jone_mod_v:gasoline")
	public static final FlowingFluidBlock block = null;

	@ObjectHolder("jone_mod_v:gasoline_bucket")
	public static final Item bucket = null;

	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;

	private ForgeFlowingFluid.Properties fluidproperties = null;

	public GasolineBlock(JoneModVModElements instance) {
		super(instance, 41);

		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
	}

	private static class FluidRegisterHandler {

		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}

	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("jone_mod_v:blocks/gasol"), new ResourceLocation("jone_mod_v:blocks/gasol"))
						.luminosity(0).density(1000).viscosity(1090)).bucket(() -> bucket).block(() -> block);

		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("gasoline");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("gasoline_flowing");

		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {

		}.setRegistryName("gasoline"));

		elements.items.add(() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC))
				.setRegistryName("gasoline_bucket"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("jone_mod_v:extremetropicalbiome").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS)
				.add(() -> new LakesFeature(BlockStateFeatureConfig.field_236455_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;

						if (dimensionType == World.OVERWORLD)
							dimensionCriteria = true;

						if (!dimensionCriteria)
							return false;

						return super.generate(world, generator, rand, pos, config);
					}
				}.withConfiguration(new BlockStateFeatureConfig(block.getDefaultState()))
						.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(5))));
	}

}
