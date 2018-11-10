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
import java.util.List;

/**
 *
 * @author Rigo-PC
 */
public class SCAN extends Algoritmo{

    public SCAN(String nombre) {
        super(nombre);
    }
    
    
    
   
    public Integer masCercano(List<Solicitud> listaSolicitudes, int inicio, int direccion){
        
       
        
        ArrayList<Integer> listaRestas = new ArrayList<>();
        
        int resta = 0;
        int trackTemporal;
        int restaMejor = 1000;
        
        for(Solicitud solicitud: listaSolicitudes){
            
            if(solicitud != null){
                
                trackTemporal = solicitud.getPista();
                resta = Math.abs(inicio - trackTemporal);          
                listaRestas.add(resta);

                if(direccion == 1 ){

                    if (trackTemporal > inicio && resta < restaMejor){
                        restaMejor = resta;
                    }
                }
                else{

                    if(trackTemporal < inicio && resta < restaMejor){
                        restaMejor = resta;
                    }
                }
                
            }
            
            
        }
        
       // System.out.println("Lista de Restas1: " + listaRestas);
        
        if(restaMejor != 1000){
            
           // System.out.println("Resta mejor: " + restaMejor);
            
            int posicion = listaRestas.indexOf(restaMejor);
          //  System.out.println("Posicion de la mejor resta: " + posicion);
            return posicion;
            
        }
        else{
            
            if(direccion == 1){
                direccion = 0;
            }
            else{
                direccion = 1;
            }
            
        
        listaRestas.clear();
        for(Solicitud solicitud: listaSolicitudes){
            
            
            if(solicitud != null){
                
                trackTemporal = solicitud.getPista();
                resta = Math.abs(inicio - trackTemporal);          
                listaRestas.add(resta);

                if(direccion == 1 ){

                    if (trackTemporal > inicio && resta < restaMejor){
                        restaMejor = resta;
                    }
                }
                else{

                    if(trackTemporal < inicio && resta < restaMejor){
                        restaMejor = resta;
                    }
                }
            
                
            }
            
            
        }
        
        
        //System.out.println("Resta mejor: " + restaMejor);
        //System.out.println("Lista de Restas2: " + listaRestas);
        int posicion = listaRestas.indexOf(restaMejor);
        return posicion;
        
            
            
        }
        
        
        
    }
        
    
  
    public ArrayList<Integer> ejecutar2(List<Solicitud> listaSolicitudes2 ,int inicio,int total,int direccion,int cantidad){
        
        
        // ArrayList<Solicitud> listaSolicitudes = (ArrayList) listaSolicitudes2.clone();
        
        
        ArrayList<Solicitud> listaSolicitudes = new ArrayList<>();
        
        for(Solicitud solicitud: listaSolicitudes2){
            listaSolicitudes.add(solicitud);
        }
        
       
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> tracks = new ArrayList<>();
        int trackResultado = 0;
        int posicionTrackResultado = 0;
        
        int size = listaSolicitudes.size();
        
        for(int i = 0 ; i < size; i++){
            
            
            
            int posicionSiguiente = this.masCercano(listaSolicitudes, inicio, direccion);
            trackResultado = listaSolicitudes.get(posicionSiguiente).getPista();
            //System.out.println("trackResultado: "  + trackResultado);
            
            listaSolicitudes.remove(posicionSiguiente);
            result.add(trackResultado);
            
            
        }
        
        
        
        
        //super.agregarResultado(result);
        return result;
        
    
    
}
    
    
    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        
        
        ArrayList<Solicitud> listaSolicitudes = (ArrayList)requesicion.getListaSolicitudes().clone();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> tracks = new ArrayList<>();
        int trackResultado = 0;
        int posicionTrackResultado = 0;
        
        
        
        int size = listaSolicitudes.size();
        
        if(size > total){
            size = total;
        }

        
        for(int i = 0 ; i < size; i++){
            
            
            
            int posicionSiguiente = this.masCercano(listaSolicitudes, inicio, direccion);
            trackResultado = listaSolicitudes.get(posicionSiguiente).getPista();
            System.out.println("trackResultado: "  + trackResultado);
            
            listaSolicitudes.remove(posicionSiguiente);
            result.add(trackResultado); 
        }
         
        super.agregarResultado(result);
        
        
        
    }
    
}
