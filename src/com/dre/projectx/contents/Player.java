package com.dre.projectx.contents;

import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	public static Set<Player> players = new HashSet<Player>();

	private int id;
	private String name;
	private Image image;
	private float x = 300, y = 300;

	public Player(String name){
		players.add(this);

		this.name = name;

		try {
			this.image = new Image("data/images/player.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	//Static methods
	public static void update(GameContainer gc, int delta){

	}

	public static void render(Graphics g){
		for(Player player : players){
			//if(OwnPlayer.player.visiblePlayers.contains(player)){
				player.image.draw(player.x, player.y);
				g.drawString(player.name, player.x, player.y-20);
			//}
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

	public void setX(float x){
		this.x = x;
	}

	public void setY(float y){
		this.y = y;
	}

	public Image getImage() {
		return this.image;
	}
}
