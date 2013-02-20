package com.dre.projectx.net.packages;

import com.dre.projectx.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerLoginPackage extends NetPackage{
	public String name;
	public int id;

	@Override
	public void onRecieve(Connection connection, Object object) {
		if(object instanceof PlayerLoginPackage){
			PlayerLoginPackage loginPackage = (PlayerLoginPackage) object;

			Player player = Player.get(loginPackage.name);
			if(player!=null){
				player.setId(loginPackage.id);
			} else {
				player = new Player (loginPackage.name);
				player.setId(loginPackage.id);
			}
		}
	}
}
