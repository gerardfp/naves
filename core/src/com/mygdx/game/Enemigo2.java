package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemigo2 extends EnemigoBase{
    Texture texture = new Texture("nimbus_0.png");
    float x, y, w, h, vx, vy;

    Enemigo2() {
        x = 640;
        y = Utils.random.nextInt(480);
        w = 64 * 2;
        h = 48 * 2;
        vx = -10;
    }

    public void update() {
        x += vx;

        if (y < 0) y=0;
        if (y > 480 - h) y = 480 - h;
    }

    void render(SpriteBatch batch) {
        batch.draw(texture, x, y, w, h);
    }
}

