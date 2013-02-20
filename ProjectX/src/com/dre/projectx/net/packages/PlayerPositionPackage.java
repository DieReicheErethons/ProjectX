package com.dre.projectx.net.packages;

import com.esotericsoftware.kryonet.Connection;

public class PlayerPositionPackage extends NetPackage{
	public int playerId;
	public int x, y;

	@Override
	public void onRecieve(Connection connection, Object object) {
		// TODO Auto-generated method stub

	}
}
