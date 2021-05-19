package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class EnemigoBase {
    Texture texture;
    float x, y, w, h, vx, vy;

    public abstract void update();

    void render(SpriteBatch batch) {
        batch.draw(texture, x, y, w, h);
    }
}

