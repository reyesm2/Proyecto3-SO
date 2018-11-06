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
public class Requisiciones {
 
    private ArrayList<Solicitud> listaSolicitudes;

    public Requisiciones() {
        this.listaSolicitudes = new ArrayList<>();
    }

    public ArrayList<Solicitud> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList<Solicitud> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    @Override
    public String toString() {
        return "Requisicion:\n" + listaSolicitudes;
    }

    /**
     * Permite agregar una solicitud a las requesiciones
     * @param solicitud 
     */
    public void agregarSolicitud(Solicitud solicitud){
        this.listaSolicitudes.add(solicitud);
    }
    
    /**
     * Imprime la requesición
     * @return 
     */
    public String imprimirRequsiciones(){
        String result="Requisición:\n";
        for(Solicitud solicitud : this.listaSolicitudes){
            result+= solicitud.imprimirSolicitud();
        }
        return result;
    }
}
