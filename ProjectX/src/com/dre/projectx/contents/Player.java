package com.dre.projectx.contents;

import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	public static Set<Player> players = new HashSet<Player>();
	public static Player me;

	private int id;
	private String name;
	private Image image;
	private int x = 300, y = 300;

	//Only me variables
	public Set<Player> visiblePlayers = new HashSet<Player>();

	public Player(String name){
		players.add(this);

		this.name = name;

		try {
			this.image = new Image("data/images/player.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}

		x = (int) Math.floor((Math.random() * 400) + 1);

		if(me!=null){
			me.visiblePlayers.add(this);
		}
	}

	//Static methods
	public static void update(){

	}

	public static void render(Graphics g){
		for(Player player : players){
			if(me.visiblePlayers.contains(player)){
				player.image.draw(player.x, player.y);
				g.drawString(player.name, player.x, player.y-20);
			}
		}
	}

	public static Player get(String name){
		for(Player player : players){
			if(player.name.equals(name)){
				return player;
			}
		}

		return null;
	}

	public static Player get(int id){
		for(Player player : players){
			if(player.id == id){
				return player;
			}
		}

		return null;
	}

	//Getter and Setter
	public void setId(int id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
}
