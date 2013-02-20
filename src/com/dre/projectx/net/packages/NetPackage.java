package com.dre.projectx.net.packages;

import com.dre.projectx.net.NetClient;
import com.esotericsoftware.kryonet.Connection;

public abstract class NetPackage {

	//Abstracts
	public abstract void onRecieve(Connection connection);

	public void sendUDP(){
		NetClient.client.sendUDP(this);
	}

	public void sendTCP(){
		NetClient.client.sendTCP(this);
	}
}
