package com.mygdx.tg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import com.mygdx.screens.MenuScreen;

public class TG extends Game {
	public Stage stage;
	
	public class MyActor extends Actor {
        Texture texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        float actorX = 100, actorY = 200;
        public boolean started = false;
        TG gameRef;

        public MyActor(TG agame){
        	gameRef = agame;
            setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
            addListener(new InputListener(){
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                	System.out.print("here!");
                	Stage tempStage = gameRef.stage;
                    gameRef.stage = new MenuScreen();
                    tempStage.dispose();
                    return true;
                }
            });
        }
        
        
        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(texture,actorX,actorY);
        }
        
        @Override
        public void act(float delta){
            if(started){
                //actorX+=5;
            }
        }
    }
	
	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		MyActor myActor = new MyActor(this);
        myActor.setTouchable(Touchable.enabled);
        stage.addActor(myActor);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}
	
	@Override
	public void dispose () {
	}
}
