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
public class SSTF extends Algoritmo{

    public SSTF(String nombre) {
        super(nombre);
    }

    @Override
    public void ejecutar(Requisiciones requisicion,int inicio,int total,int direccion,int cantidad){

        ArrayList<Integer> result = new ArrayList<>();

        
        ArrayList<Solicitud> listaSolicitud = (ArrayList<Solicitud>) requisicion.getListaSolicitudes().clone();
        
        for(int i=0;i<requisicion.getListaSolicitudes().size();i++){
            
            ArrayList<Integer> diferencias = calcularDiferencias(listaSolicitud, inicio);
            
            System.out.println("Inicio: "+inicio);
            System.out.println("Diferencias: "+diferencias.toString());
            System.out.println(listaSolicitud.toString());
            
            int pos = posNumeroMenor(diferencias);
            
            Solicitud solicitud = listaSolicitud.remove(pos);
            
            result.add(solicitud.getPista());
            inicio = solicitud.getPista();

        }
        super.agregarResultado(result);
    }
    
    public int valorAbsoluto (int numero) {
      return numero > 0 ? numero : -numero;
    }
    
    public ArrayList<Integer> calcularDiferencias(ArrayList<Solicitud> listaSolicitud,int inicial){
        ArrayList<Integer> result = new ArrayList<>();
        for(Solicitud solicitud : listaSolicitud){
            int valor = valorAbsoluto(solicitud.getPista()-inicial);
            result.add(valor);
        }
        return result;
    }
    
    /**
     * Retorna la posicion del mayor
     * @param lista
     * @return 
     */
    public int posNumeroMenor(ArrayList<Integer> lista){
        int menor=lista.get(0);
        int i =0;
        int result=0;
        for(i=0;i<lista.size();i++){
            
            if(menor>=lista.get(i)){
                menor=lista.get(i);
                result=i;

            }
 
        }
        return result;
    }
}
