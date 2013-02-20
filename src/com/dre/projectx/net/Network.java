package com.dre.projectx.net;

import java.util.concurrent.CopyOnWriteArrayList;

import com.dre.projectx.net.packages.PlayerLoginPackage;
import com.dre.projectx.net.packages.PlayerNewPackage;
import com.dre.projectx.net.packages.PlayerPositionPackage;
import com.dre.projectx.net.packages.PlayerVisiblePackage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
	public static CopyOnWriteArrayList<Class<?>> netPackages = new CopyOnWriteArrayList<Class<?>>();

	public static Kryo kryo;

	public static void register (EndPoint endPoint) {
		kryo = endPoint.getKryo();

		//Initialize packages
		netPackages.add(PlayerLoginPackage.class);
		netPackages.add(PlayerPositionPackage.class);
		netPackages.add(PlayerVisiblePackage.class);
		netPackages.add(PlayerNewPackage.class);

		//Initialize kryo classes
		kryo.register(PlayerLoginPackage.class);
		kryo.register(PlayerPositionPackage.class);
		kryo.register(PlayerVisiblePackage.class);
		kryo.register(PlayerNewPackage.class);

		//TODO: Automatisieren
	}
}
