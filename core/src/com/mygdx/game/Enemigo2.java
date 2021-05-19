package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Enemigo2 extends EnemigoBase{

    Enemigo2() {
        texture = new Texture("nave6.png");
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
}

