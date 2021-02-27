
package net.mcreator.jonemodv.itemgroup;

@JoneModVModElements.ModElement.Tag
public class JonesItemGroup extends JoneModVModElements.ModElement {

	public JonesItemGroup(JoneModVModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabjones") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(JonesingotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}
