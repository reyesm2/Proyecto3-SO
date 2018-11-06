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
public class SCAN extends Algoritmo{

    public SCAN(String nombre) {
        super(nombre);
    }

    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        
        
        ArrayList<Solicitud> listaSolicitudes = requesicion.getListaSolicitudes(); 
        ArrayList<Integer> result = new ArrayList<>();
        
        
        int cabezaDisco = inicio;
        
        Solicitud solicitudTemporal; 
        while(cabezaDisco != total-1  || cabezaDisco != 0){
            
            solicitudTemporal = listaSolicitudes.get(cabezaDisco);
            result.add(solicitudTemporal.getPista());
            
            if (direccion == 1){
                cabezaDisco++;
            }
            else{
                cabezaDisco--;
            }
            
        }
        
        if(direccion == 1 ){
            
            while(cabezaDisco != 0 ){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                result.add(solicitudTemporal.getPista());
                cabezaDisco--;
            }
        }
        else{
            
            while(cabezaDisco != total-1){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                result.add(solicitudTemporal.getPista());
                cabezaDisco++;
                
            }
        }
        
        super.agregarResultado(result);
        
    }
    
}
