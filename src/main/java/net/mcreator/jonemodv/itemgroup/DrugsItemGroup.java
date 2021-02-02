
package net.mcreator.jonemodv.itemgroup;

@JoneModVModElements.ModElement.Tag
public class DrugsItemGroup extends JoneModVModElements.ModElement {

	public DrugsItemGroup(JoneModVModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdrugs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OpioidsItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}
