package kaptainwutax.itraders.item;

import kaptainwutax.itraders.Traders;
import kaptainwutax.itraders.gui.GuiHandler;
import kaptainwutax.itraders.init.InitItem;
import kaptainwutax.itraders.world.data.DataEggPouch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemEggPouch extends Item {

    public ItemEggPouch(String name) {
        this.setTranslationKey(name);
        this.setRegistryName(Traders.getResource(name));
        this.setCreativeTab(InitItem.ITRADERS_TAB);
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!player.isSneaking()) player.openGui(Traders.getInstance(), GuiHandler.POUCH, world, 0, 0, 0);
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (player.isSneaking() && !world.isRemote) {
            ItemStack itemStack = DataEggPouch.get(world).getOrCreatePouch(player).randomEgg();
            
            if(itemStack != null && (itemStack.getItem() instanceof ItemSpawnEggFighter)) {
                ItemSpawnEggFighter eggItem = (ItemSpawnEggFighter)itemStack.getItem();
                eggItem.onItemUse(itemStack, player, world, pos, hand, facing, hitX, hitY, hitZ);
            }
        }

        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

}