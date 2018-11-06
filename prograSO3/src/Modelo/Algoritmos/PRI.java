/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Algoritmos;

import Controlador.Singleton;
import Modelo.Algoritmo;
import Modelo.Requisiciones;
import Modelo.Solicitud;
import java.util.ArrayList;

/**
 *
 * @author Rigo-PC
 */
public class PRI extends Algoritmo{

    public PRI(String nombre) {
        super(nombre);
    }
    
    @Override
    public void ejecutar(Requisiciones requisicion,int inicio,int total,int direccion,int cantidad){
        ArrayList<String> lista = Singleton.getInstance().getControlador().ordenProcesosPrioridad();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(String proc : lista){
            for(Solicitud solicitud : requisicion.getListaSolicitudes()){
                if(proc.equals(solicitud.getProceso())){
                    result.add(solicitud.getPista());
                }
            }
        }
        super.agregarResultado(result);
    }
    
}
