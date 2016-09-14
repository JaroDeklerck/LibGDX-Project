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
		Gdx.gl.glClearColor(0, 0, 255, 50);
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
	/*
	public void spawnBlocks() {
		Rectangle dirtBlock = new Rectangle();
		Rectangle stoneBlock = new Rectangle();
		Rectangle grassBlock = new Rectangle();
		dirtBlock.width = 16;
		dirtBlock.height = 16;
		stoneBlock.width = 16;
		stoneBlock.height = 16;
		grassBlock.width = 16;
		grassBlock.height = 16;
		startHeight = 240;
		up = false;
		down = false;
		for (int i=0; i<=800; i=i+16) {
			dirtBlock.x = i;
			stoneBlock.x = i;
			grassBlock.x = i;
			number = MathUtils.random(0,2);
			if (number == 0 && !up) {
				startHeight = startHeight - 16;
				grassBlock.y = startHeight;
				grassBlocks.add(grassBlock);
				batch.draw(grass, grassBlock.x, grassBlock.y);
				for (int j = startHeight - 16; j >= startHeight - 48; j = j - 16) {
					dirtBlock.y = j;
					dirtBlocks.add(dirtBlock);
					batch.draw(dirt, dirtBlock.x, dirtBlock.y);
				}
				for (int k = startHeight - 64; k >= 0; k = k - 16) {
					stoneBlock.y = k;
					stoneBlocks.add(stoneBlock);
					batch.draw(stone, stoneBlock.x, stoneBlock.y);
				}
				down = true;
				up = false;
			}
			else if (number == 2 && !down) {
				startHeight = startHeight + 16;
				grassBlock.y = startHeight;
				grassBlocks.add(grassBlock);
				batch.draw(grass, grassBlock.x, grassBlock.y);
				for (int j = startHeight - 16; j >= startHeight - 48; j = j - 16) {
					dirtBlock.y = j;
					dirtBlocks.add(dirtBlock);
					batch.draw(dirt, dirtBlock.x, dirtBlock.y);
				}
				for (int k = startHeight - 64; k >= 0; k = k - 16) {
					stoneBlock.y = k;
					stoneBlocks.add(stoneBlock);
					batch.draw(stone, stoneBlock.x, stoneBlock.y);
				}
				up = true;
				down = false;
			}
			else if (number == 1 || number == 0 && up || number == 2 && down) {
				grassBlock.y = startHeight;
				grassBlocks.add(grassBlock);
				batch.draw(grass, grassBlock.x, grassBlock.y);
				for (int j = startHeight-16; j >= startHeight-48; j = j-16) {
					dirtBlock.y = j;
					dirtBlocks.add(dirtBlock);
					batch.draw(dirt, dirtBlock.x, dirtBlock.y);
				}
				for (int k = startHeight-64; k >= 0; k = k-16) {
					stoneBlock.y = k;
					stoneBlocks.add(stoneBlock);
					batch.draw(stone, stoneBlock.x, stoneBlock.y);
				}
				up = false;
				down = false;
			}
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
}
