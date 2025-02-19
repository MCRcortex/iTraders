package kaptainwutax.itraders.entity;

import com.mojang.authlib.GameProfile;

import kaptainwutax.itraders.net.FakeServerHandler;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;

public class FakeUser extends FakePlayer {

	public FakeUser(WorldServer world, GameProfile name) {
		super(world, name);
		this.connection = new FakeServerHandler(this);
	}
	
	@Override
	public void resetCooldown() {
		this.ticksSinceLastSwing = 20000;
	}

}
