/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Modelo.Algoritmo;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Rigo-PC
 */
public class GraficoComparativo extends javax.swing.JFrame {

    JPanel panel;
    
    /**
     * Creates new form GraficoComparativo
     * @param select
     * @param algoritmos
     */
    public GraficoComparativo(ArrayList<Integer> select,ArrayList<Algoritmo> algoritmos) {
        setTitle("Grafico");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        pintarGrafico(select,algoritmos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void pintarGrafico(ArrayList<Integer> select,ArrayList<Algoritmo> algoritmos) {
        
        
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        
        
        for(Integer i : select){
            int cont=0;
            for(ArrayList<Integer> dato : algoritmos.get(i).getResultados()){
                for(Integer valor : dato){
                    line_chart_dataset.addValue(valor, algoritmos.get(i).getNombre(), String.valueOf(cont));
                    cont++;
                }
            }
            
        }
        // Creando el Grafico
        JFreeChart chart=ChartFactory.createLineChart("Resultado",
                "Tiempo","Numeros pistas",line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);  
        
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}