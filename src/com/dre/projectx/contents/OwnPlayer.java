package com.dre.projectx.contents;

import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.dre.projectx.net.packages.PlayerPositionPackage;

public class OwnPlayer{
	public static OwnPlayer player;

	private int id;
	private String name;
	private Image image;
	private float x = 300, y = 300;
	private float rotation;

	public Set<Player> visiblePlayers = new HashSet<Player>();

	public OwnPlayer(String name){
		player = this;

		this.name = name;

		try {
			this.image = new Image("data/images/player.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	//Static methods
	public static void update(GameContainer gc, int delta){
		Input input = gc.getInput();

		//Controls
		boolean positionUpdated = false;

        if(input.isKeyDown(Input.KEY_A)){
        	player.rotation = player.rotation - 0.2f * delta;
        	positionUpdated = true;
        }

        if(input.isKeyDown(Input.KEY_D)){
        	player.rotation = player.rotation + 0.2f * delta;
        	positionUpdated = true;
        }

        if(input.isKeyDown(Input.KEY_W)){
            float hip = 0.4f * delta;

            player.x+= hip * Math.sin(Math.toRadians(player.rotation));
            player.y-= hip * Math.cos(Math.toRadians(player.rotation));
            positionUpdated = true;
        }

        if(positionUpdated){
        	player.image.setRotation(player.rotation);

        	//Send Update
        	PlayerPositionPackage positionPackage = new PlayerPositionPackage();
        	positionPackage.x = player.x;
        	positionPackage.y = player.y;
        	positionPackage.rotation = player.rotation;
        	positionPackage.playerId = player.id;
        	positionPackage.sendUDP();
        }
	}

	public static void render(Graphics g){
		player.image.draw(player.x, player.y);
		g.drawString(player.name, player.x, player.y-20);
	}

	//Getter and Setter
	public int getId(){
		return this.id;
	}

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

	public void setRotation(float angle) {
		this.image.setRotation(angle);
		this.rotation = angle;
	}
}
