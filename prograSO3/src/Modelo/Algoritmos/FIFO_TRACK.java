/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Algoritmos;

import Modelo.Algoritmo;
import Modelo.Requisiciones;
import Modelo.Solicitud;
import java.util.ArrayList;

/**
 *
 * @author Rigo-PC
 */
public class FIFO_TRACK extends Algoritmo{

    public FIFO_TRACK(String nombre) {
        super(nombre);
    }

    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        ArrayList<Integer> result = new ArrayList<>();
        
        for(Solicitud solicitud : requesicion.getListaSolicitudes()){
            result.add(solicitud.getPista());
            if(result.size()==total){
                break;
            }
        }
        super.agregarResultado(result);
        
    }
    
}
