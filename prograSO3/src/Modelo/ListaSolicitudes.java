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
public class ListaSolicitudes {
 
    private ArrayList<Solicitudes> listaSolicitudes;

    public ListaSolicitudes() {
        this.listaSolicitudes = new ArrayList<>();
    }

    public ArrayList<Solicitudes> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList<Solicitudes> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

}
