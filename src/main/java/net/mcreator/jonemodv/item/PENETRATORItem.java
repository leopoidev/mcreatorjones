
package net.mcreator.jonemodv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.Blocks;

import net.mcreator.jonemodv.JoneModVModElements;

import java.util.List;

@JoneModVModElements.ModElement.Tag
public class PENETRATORItem extends JoneModVModElements.ModElement {
	@ObjectHolder("jone_mod_v:penetrator")
	public static final Item block = null;
	public PENETRATORItem(JoneModVModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 101;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 3.1f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.PINK_CONCRETE, (int) (1)));
			}
		}, 3, -0.5f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("C'est enemie tremble de peur quand elle les p\u00E9nettre"));
			}
		}.setRegistryName("penetrator"));
	}
}
