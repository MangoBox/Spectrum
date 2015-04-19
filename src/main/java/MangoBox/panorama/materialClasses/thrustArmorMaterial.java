package MangoBox.panorama.materialClasses;

import org.lwjgl.input.Keyboard;

import MangoBox.panorama.init.PanoramaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.ISpecialArmor;

public class thrustArmorMaterial extends ItemArmor implements ISpecialArmor{

	public thrustArmorMaterial(ArmorMaterial material, int renderIndex,
			int armorType) {
		super(material, renderIndex, armorType);
		// TODO Auto-generated constructor stub
	}
	
	boolean Jumped = false;

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if(armor == player.getCurrentArmor(2)){
		}
		
		return new ArmorProperties(0, 0, 0);
	}


	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		if(slot == 2) {
			return 8;
		}
		
		return 4;
	}


	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,
			DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if(slot == 2) {
			return "panorama:models/armor/thrustboots_layer_2.png";
		} else
		return "panorama:models/armor/thrustboots_layer_1.png";
		
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if(armor == player.getCurrentArmor(0)) {
			if(player.onGround == false) {
				if(player.isSneaking() == true && Jumped == false) {
					player.addVelocity(0, 0.42, 0);
					Jumped = true;
					player.playSound("random.explode", 3, 1);
				}
			}	
		}
		if(armor == player.getCurrentArmor(3) && player.isWet() == true) {
			player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1, 1));
		}
		if(player.onGround == true) {
			Jumped = false;
		}
		if(armor == player.getCurrentArmor(1) && player.isSprinting() == true) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 4));
		}
		if(armor == player.getCurrentArmor(2)) {
		}
	}
	

	
}

	