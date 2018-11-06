/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Rigo-PC
 */
public abstract class Algoritmo {
    
    private String nombre;
    private boolean activado;
    private ArrayList<ArrayList<Integer>> resultados; 
    
    public Algoritmo(String nombre) {
        this.nombre = nombre;
        this.activado=false;
        this.resultados = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public ArrayList<ArrayList<Integer>> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<ArrayList<Integer>> resultados) {
        this.resultados = resultados;
    }
    
    public void agregarResultado(ArrayList<Integer> result){
        this.resultados.add(result);
    }
    
    public void ejecutar(Requisiciones requisiciones,int inicio,int total,int direccion,int cantidad){};

}
