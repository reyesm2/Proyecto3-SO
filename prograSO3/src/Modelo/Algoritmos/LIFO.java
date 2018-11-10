/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Algoritmos;

import Controlador.Singleton;
import Modelo.Algoritmo;
import Modelo.Proceso;
import Modelo.Requisiciones;
import Modelo.Solicitud;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Rigo-PC
 */
public class LIFO extends Algoritmo{

    public LIFO(String nombre) {
        super(nombre);
    }

    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        ArrayList<Proceso> cola = Singleton.getInstance().getControlador().getListaProcesos().getListaProcesos();
        ArrayList<Integer> result = new ArrayList<>();
        
        Collections.reverse(cola);
        
        System.out.println(cola.toString());
        for(Proceso proc : cola){
            for(Solicitud solicitud : requesicion.getListaSolicitudes()){
                if(proc.getNombre().equals(solicitud.getProceso())){
                    result.add(solicitud.getPista());
                }
                if(result.size()==total){
                    break;
                }
            }
            
        }
        super.agregarResultado(result);
        
    }
    
}
