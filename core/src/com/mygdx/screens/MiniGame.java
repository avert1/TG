package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.tg.TG;

public abstract class MiniGame extends Stage {

	float timeLimit;
	boolean usingTimeLimit;
	TG mainGameController;
	 
	public MiniGame(TG mainGame, float timeLimit) {
		// TODO Auto-generated constructor stub
		this.timeLimit = timeLimit;
		this.mainGameController = mainGame;
		usingTimeLimit = true;
	}
	
	public MiniGame(TG mainGame) {
		// TODO Auto-generated constructor stub
		usingTimeLimit = false;
	}
	
	@Override
	public void act(float offset) {
		super.act(offset);
		if (CheckShouldFail()) {
			returnResult(false);
		}
		
	}
	
	public abstract void run();
	public void returnResult(boolean didPass) {
		mainGameController.ReturnToLobby(didPass);
	}
	
	public boolean CheckShouldFail() {
		if(usingTimeLimit) {
			if(timeLimit < 0) {
				System.out.println("Time up!");
				return true;
			}
			timeLimit -= Gdx.graphics.getDeltaTime();
		}
		return false;
	}

}
