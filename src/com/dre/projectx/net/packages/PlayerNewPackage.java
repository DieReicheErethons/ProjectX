package com.dre.projectx.net.packages;

import java.util.logging.Level;

import com.dre.projectx.Main;
import com.dre.projectx.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerNewPackage extends NetPackage{
	public String name;
	public int id;

	@Override
	public void onRecieve(Connection connection, Object object) {
		if(object instanceof PlayerNewPackage){
			Main.m.logger.log(Level.WARNING, "TESTST");
			PlayerNewPackage newPackage = (PlayerNewPackage) object;

			Player player = Player.get(newPackage.name);
			if(player == null){
				player = new Player (newPackage.name);
				player.setId(newPackage.id);
			}
		}
	}
}
