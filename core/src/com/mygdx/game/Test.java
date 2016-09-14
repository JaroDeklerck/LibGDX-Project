package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.concurrent.TimeUnit;

public class Test extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture dirt;
	Texture stone;
	Texture grass;
	int id;
	int width = 800;
	int height = 480;
	worldGen gen = new worldGen(width,height);
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		dirt = new Texture("dirt.jpg");
		stone = new Texture("stone.jpg");
		grass = new Texture("grass.jpg");
		gen.generate();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i <= (width / 16) - 1; i++) {
			for (int j = 0; j <= (height / 16) - 1; j++) {
				if (gen.blocks != null) {
					id = gen.blocks[j][i];
					switch (id) {
						case 1:
							batch.draw(grass, i * 16, j * 16);
							break;
						case 2:
							batch.draw(dirt, i * 16, j * 16);
							break;
						case 3:
							batch.draw(stone, i * 16, j * 16);
							break;
						default:
							break;
					}
				}
			}
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		dirt.dispose();
		stone.dispose();
		grass.dispose();
	}
}
