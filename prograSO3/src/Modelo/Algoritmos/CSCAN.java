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
    
    
    /// Listo
    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        
        
        int cabezaDisco = inicio; 
        
        ArrayList<Solicitud> listaSolicitudes = (ArrayList)requesicion.getListaSolicitudes().clone();
        Solicitud solicitudTemporal;
        ArrayList<Integer> result = new ArrayList<>();
        
        if(direccion == 1 ){
            
            while(cabezaDisco  < listaSolicitudes.size() ){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                
                if( solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco, null);
                    
                }
                
                cabezaDisco++;
            }
            
            cabezaDisco = 0 ;
            
            while(cabezaDisco < listaSolicitudes.size() ){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                if(solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco, null);
                }
                
                cabezaDisco++;
            }
            
        }
        else{
            
            while(cabezaDisco > -1){
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                
                if(solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco, null);
                }
                
                cabezaDisco--;
            }
            
            cabezaDisco = listaSolicitudes.size() -1 ;
            
            while(cabezaDisco > -1 ){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                
                if(solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco, null);
                }
                
                cabezaDisco--;
            }
            
        }
        
        super.agregarResultado(result);
    }
    
}
