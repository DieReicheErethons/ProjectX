package com.dre.projectx.net.packages;

import com.dre.projectx.contents.OwnPlayer;
import com.dre.projectx.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerPositionPackage extends NetPackage{
	public int playerId;
	public float x, y;
	public float rotation;

	@Override
	public void onRecieve(Connection connection) {
		//Check OwnPlayer
		if(OwnPlayer.player.getId() == this.playerId){
			OwnPlayer.player.setX(this.x);
			OwnPlayer.player.setY(this.y);
			OwnPlayer.player.setRotation(this.rotation);
		} else {
			//Check other Players
			Player player = Player.get(this.playerId);
			if(player != null){
				player.setX(this.x);
				player.setY(this.y);
				player.getImage().setRotation(this.rotation);
			}
		}
	}
}
