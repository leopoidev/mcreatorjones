package net.mcreator.jonemodv.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.jonemodv.block.Weedstage1Block;
import net.mcreator.jonemodv.JoneModVModElements;
import net.mcreator.jonemodv.JoneModVMod;

import java.util.Map;

@JoneModVModElements.ModElement.Tag
public class WeeeseedRightClickedOnBlockProcedure extends JoneModVModElements.ModElement {
	public WeeeseedRightClickedOnBlockProcedure(JoneModVModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JoneModVMod.LOGGER.warn("Failed to load dependency x for procedure WeeeseedRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JoneModVMod.LOGGER.warn("Failed to load dependency y for procedure WeeeseedRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JoneModVMod.LOGGER.warn("Failed to load dependency z for procedure WeeeseedRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JoneModVMod.LOGGER.warn("Failed to load dependency world for procedure WeeeseedRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.FARMLAND.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Weedstage1Block.block.getDefaultState(), 3);
		}
	}
}
