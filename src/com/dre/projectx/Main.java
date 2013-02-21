package com.dre.projectx;

import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.dre.projectx.contents.OwnPlayer;
import com.dre.projectx.contents.Player;
import com.dre.projectx.net.NetClient;

public class Main extends BasicGame{
	public static Main m;

	//User
	public String userName;
	public String userSessionId;

	//Slick2D
	public AppGameContainer app;

	//Network
	public NetClient netClient;

	//Logger
	public Logger logger = Logger.getLogger("projectx");

	public Main(){
		super("ProjectX");
	}

	public static void main(String[] args) throws SlickException {
		m = new Main();

		//Read args
		boolean result = m.readArgs(args);

		if(result){
			//Start
			m.app = new AppGameContainer(m);

			m.app.setDisplayMode(800, 600, false);
			m.app.start();
		}
	}

	//Slick2D methods
	@Override
	public void init(GameContainer gc) throws SlickException {
		//Create own player
		OwnPlayer.player = new OwnPlayer(this.userName);

		//Network
		this.netClient = new NetClient();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Player.update(gc, delta);
		OwnPlayer.update(gc, delta);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		Player.render(gc,g);
		OwnPlayer.render(gc,g);
	}

	//Other Methods
	public boolean readArgs(String[] args){
		String name = null;
		String sessionId = null;

		for(String arg : args){
			if(arg.startsWith("-name:")){
				name = arg.substring(6);
			} else if(arg.startsWith("-sessionid:")) {
				sessionId = arg.substring(11);
			}
		}

		if(name == null){
			JOptionPane.showMessageDialog(null, "'Name' parameter not found!");
			this.app.destroy();
			return false;
		}

		if(sessionId == null){
			JOptionPane.showMessageDialog(null, "'sessionId' parameter not found! ProjectX is in offline mode!");
		}

		this.userName = name;
		this.userSessionId = sessionId;

		return true;
	}
}
