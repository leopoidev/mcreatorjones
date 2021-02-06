package net.mcreator.jonemodv.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.jonemodv.JoneModVModElements;
import net.mcreator.jonemodv.JoneModVMod;

import java.util.Map;

@JoneModVModElements.ModElement.Tag
public class OpioidsFoodEatenProcedure extends JoneModVModElements.ModElement {
	public OpioidsFoodEatenProcedure(JoneModVModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JoneModVMod.LOGGER.warn("Failed to load dependency entity for procedure OpioidsFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 1, (false), (false)));
	}
}
