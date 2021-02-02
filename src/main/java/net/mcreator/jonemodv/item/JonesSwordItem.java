
package net.mcreator.jonemodv.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.jonemodv.JoneModVModElements;

import java.util.List;

@JoneModVModElements.ModElement.Tag
public class JonesSwordItem extends JoneModVModElements.ModElement {
	@ObjectHolder("jone_mod_v:jones_sword")
	public static final Item block = null;
	public JonesSwordItem(JoneModVModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 600;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 6;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.GOLDEN_HOE, (int) (1)));
			}
		}, 3, 0f, new Item.Properties().group(ItemGroup.TOOLS)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("S W E E T S O D A"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("jones_sword"));
	}
}
