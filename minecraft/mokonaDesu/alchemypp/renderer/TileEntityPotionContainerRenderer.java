package mokonaDesu.alchemypp.renderer;

import mokonaDesu.alchemypp.AlchemyPP;
import mokonaDesu.alchemypp.blocks.BlockRegistry;
import mokonaDesu.alchemypp.model.ModelPotionContainer;
import mokonaDesu.alchemypp.tileentities.TileEntityPotionContainer;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TileEntityPotionContainerRenderer extends TileEntitySpecialRenderer{

	ModelPotionContainer model = new ModelPotionContainer();

    public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d, (float)d1, (float)d2);
         TileEntityPotionContainer tileEntityYour = (TileEntityPotionContainer)tileEntity;
         render(tileEntityYour, tileEntity.worldObj, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, BlockRegistry.appBlockPotionContainer);
         GL11.glPopMatrix();
    }
    

    public void render(TileEntityPotionContainer tl, World world, int i, int j, int k, Block block) {

        float f = block.getBlockBrightness(world, i, j, k);
        int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2);
       
        int dir = world.getBlockMetadata(i, j, k);
       
         GL11.glPushMatrix();
         GL11.glTranslatef(0.5F, 0, 0.5F);
         GL11.glRotatef(dir * (-90F), 0F, 1F, 0F);
         GL11.glTranslatef(-0.5F, 0, -0.5F);
     
        if (AlchemyPP.alternativeTextures) bindTexture(new ResourceLocation("AlchemyPP:textures/blocks/BottleAlt.png"));
        else bindTexture(new ResourceLocation("AlchemyPP:textures/blocks/Bottle.png"));
        	
         float percentage = ((float)tl.containerHas)/tl.containerMax;
         int color = 0;
         if (percentage > 0) color = PotionHelper.func_77915_a(tl.potionID, false);
         
         this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, percentage, color);
         
         GL11.glPopMatrix();
     }
}