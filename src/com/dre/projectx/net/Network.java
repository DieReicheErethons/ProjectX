package com.dre.projectx.net;

import java.util.concurrent.CopyOnWriteArrayList;

import com.dre.projectx.net.packages.NetPackage;
import com.dre.projectx.net.packages.PlayerLoginPackage;
import com.dre.projectx.net.packages.PlayerNewPackage;
import com.dre.projectx.net.packages.PlayerPositionPackage;
import com.dre.projectx.net.packages.PlayerVisiblePackage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
	public static CopyOnWriteArrayList<NetPackage> netPackages = new CopyOnWriteArrayList<NetPackage>();

	public static Kryo kryo;

	//Packages
	public static PlayerLoginPackage playerLogin = new PlayerLoginPackage();
	public static PlayerPositionPackage playerPosition = new PlayerPositionPackage();
	public static PlayerVisiblePackage playerVisible = new PlayerVisiblePackage();
	public static PlayerNewPackage playerNew = new PlayerNewPackage();

	public static void register (EndPoint endPoint) {
		kryo = endPoint.getKryo();

		//Initialize packages
		netPackages.add(playerLogin);
		netPackages.add(playerPosition);
		netPackages.add(playerVisible);
		netPackages.add(playerNew);

		//Initialize kryo classes
		kryo.register(playerLogin.getClass());
		kryo.register(playerPosition.getClass());
		kryo.register(playerVisible.getClass());
		kryo.register(playerNew.getClass());

		//TODO: Automatisieren
	}
}
