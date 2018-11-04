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
    private String estado;
    private int prioridad;
    private int ProgramCounter;
    private String nombre;
    private boolean uso;
    
    public Proceso(int identificador,String estado, int prioridad, String nombre) {
        
        this.identificador = identificador;
        this.prioridad = prioridad;
        this.uso=false;
        this.estado = estado;
        this.nombre=nombre;
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
    

    public boolean isUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    } 
    
    public void ImprimirProceso(){
        System.out.println("Proceso # " + this.identificador +
        " Estado:  " + estado + " Prioridad: " + this.prioridad);
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

    public int getProgramCounter() {
        return ProgramCounter;
    }

    public void setProgramCounter(int ProgramCounter) {
        this.ProgramCounter = ProgramCounter;
    }    


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proceso{" + "identificador=" + identificador + ", estado=" + estado + ", prioridad=" + prioridad + ", ProgramCounter=" + ProgramCounter + ", nombre=" + nombre + ", uso=" + uso + '}';
    }
    
}
