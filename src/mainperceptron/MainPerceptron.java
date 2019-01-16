/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainperceptron;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Pipe
 */
public class MainPerceptron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer[]> x = new ArrayList<Integer[]>();  // ENTRADAS X1,X2,....Xn
        ArrayList<Integer> s = new ArrayList<Integer>();  // SOLUCIONES ESPERADAS S1,S2.....SN
        Integer[] xx;   
        // AGREGAR CONJUNTO X1,X2,....Xn
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                xx = new Integer[2];
                xx[0] = i;
                xx[1] = j;
                x.add(xx); // add binary par  entry x1 and x2
            }
        }
        // FIN AGREGAR CONJUNTO X1,X2,....XN
        // CONJUNTO SOLUCION 
        s.add(0); //s1
        s.add(1); //s2
        s.add(1); //s3 
        s.add(1); //s4
        // FIN CONJUNTO SOLUCION
        
        // PERCEPTRON ENTRENADO PARA COMPUERTA OR
        NeuronalNetwork neuronalNetworkOR = new NeuronalNetwork(x,s); // proveer de entradas y soluciones esperadas
        neuronalNetworkOR.printValuesXnSn(); // imprimir los valores de entradas y los esperados
        neuronalNetworkOR.machineLearning(); // entrenar a la red
        neuronalNetworkOR.printFunction();
        System.out.println("COMPUERTA OR");
        System.out.println("-----------------------------------------");
        // FIN DE ENTRENAMIENTO PARA COMPUERTA OR
        
        // SOLUCIONES PARA COMPUERTA AND
        s.clear();
        s.add(0);
        s.add(0);
        s.add(0);
        s.add(1);
        // PERCEPTRON ENTRENADO PARA COMPUERTA AND
        NeuronalNetwork neuronalNetworkAND = new NeuronalNetwork(x,s);
        neuronalNetworkAND.printValuesXnSn();
        neuronalNetworkAND.machineLearning();
        neuronalNetworkAND.printFunction();
         System.out.println("COMPUERTA AND");
        System.out.println("-----------------------------------------");
        // FIN DE ENTRENAMIENTO PARA COMPUERTA AND
        
        // SOLUCIONES PARA COMPUERTA NAND
        s.clear();
        s.add(1);
        s.add(1);
        s.add(1);
        s.add(0);
        // INICIO ENTRENAMIENTO PARA COMPUERTA NAND
        NeuronalNetwork neuronalNetworkNAND = new NeuronalNetwork(x, s);
        neuronalNetworkNAND.printValuesXnSn();
        neuronalNetworkNAND.machineLearning();
        neuronalNetworkNAND.printFunction();
        // FIN DE ENTRENAMIENTO PARA COMPUERTA NAND
        
        // RESOLVER COMPUERTA XOR  CON 3 PERCEPTRONES ENTRENADOS

        Perceptron OR = new Perceptron(neuronalNetworkOR.getPerceptron().getW());
                   OR.setUmbral(neuronalNetworkOR.getPerceptron().getUmbral());
        Perceptron NAND = new Perceptron(neuronalNetworkNAND.getPerceptron().getW());
                   NAND.setUmbral(neuronalNetworkNAND.getPerceptron().getUmbral());
        Perceptron AND = new Perceptron(neuronalNetworkAND.getPerceptron().getW());
                   AND.setUmbral(neuronalNetworkAND.getPerceptron().getUmbral());
        int A = 0, B = 0;
        
        int salidaNAND = NAND.activationFunction(NAND.calculateFunction(A, B));
        int salidaOR = OR.activationFunction(OR.calculateFunction(B, A));
        
        int resultadoXOR = AND.activationFunction(AND.calculateFunction(salidaNAND, salidaOR));
        
        System.out.println("salidas NAND"+salidaNAND);
        System.out.println("salidas OR "+salidaOR);
        System.out.println("A es : "+A+" B es : "+B+" SOLUCION : "+resultadoXOR);
     
        
    
        
       
        
        // FIN DE RESOLUCION COMPUERTA XOR
       

     
    }

}
