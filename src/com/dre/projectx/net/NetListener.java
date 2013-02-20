package com.dre.projectx.net;

import com.dre.projectx.net.packages.NetPackage;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetListener extends Listener{
	@Override
	public void disconnected(Connection connection){

	}

	@Override
	public void received(Connection connection, Object object){
		for(NetPackage netPackage : Network.netPackages){
			if(object.getClass() == netPackage.getClass()){
				netPackage.onRecieve(connection, object);
			}
		}
	}
}
