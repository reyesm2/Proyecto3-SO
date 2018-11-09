/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Algoritmos;

import Controlador.Singleton;
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
        
        System.out.println("Lista de Restas1: " + listaRestas);
        
        if(restaMejor != 1000){
            
            System.out.println("Resta mejor: " + restaMejor);
            
            int posicion = listaRestas.indexOf(restaMejor);
            System.out.println("Posicion de la mejor resta: " + posicion);
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
        
        
        System.out.println("Resta mejor: " + restaMejor);
        System.out.println("Lista de Restas2: " + listaRestas);
        int posicion = listaRestas.indexOf(restaMejor);
        return posicion;
        
            
            
        }
        
        
        
    }
    
    public ArrayList<Integer> SCAN(List<Solicitud> listaSolicitudes, int inicio,int total,int direccion,int cantidad){
        
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> tracks = new ArrayList<>();
        int trackResultado = 0;
        int posicionTrackResultado = 0;
        
        int size = listaSolicitudes.size();
        
        for(int i = 0 ; i < size; i++){
            
            
            
            int posicionSiguiente = this.masCercano(listaSolicitudes, inicio, direccion);
            trackResultado = listaSolicitudes.get(posicionSiguiente).getPista();
            System.out.println("trackResultado: "  + trackResultado);
            
            listaSolicitudes.remove(posicionSiguiente);
            result.add(trackResultado);
            
            
        }
        
        
        
        
        return result;
        //uper.agregarResultado(result);
        
    
        
    }
    
    
    @Override
    public void ejecutar(Requisiciones requesicion,int inicio,int total,int direccion,int cantidad){
        
        
        
        ArrayList<Solicitud> listaSolicitudes = (ArrayList)requesicion.getListaSolicitudes().clone();
        
        System.out.println(listaSolicitudes);
        
        int cantidadGrupos  = listaSolicitudes.size() / cantidad;   
        int sobrante = listaSolicitudes.size() % cantidad;      
        if(sobrante != 0){
            cantidadGrupos++;
        }
        
        List<Solicitud> subListaTemporal;
        ArrayList<List> listaGrupos = new ArrayList<>();
        int indiceInicial = 0;
        int indiceFinal = cantidad;
        
        for(int i = 0 ; i < cantidadGrupos; i++){
            
            if(indiceFinal > listaSolicitudes.size()){
                indiceFinal = listaSolicitudes.size()  ;
            }
            subListaTemporal = listaSolicitudes.subList(indiceInicial,indiceFinal);
            listaGrupos.add(subListaTemporal);
            indiceInicial += cantidad;
            indiceFinal += cantidad;
 
        }

        System.out.println("Lista de Grupos size: " + listaGrupos.size());
        
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> resultTemporal;
        
        SCAN scan = new SCAN("SCAN");
        
        for(List subLista : listaGrupos){
            
            //resultTemporal = this.SCAN(subLista, inicio, total, direccion, cantidad);
            resultTemporal = scan.ejecutar2(subLista, inicio, total, direccion, cantidad);
            result.addAll(resultTemporal);
            
        }
        
        super.agregarResultado(result);
        
        
        
        
    }
    
    
}
