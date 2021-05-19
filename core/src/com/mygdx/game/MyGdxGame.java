package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    BitmapFont font;
    Fondo fondo;
    Jugador jugador;
    List<EnemigoBase> enemigos;
    List<EnemigoBase> enemigos2;
    List<Disparo> disparosAEliminar;
    List<EnemigoBase> enemigosAEliminar;
    Temporizador nuevoEnemigo, nuevoEnemigo2;
    ScoreBoard scoreboard;
    boolean gameover;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(2f);

        inicializarJuego();
    }

    void inicializarJuego(){
        fondo = new Fondo();
        jugador = new Jugador();
        enemigos = new ArrayList<>();
        enemigos2 = new ArrayList<>();
        nuevoEnemigo = new Temporizador(120);
        nuevoEnemigo2 = new Temporizador(300);
        disparosAEliminar = new ArrayList<>();
        enemigosAEliminar = new ArrayList<>();
        scoreboard = new ScoreBoard();

        gameover = false;
    }

    void enemigoAnalizar() {
        List<List<EnemigoBase>> listasEnemigos = new ArrayList();
        listasEnemigos.add(enemigos);
        listasEnemigos.add(enemigos2);

        for(List<EnemigoBase> list:listasEnemigos) {

            for (EnemigoBase enemigo : list) {
                for (Disparo disparo : jugador.disparos) {
                    if (Utils.solapan(disparo.x, disparo.y, disparo.w, disparo.h, enemigo.x, enemigo.y, enemigo.w, enemigo.h)) {
                        disparosAEliminar.add(disparo);
                        enemigosAEliminar.add(enemigo);
                        jugador.puntos++;
                        break;
                    }
                }

                if (!gameover && !jugador.muerto && Utils.solapan(enemigo.x, enemigo.y, enemigo.w, enemigo.h, jugador.x, jugador.y, jugador.w, jugador.h)) {
                    jugador.morir();
                    if (jugador.vidas == 0){
                        gameover = true;
                    }
                }

                if (enemigo.x < -enemigo.w) {
                    enemigosAEliminar.add(enemigo);
                    if (jugador.puntos != 0){
                        if (gameover==false) {
                            jugador.puntos--;
                        }
                    }
                }
            }
        }
    }

    void update() {
        Temporizador.framesJuego += 1;

        if (nuevoEnemigo.suena()) enemigos.add(new Enemigo());
        if (nuevoEnemigo2.suena()) enemigos2.add(new Enemigo2());

        if(!gameover) jugador.update();

        for (EnemigoBase enemigo : enemigos) enemigo.update();              // enemigos.forEach(Enemigo::update);
        for (EnemigoBase enemigo2 : enemigos2) enemigo2.update();

        enemigoAnalizar();
        enemigoAnalizar();
        enemigoAnalizar();

        for (Disparo disparo : jugador.disparos)
            if (disparo.x > 640)
                disparosAEliminar.add(disparo);

        for (Disparo disparo : disparosAEliminar) jugador.disparos.remove(disparo);       // disparosAEliminar.forEach(disparo -> jugador.disparos.remove(disparo));
        for (EnemigoBase enemigo : enemigosAEliminar) enemigos.remove(enemigo);               // enemigosAEliminar.forEach(enemigo -> enemigos.remove(enemigo));
        disparosAEliminar.clear();
        enemigosAEliminar.clear();

        if(gameover) {
            int result = scoreboard.update(jugador.puntos);
            if(result == 1) {
                inicializarJuego();
            } else if (result == 2) {
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update();

        batch.begin();
        fondo.render(batch);
        jugador.render(batch);

        for (EnemigoBase enemigo : enemigos) enemigo.render(batch);  // enemigos.forEach(e -> e.render(batch));
        for (EnemigoBase enemigo2 : enemigos2) enemigo2.render(batch);
        font.draw(batch, "Vidas: " + jugador.vidas, 520, 460);
        font.draw(batch, "Puntos: " + jugador.puntos, 15, 460);

        if (gameover){
            scoreboard.render(batch, font);
        }
        batch.end();
    }
}








/*

init();

create();

while(true) render();

 */