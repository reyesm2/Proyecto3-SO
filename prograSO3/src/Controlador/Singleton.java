/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Rigo-PC
 */
public class Singleton {
    
    private static Singleton INSTANCE = null;
    private Controlador controlador;

    private Singleton () {
        controlador = new Controlador();
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    private synchronized  static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
}
