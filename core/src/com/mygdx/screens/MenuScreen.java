package com.mygdx.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MenuScreen extends Stage {
	public class MyActor extends Actor {
        Texture texture = new Texture("badlogic.jpg");
        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(texture,100,0);
        }
    }
	
	public MenuScreen() {
		this.addActor(new MyActor());
	}
	
}
