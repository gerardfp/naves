package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    Animacion animacion = new Animacion(16,
            new Texture("nave1.png"),
            new Texture("nave2.png"),
            new Texture("nave3.png")
    );
    Animacion animacion2 = new Animacion(16,
            new Texture("nave4.png"),
            new Texture("nave5.png"),
            new Texture("nave6.png")
    );
    Animacion animacion3 = new Animacion(16,
            new Texture("explosion.png")
    );

    float x, y, w, h, v;
    List<Disparo> disparos = new ArrayList<>();
    int vidas = 3;
    int puntos = 0;
    boolean muerto = false;
    Temporizador temporizadorFireRate = new Temporizador(20);
    Temporizador temporizadorRespawn = new Temporizador(120, false);

    Jugador() {
        x = 100;
        y = 100;
        w = 40 * 2;
        h = 40 * 2;
        v = 5;
    }

    void update() {
        for (Disparo disparo : disparos) disparo.update();

        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += v;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= v;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y += v;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= v;

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && temporizadorFireRate.suena() && !muerto) {
            disparos.add(new Disparo(x + w / 2, y + h));
        }

        if (x < 0) x = 0;

        if (temporizadorRespawn.suena()) {
            muerto = false;
        }
        if (x < 0) x=0;
        if (y < 0) y=0;
        if (x > 640 - w) x = 640 - w;
        if (y > 480 - h) y = 480 - h;
    }

    void render(SpriteBatch batch) {
        if (vidas == 0) {
            batch.draw(animacion3.obtenerFrame(), x, y, w, h);
        } else if (muerto){
            batch.draw(animacion2.obtenerFrame(), x, y, w, h);
        }
        else {
            batch.draw(animacion.obtenerFrame(), x, y, w, h);
        }
        for (Disparo disparo : disparos) disparo.render(batch);
    }

    public void morir() {
        vidas--;
        muerto = true;
        temporizadorRespawn.activar();
    }
}
