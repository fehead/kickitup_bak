package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	Texture terrain;
	TextureRegion groundTextureRegion;
	float backgroundPos = 0;
	CharacterProcessor inputProcessor;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("sky2.jpg");
		terrain = new Texture("grey_stone_1.png");
		terrain.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
		groundTextureRegion = new TextureRegion(terrain);
		inputProcessor = new CharacterProcessor();
		Gdx.input.setInputProcessor(inputProcessor);
		
		// img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		batch.begin();
		// batch.draw(img, 0, 0);
		batch.disableBlending();
		batch.draw(background, 0, 0, 800, 400);
		batch.enableBlending();
		// draw ground image
		batch.draw(groundTextureRegion, backgroundPos, 0, 800, 100);
		if(backgroundPos + 800 > 0 && backgroundPos + 800 < 800) 
			batch.draw(groundTextureRegion, backgroundPos + 800, 0, 800, 100);
		// draw player
		inputProcessor.getPlayer().getCharacterSprite().draw(batch);
		batch.end();
		updateScene();
	}
	
	private void updateScene() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		backgroundPos -= 200 * deltaTime;
		if(backgroundPos <= -800)
			backgroundPos = 0;
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
