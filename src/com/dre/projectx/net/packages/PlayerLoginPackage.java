package com.dre.projectx.net.packages;

import com.dre.projectx.contents.OwnPlayer;
import com.dre.projectx.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerLoginPackage extends NetPackage{
	public String name;
	public int id;

	@Override
	public void onRecieve(Connection connection) {
		if(OwnPlayer.player.getName().equals(this.name)){
			OwnPlayer.player.setId(this.id);
		} else {
			Player player = Player.get(this.name);

			if(player==null){
				player = new Player (this.name);
				player.setId(this.id);
			}
		}
	}
}
