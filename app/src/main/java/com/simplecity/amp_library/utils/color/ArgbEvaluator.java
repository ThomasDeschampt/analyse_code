package com.simplecity.amp_library.utils.color;

import android.animation.TypeEvaluator;

public class ArgbEvaluator implements TypeEvaluator {
    /**
     * Instance unique d’ArgbEvaluator, stateless et réutilisable.
     */
    public static final ArgbEvaluator INSTANCE = new ArgbEvaluator();

    // Constructeur privé pour empêcher l'instanciation extérieure
    private ArgbEvaluator() { }

    /**
     * Cette fonction retourne la valeur interpolée entre deux couleurs.
     *
     * @param fraction Fraction entre la valeur de départ et celle d’arrivée
     * @param startValue Couleur de départ (int 32-bit ARGB)
     * @param endValue Couleur d’arrivée (int 32-bit ARGB)
     * @return Couleur interpolée (int 32-bit ARGB)
     */
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        float startA = ((startInt >> 24) & 0xff) / 255.0f;
        float startR = ((startInt >> 16) & 0xff) / 255.0f;
        float startG = ((startInt >> 8) & 0xff) / 255.0f;
        float startB = (startInt & 0xff) / 255.0f;

        int endInt = (Integer) endValue;
        float endA = ((endInt >> 24) & 0xff) / 255.0f;
        float endR = ((endInt >> 16) & 0xff) / 255.0f;
        float endG = ((endInt >> 8) & 0xff) / 255.0f;
        float endB = (endInt & 0xff) / 255.0f;

        // Convertir de sRGB à linéaire
        startR = (float) Math.pow(startR, 2.2);
        startG = (float) Math.pow(startG, 2.2);
        startB = (float) Math.pow(startB, 2.2);

        endR = (float) Math.pow(endR, 2.2);
        endG = (float) Math.pow(endG, 2.2);
        endB = (float) Math.pow(endB, 2.2);

        // Calcul de la couleur interpolée en espace linéaire
        float a = startA + fraction * (endA - startA);
        float r = startR + fraction * (endR - startR);
        float g = startG + fraction * (endG - startG);
        float b = startB + fraction * (endB - startB);

        // Convertir de nouveau en sRGB dans [0..255]
        a = a * 255.0f;
        r = (float) Math.pow(r, 1.0 / 2.2) * 255.0f;
        g = (float) Math.pow(g, 1.0 / 2.2) * 255.0f;
        b = (float) Math.pow(b, 1.0 / 2.2) * 255.0f;

        return Math.round(a) << 24 | Math.round(r) << 16 | Math.round(g) << 8 | Math.round(b);
    }
}