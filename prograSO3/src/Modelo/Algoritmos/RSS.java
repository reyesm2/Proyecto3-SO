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

/**
 *
 * @author Rigo-PC
 */
public class RSS extends Algoritmo{

    public RSS(String nombre) {
        super(nombre);
    }

    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        ArrayList<Proceso> cola = Singleton.getInstance().getControlador().getListaProcesos().getListaProcesos();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> numero = listaRandoms(cola.size());
        System.out.println(numero);
        
        for(Integer i : numero){
            Proceso proc = cola.get(i);
            for(Solicitud solicitud : requesicion.getListaSolicitudes()){
                if(proc.getNombre().equals(solicitud.getProceso())){
                    result.add(solicitud.getPista());
                }
            }
        }
        super.agregarResultado(result);
        
    }
    
    public ArrayList<Integer> listaRandoms(int cantidad){
        ArrayList<Integer> result = new ArrayList<>();
        int numero;
        int i=0;
        while(i<cantidad){
            numero = (int) (Math.random() * 3);
            if(!result.contains(numero)){
                result.add(numero);
                i++;
            }
        }
        
        return result;
    }
}
