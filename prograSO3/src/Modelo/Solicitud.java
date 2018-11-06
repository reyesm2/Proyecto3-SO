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
public class Solicitud {
    
    private String proceso;
    private int pista;

    public Solicitud(String proceso, int pista) {
        this.proceso = proceso;
        this.pista = pista;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public int getPista() {
        return pista;
    }

    public void setPista(int pista) {
        this.pista = pista;
    }

    public String imprimirSolicitud(){
        return pista +", "+  proceso +"\n";
    }
    
    @Override
    public String toString() {
        return pista +", "+  proceso +"\n";
    }

}
