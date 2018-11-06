/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Algoritmo;
import Modelo.ColaProcesos;
import Modelo.Proceso;
import Modelo.Requisiciones;
import Modelo.Solicitud;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rigo-PC
 */
public class Controlador {
    
    private int cantidadProcesos = 0;  // Usado como identificador
    private ColaProcesos listaProcesos;
    private ArrayList<Requisiciones> listaRequesiciones;
    private ArrayList<Algoritmo> gestorAlgoritmos;
    private int inicial =-1;
    

    public Controlador() {
        listaProcesos = new ColaProcesos(1000);
        listaRequesiciones = new ArrayList<>();
        gestorAlgoritmos = new ArrayList<>();
    }

    public int getCantidadProcesos() {
        return cantidadProcesos;
    }

    public void setCantidadProcesos(int cantidadProcesos) {
        this.cantidadProcesos = cantidadProcesos;
    }

    public ColaProcesos getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ColaProcesos listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public ArrayList<Requisiciones> getListaRequesiciones() {
        return listaRequesiciones;
    }

    public void setListaRequesiciones(ArrayList<Requisiciones> listaRequesiciones) {
        this.listaRequesiciones = listaRequesiciones;
    }

    public ArrayList<Algoritmo> getGestorAlgoritmos() {
        return gestorAlgoritmos;
    }

    public void setGestorAlgoritmos(ArrayList<Algoritmo> gestorAlgoritmos) {
        this.gestorAlgoritmos = gestorAlgoritmos;
    }
    
    /**
     * Permite agregar un algoritmo
     * @param algoritmo 
     */
    public void agregarAlgoritmo(Algoritmo algoritmo){
        this.gestorAlgoritmos.add(algoritmo);
    }
    
    /**
     * Metodo que imprime las listas de requesiciones
     * @return 
     */
    public String imprimirListaRequisiciones(){
        String result="";
        for(Requisiciones requesiciones : this.listaRequesiciones){
            result+=requesiciones.imprimirRequsiciones();
        }
        return result;
    }
    
    
    /**
     * Metodo que se encarga de leer los procesos de un archivo
     * @param file
     * @return 
     */
    public boolean leerProcesos(File file){
        try {
            FileReader  fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String linea;
            
            int identificador = this.cantidadProcesos;
            String nombre;
            int prioridad;
            String usuario;
            
            while( (linea = br.readLine() ) != null){
                String[] parts = linea.split(";");
                
                //System.out.println("Linea: "+parts[0]+" "+parts[1]+" "+parts[2]);
                nombre = parts[0];
                prioridad = Integer.parseInt(parts[1]);
                usuario = parts[2];
                
                Proceso proceso = new Proceso(identificador,nombre,prioridad,usuario);
                this.listaProcesos.AgregarProceso(proceso);
                this.cantidadProcesos++;
                identificador++;
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Metodo que permite leer las requsiciones de los archivos.
     * @param file
     * @return 
     */
    public boolean leerRequisiciones(File file){
        try {
            FileReader  fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String linea;

            String proceso;
            int pista;
            
            String[] parts;
            String[] requis;
            
            while( (linea = br.readLine() ) != null){
                parts = linea.split(",");
                Requisiciones requisicion = new Requisiciones();
                
                for (String part : parts) {
                    requis = part.split(";");
                    pista = Integer.parseInt(requis[0]);
                    proceso = requis[1];
                    Solicitud solictud = new Solicitud(proceso, pista);
                    requisicion.agregarSolicitud(solictud);
                }
                this.listaRequesiciones.add(requisicion);
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Activa algoritmo para el ejecutar
     * @param algoritmo 
     */
    public void activarAlgoritmo(int algoritmo){
        this.gestorAlgoritmos.get(algoritmo).setActivado(true);
    }
    
    /**
     * Desactiva el algoritmo para el ejecutar
     * @param algoritmo 
     */
    public void desactivarAlgoritmo(int algoritmo){
        this.gestorAlgoritmos.get(algoritmo).setActivado(false);
    }
    
    /**
     * Metodo que ejecuta los algoritmos activados
     * @param requisicion 
     * @param inicio 
     * @param total 
     * @param direccion 
     * @param cantidad 
     */
    public void ejecutarAlgoritmos(int requisicion,int inicio,int total,int direccion,int cantidad){
        this.inicial = inicio;
        for(Algoritmo algoritmo : this.gestorAlgoritmos){
            if(algoritmo.isActivado()){
               algoritmo.ejecutar(this.listaRequesiciones.get(requisicion),inicio,total,direccion,cantidad);
                System.out.println(algoritmo.getResultados().toString());
            }
        }
    }
    /**
     * Determina el orden del proceso
     * @return 
     */
    public ArrayList<String> ordenProcesosPrioridad(){
        ArrayList<String> resultado = new ArrayList<>();
        
        ArrayList<Integer> prioridades = this.listaProcesos.getPrioridades();
        ArrayList<String> nombres = this.listaProcesos.geNombreProcesos();
        
        int largo = prioridades.size();
        int mayor;
        for(int i=0;i<largo;i++){
            mayor = this.posNumeroMayor(prioridades);
            resultado.add(nombres.get(mayor));
            prioridades.remove(mayor);
            nombres.remove(mayor);
        }
        
        return resultado;
    }
    
    /**
     * Retorna la posicion del mayor
     * @param lista
     * @return 
     */
    public int posNumeroMayor(ArrayList<Integer> lista){
        int mayor=lista.get(0);
        int cont =0;
        for(int i=1;i<lista.size();i++){
            if(lista.get(i)>mayor){
                mayor = lista.get(i);
                cont=i;
            }
        }
        return cont;
    }
    
    public int valorAbsoluto (int numero) {
      return numero > 0 ? numero : -numero;
    }
    
    /***
     * calcula las pistas recorridas
     * @param algoritmo
     * @return 
     */
    public ArrayList<Integer> calcularEstadisticaAlgoritmo(Algoritmo algoritmo){
        ArrayList<ArrayList<Integer>> resultados = algoritmo.getResultados();
        ArrayList<Integer> result = new ArrayList<>();
        int anterior = this.inicial; 
        int abs = 0;
        for(ArrayList<Integer> resultado : resultados){
            for(Integer valor : resultado){
                abs = valorAbsoluto(anterior-valor);
                result.add(abs);
            }
        }
        return result;
    }
    
    /**
     * Calcula el promedio de los resultados
     * @param valores
     * @return 
     */
    public int promedioEstadistica(ArrayList<Integer> valores){
        int suma=0;
        for(Integer valor : valores){
            suma+=valor;
        }
        return suma/valores.size();
    }
    
    /**
     * Metodo que escribe las estadisticas
     * @param algoritmo
     * @return 
     */
    public String verEstadisticaAlgoritmo(Algoritmo algoritmo){
        ArrayList<ArrayList<Integer>> resultados = algoritmo.getResultados();
        ArrayList<Integer> valores = calcularEstadisticaAlgoritmo(algoritmo);
        String result = algoritmo.getNombre()+"\n"+
                "Siguiente\t\tNúmero\n";
        int cont=0;
        for(ArrayList<Integer> resultado : resultados){
            for(Integer valor : resultado){
                result+=String.valueOf(valor)+"\t\t "+String.valueOf(valores.get(cont))+"\n";
                cont++;
            }
        }
        int promedio = promedioEstadistica(valores);
        result+="Promedio:\t\t"+String.valueOf(promedio);
        System.out.println(result);
        return result;
    }
    
    public String verEstadisticas(){
        String result="";
        for(Algoritmo algoritmo : this.gestorAlgoritmos){
            if(algoritmo.isActivado()){
                result = verEstadisticaAlgoritmo(algoritmo);
            }
        }
        return result;
    }
}
