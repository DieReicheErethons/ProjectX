package com.dre.projectx.net.packages;

import com.esotericsoftware.kryonet.Connection;

public class PlayerVisiblePackage extends NetPackage{
	public int playerId;
	public boolean visible;

	@Override
	public void onRecieve(Connection connection) {
		// TODO Auto-generated method stub

	}
}
