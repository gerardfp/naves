package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Enemigo extends EnemigoBase{
    Temporizador cambioVelocidad = new Temporizador(60);
    // las variables texture, x, y, w, ... las hereda de EnemigoBase

    Enemigo() {
        texture = new Texture("nimbus_0.png");
        x = 640;
        y = Utils.random.nextInt(480);
        w = 64 * 2;
        h = 48 * 2;
        vx = -2;
        vy = 0;
    }

    public void update() {
        y += vy;
        x += vx;

        if (cambioVelocidad.suena()) {
            vy = Utils.random.nextInt(6) - 3;
            vx = -(Utils.random.nextInt(3)+1);
        }
        //if (x < 0) x=0;
        if (y < 0) y=0;
        //if (x > 640 - w) x = 640 - w;
        if (y > 480 - h) y = 480 - h;
    }

    // el metodo render() lo hereda de EnemigoBase
}

