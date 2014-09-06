package alchemyplusplus.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTemplate extends Item
{

    String iconName;
    int lifespan = 6000;

    public ItemTemplate(String iconName)
    {
        super();
        this.iconName = iconName;
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, World world)
    {
        return this.lifespan;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(iconName);
    }

    public void setLifespan(int lifespan)
    {
        this.lifespan = lifespan;
    }

}
