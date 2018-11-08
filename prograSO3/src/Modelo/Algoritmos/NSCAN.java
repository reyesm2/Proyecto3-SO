/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Algoritmos;

import Modelo.Requisiciones;
import Modelo.Solicitud;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rigo-PC
 */
public class NSCAN extends SCAN{

    public NSCAN(String nombre) {
        super(nombre);
    }
    
    
    
    public ArrayList<Integer> SCAN(ArrayList<Solicitud> listaSolicitudes, int inicio,int total,int direccion,int cantidad){
        
        
        ArrayList<Integer> result = new ArrayList<>();
        int cabezaDisco = inicio;
        Solicitud solicitudTemporal;
        
        System.out.println("Lista de Solicitudes: " + listaSolicitudes);
        if(direccion == 1 ){
            
            
            while(cabezaDisco < listaSolicitudes.size()){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                
                if(solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco, null);
                }         
                cabezaDisco++;
                
            }
            
            cabezaDisco = listaSolicitudes.size() -1;
            while(cabezaDisco > -1 ){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                
                if(solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco, null);
                }
                cabezaDisco--;
            }
    
        }
        else{
            
            while(cabezaDisco > 0 ){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                
                if(solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco, null);
                }
                cabezaDisco--;
            }
            
            cabezaDisco = 0;
            
            while(cabezaDisco < listaSolicitudes.size()){
                
                solicitudTemporal = listaSolicitudes.get(cabezaDisco);
                
                if(solicitudTemporal != null){
                    result.add(solicitudTemporal.getPista());
                    listaSolicitudes.set(cabezaDisco,null);
                }
                cabezaDisco++;
            }   
        }
        
        
        return result;
        
    }
    
    
    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        
        
        
        ArrayList<Solicitud> listaSolicitudes = (ArrayList)requesicion.getListaSolicitudes().clone();
        
        
        int cantidadGrupos  = listaSolicitudes.size() / cantidad;   
        int sobrante = listaSolicitudes.size() % cantidad;      
        if(sobrante != 0){
            cantidadGrupos++;
        }
        
        List<Solicitud> subLista;
        ArrayList<List> listaGrupos = new ArrayList<>();
        int indiceInicial = 0;
        int indiceFinal = cantidad;
        
        for(int i = 0 ; i < cantidadGrupos; i++){
            
            
            
            
            if(indiceFinal > listaSolicitudes.size()){
                indiceFinal = listaSolicitudes.size()  ;
            }
            
            System.out.println("Indice Inicial: "  + indiceInicial + " Indice Final: " + indiceFinal);

            
            subLista = listaSolicitudes.subList(indiceInicial,indiceFinal);
            listaGrupos.add(subLista);
            indiceInicial += cantidad;
            indiceFinal += cantidad;
 
        }

        System.out.println("Lista de Grupos size: " + listaGrupos.size());
 
        
        
        
        
    }
    
    
}
