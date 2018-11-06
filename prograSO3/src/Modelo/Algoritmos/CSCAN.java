/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Algoritmos;

import Modelo.Requisiciones;
import Modelo.Solicitud;
import java.util.ArrayList;

/**
 *
 * @author Rigo-PC
 */
public class CSCAN extends SCAN{

    public CSCAN(String nombre) {
        super(nombre);
    }
    
    
    
    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        
        
        int cabezaDisco = inicio; 
        
        ArrayList<Solicitud> listaSolicitudes = requesicion.getListaSolicitudes();
        Solicitud solicitudTemporal;
        ArrayList<Integer> result = new ArrayList<>();
        
        if(direccion == 1 ){
            
            while(cabezaDisco != total-1){
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                result.add(solicitudTemporal.getPista());
                cabezaDisco++;
            }
            
            cabezaDisco = 0 ;
            
            while(cabezaDisco != total-1){
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                result.add(solicitudTemporal.getPista());
                cabezaDisco++;
            }
            
        }
        else{
            
            while(cabezaDisco != 0){
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                result.add(solicitudTemporal.getPista());
                cabezaDisco--;
            }
            
            cabezaDisco = total-1;
            
            while(cabezaDisco != 0){
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                result.add(solicitudTemporal.getPista());
                cabezaDisco--;
            }
            
        }
        
        super.agregarResultado(result);
    }
    
}
