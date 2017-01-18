package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.tg.TG;

public class LobbyScreen extends Stage {
	public class MyActor extends Actor {
        Texture texture = new Texture("badlogic.jpg");
        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(texture,100,0);
        }
    }
	
	float timer = 0;
	float countdownToMinigame = 3;
	TG mainGameController;
	
	public LobbyScreen(TG mainGameController) {
		this.addActor(new MyActor());
		this.mainGameController = mainGameController;
	}
	
	@Override
	public void act(float offset) {
		super.act(offset);
		//There should be an intro here
		if (checkShouldRunMiniGame()) {
			mainGameController.StartMiniGame("testGame");
		}
	}
	
	boolean checkShouldRunMiniGame() {
		timer += Gdx.graphics.getDeltaTime();
		if(timer > countdownToMinigame) {
			System.out.println("Changing Level");
			timer = 0;
			return true;
		}
		return false;
	}
	
}
