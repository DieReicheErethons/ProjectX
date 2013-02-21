package com.dre.projectx.net;

import com.dre.projectx.net.packages.NetPackage;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetListener extends Listener{

	@Override
	public void received(Connection connection, Object object){
		if(object instanceof NetPackage){
			NetPackage netPackage = (NetPackage) object;
			netPackage.onRecieve(connection);
		}
	}
}
