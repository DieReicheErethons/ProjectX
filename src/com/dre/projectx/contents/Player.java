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

	public static void render(GameContainer gc, Graphics g){
		for(Player player : players){
			float drawX = gc.getWidth() / 2 - OwnPlayer.player.getX() + player.x - player.image.getWidth() / 2;
			float drawY = gc.getHeight() / 2 - OwnPlayer.player.getY() + player.y - player.image.getHeight() / 2;

			player.image.draw(drawX, drawY);
			g.drawString(player.name, drawX, drawY-20);
			g.drawString("Id:"+player.id, drawX, drawY-40);
		}
	}

	public void remove() {
		players.remove(this);
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
