package com.dre.projectx.net;

import java.io.IOException;

import com.dre.projectx.contents.OwnPlayer;
import com.dre.projectx.net.packages.PlayerLoginPackage;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Listener.ThreadedListener;

public class NetClient {

	public static Client client;

	public NetClient(){
		client = new Client();
		client.start();

		// Register the classes that will be sent over the network.
		Network.register(client);

		// Add NetListener
		client.addListener(new ThreadedListener(new NetListener()));

		// Connect
		try {
			client.connect(10000, "127.0.0.1", 54555, 54556);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Send Login
		PlayerLoginPackage playerLogin = new PlayerLoginPackage();
		playerLogin.name = OwnPlayer.player.getName();
		playerLogin.sendTCP();
	}
}
