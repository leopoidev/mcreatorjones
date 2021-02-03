package net.mcreator.jonemodv.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;

import net.mcreator.jonemodv.JoneModVModElements;
import net.mcreator.jonemodv.JoneModVMod;

import java.util.Map;

@JoneModVModElements.ModElement.Tag
public class NonaquirableforarrowonlybombBulletHitsLivingEntityProcedure extends JoneModVModElements.ModElement {
	public NonaquirableforarrowonlybombBulletHitsLivingEntityProcedure(JoneModVModElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JoneModVMod.LOGGER.warn("Failed to load dependency x for procedure NonaquirableforarrowonlybombBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JoneModVMod.LOGGER.warn("Failed to load dependency y for procedure NonaquirableforarrowonlybombBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JoneModVMod.LOGGER.warn("Failed to load dependency z for procedure NonaquirableforarrowonlybombBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JoneModVMod.LOGGER.warn("Failed to load dependency world for procedure NonaquirableforarrowonlybombBulletHitsLivingEntity!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
		}
	}
}
