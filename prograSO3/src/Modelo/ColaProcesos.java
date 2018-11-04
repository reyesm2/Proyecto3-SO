/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Rigo-PC
 */
public class ColaProcesos {
    private int tamano;
    private ArrayList<Proceso> listaProcesos;

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public ArrayList<Proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    
    public ColaProcesos(int tamano){

        this.tamano = tamano;
        listaProcesos = new ArrayList<Proceso>();
    }
    
    
    public boolean validarNombre(String nombre){
        for(Proceso proceso: this.listaProcesos){
            if(proceso.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public String getNombreProceso(int idProceso){
        
        int idTemporal;
        for(Proceso proceso: this.listaProcesos){
            idTemporal = proceso.getIdentificador();
            if(idTemporal == idProceso){
                String val = proceso.getNombre();
                return val;
            }
        }
        return "";
        
        
    }
    public String getProceso(int idProceso){
        int idTemporal;
        for(Proceso proceso: this.listaProcesos){
            idTemporal = proceso.getIdentificador();
            if(idTemporal == idProceso){
                String val = " ID:  "+proceso.getIdentificador()+"  Estado:  "+proceso.getEstado()
                        +"  Prioridad:  "+proceso.getPrioridad();
                
                
                
                return val;
            }
        }
        return "";
    }
    
    public boolean isProcessBlocked(int idProceso){
        
        for(Proceso proceso : this.listaProcesos){
            
            int idProcesoTemporal = proceso.getIdentificador();
            String estadoTemporal  = proceso.getEstado();
            if(idProcesoTemporal == idProceso && estadoTemporal.equals("Block")){
                return true;
            }
        }
        return false;
        
    }
    
    public void ImprimirColaProcesos(){

        for (Proceso proceso : this.listaProcesos) {
            proceso.ImprimirProceso();
        }

    }

       public void AgregarProceso(Proceso proceso){
        this.listaProcesos.add(proceso);
    }

    public void cambiarPC(int proceso,boolean cambio){
        for(int i=0;i<this.listaProcesos.size();i++){
            Proceso proc = this.listaProcesos.get(i);
            if(proc.getIdentificador()==proceso){
                proc.setUso(cambio);
                this.listaProcesos.set(i, proc);
            }
        }
    }
    
}
