/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rigo-PC
 */
public class Proceso {
    
    
    private int identificador;
    private String nombre;
    private int prioridad;
    private String usuario;
    private String estado;

    public Proceso(int identificador, String nombre, int prioridad, String usuario) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.usuario = usuario;
        this.estado="Running";
    }
    
    
    
    public String getNombre(){
        return this.nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String ImprimirProceso(){
        return "Proceso: "+this.nombre
                + " Prioridad: " + this.prioridad +" Usuario: "+this.usuario;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


      
}
