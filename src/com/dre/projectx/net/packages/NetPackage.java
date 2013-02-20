package com.dre.projectx.net.packages;

import com.esotericsoftware.kryonet.Connection;

public abstract class NetPackage {

	//Abstracts
	public abstract void onRecieve(Connection connection, Object object);
}
