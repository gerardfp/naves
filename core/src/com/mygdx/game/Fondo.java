package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fondo {
    Animacion animacion = new Animacion(3,
            new Texture("background/frame_00_delay-0.03s.gif"),
            new Texture("background/frame_01_delay-0.03s.gif"),
            new Texture("background/frame_02_delay-0.03s.gif"),
            new Texture("background/frame_03_delay-0.03s.gif"),
            new Texture("background/frame_04_delay-0.03s.gif"),
            new Texture("background/frame_05_delay-0.03s.gif"),
            new Texture("background/frame_06_delay-0.03s.gif"),
            new Texture("background/frame_07_delay-0.03s.gif"),
            new Texture("background/frame_08_delay-0.03s.gif"),
            new Texture("background/frame_09_delay-0.03s.gif"),
            new Texture("background/frame_10_delay-0.03s.gif"),
            new Texture("background/frame_11_delay-0.03s.gif"),
            new Texture("background/frame_12_delay-0.03s.gif"),
            new Texture("background/frame_13_delay-0.03s.gif"),
            new Texture("background/frame_14_delay-0.03s.gif"),
            new Texture("background/frame_15_delay-0.03s.gif"),
            new Texture("background/frame_16_delay-0.03s.gif"),
            new Texture("background/frame_17_delay-0.03s.gif"),
            new Texture("background/frame_18_delay-0.03s.gif"),
            new Texture("background/frame_19_delay-0.03s.gif"),
            new Texture("background/frame_20_delay-0.03s.gif"),
            new Texture("background/frame_21_delay-0.03s.gif"),
            new Texture("background/frame_22_delay-0.03s.gif"),
            new Texture("background/frame_23_delay-0.03s.gif"),
            new Texture("background/frame_24_delay-0.03s.gif"),
            new Texture("background/frame_25_delay-0.03s.gif"),
            new Texture("background/frame_26_delay-0.03s.gif"),
            new Texture("background/frame_27_delay-0.03s.gif"),
            new Texture("background/frame_28_delay-0.03s.gif"),
            new Texture("background/frame_29_delay-0.03s.gif")



    );

    public void render(SpriteBatch batch) {
        batch.draw(animacion.obtenerFrame(), 0, 0, 640, 480);
    }
}
