
package net.mcreator.jonemodv.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.jonemodv.JoneModVModElements;

@JoneModVModElements.ModElement.Tag
public class BaneofahahahaEnchantment extends JoneModVModElements.ModElement {
	@ObjectHolder("jone_mod_v:baneofahahaha")
	public static final Enchantment enchantment = null;
	public BaneofahahahaEnchantment(JoneModVModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("baneofahahaha"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 2;
		}

		@Override
		public int getMaxLevel() {
			return 7;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
