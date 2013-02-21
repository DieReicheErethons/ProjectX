package com.dre.projectx.net.packages;

import com.dre.projectx.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerDisconnectPackage extends NetPackage{
	public int playerId;

	@Override
	public void onRecieve(Connection connection) {
		Player player = Player.get(this.playerId);

		if(player != null){
			player.remove();
		}
	}
}
