package com.dre.projectx;

import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.dre.projectx.contents.Player;
import com.dre.projectx.net.NetClient;

public class Main extends BasicGame{
	public static Main m;


	//Network
	public NetClient netClient;

	//Logger
	public Logger logger = Logger.getLogger("projectx");

	public Main(){
		super("ProjectX");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		//Create main player
		Player.me = new Player("Ich"+(int) Math.floor((Math.random() * 400) + 1));
		Player.me.visiblePlayers.add(Player.me);

		//Network
		this.netClient = new NetClient();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Player.update();
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		Player.render(g);
	}

	public static void main(String[] args) throws SlickException {
		m = new Main();

		AppGameContainer app = new AppGameContainer(m);

		app.setDisplayMode(800, 600, false);
		app.start();
	}
}
