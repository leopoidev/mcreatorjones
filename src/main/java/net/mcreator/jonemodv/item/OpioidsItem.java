
package net.mcreator.jonemodv.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.jonemodv.procedures.OpioidsFoodEatenProcedure;
import net.mcreator.jonemodv.itemgroup.DrugsItemGroup;
import net.mcreator.jonemodv.JoneModVModElements;

import java.util.Map;
import java.util.HashMap;

@JoneModVModElements.ModElement.Tag
public class OpioidsItem extends JoneModVModElements.ModElement {
	@ObjectHolder("jone_mod_v:opioids")
	public static final Item block = null;
	public OpioidsItem(JoneModVModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(DrugsItemGroup.tab).maxStackSize(8).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(-1).saturation(-0.3f).build()));
			setRegistryName("opioids");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 77;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				OpioidsFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
