package com.dre.projectx.net;

import com.dre.projectx.net.packages.PlayerDisconnectPackage;
import com.dre.projectx.net.packages.PlayerLoginPackage;
import com.dre.projectx.net.packages.PlayerNewPackage;
import com.dre.projectx.net.packages.PlayerPositionPackage;
import com.dre.projectx.net.packages.PlayerVisiblePackage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {

	public static Kryo kryo;

	public static void register (EndPoint endPoint) {
		kryo = endPoint.getKryo();

		//Initialize kryo classes
		kryo.register(PlayerLoginPackage.class);
		kryo.register(PlayerPositionPackage.class);
		kryo.register(PlayerVisiblePackage.class);
		kryo.register(PlayerNewPackage.class);
		kryo.register(PlayerDisconnectPackage.class);

		//TODO: Automatisieren
	}
}
