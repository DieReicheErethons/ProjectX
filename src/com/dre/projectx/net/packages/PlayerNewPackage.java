package com.dre.projectx.net.packages;

import com.dre.projectx.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerNewPackage extends NetPackage{
	public String name;
	public int id;

	@Override
	public void onRecieve(Connection connection) {
		Player player = Player.get(this.name);
		if(player == null){
			player = new Player (this.name);
			player.setId(this.id);
		}
	}
}
