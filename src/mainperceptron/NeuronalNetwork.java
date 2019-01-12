/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainperceptron;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Pipe
 */
public class NeuronalNetwork {
    private ArrayList<Integer[]> x = new ArrayList<Integer[]>();  // ENTRADAS X1,X2,....Xn
    private ArrayList<Integer> s = new ArrayList<Integer>();  // SOLUCIONES ESPERADAS S1,S2.....SN
    private Perceptron perceptron;
    float w[]= {0.5f, 1.5f};

    public NeuronalNetwork(ArrayList<Integer[]> x,ArrayList<Integer> s) {
        this.x = x;
        this.s = s;
    }
    
    public void machineLearning(){
      
       this.perceptron = new Perceptron(this.w); // inicializar perceptron
        int error[] = new int[4]; // errores del perceptron
        int y1[] = new int[4]; // salidas del perceptron

        // codigo revisado sin errores
        for (int i = 0; i < 4; i++) {
            float total = perceptron.calculateFunction(x.get(i)[0], x.get(i)[1]);
            y1[i] = perceptron.activationFunction(total);
            error[i] = perceptron.error(s.get(i), y1[i]);

        }

        float total;
        int c = 0;
        while (true) { //ajustar hasta que no hayan errores 

            for (int i = 0; i < 4; i++) {

                if (error[i] != 0) {

                    perceptron.setW(error[i], x.get(i)[0], x.get(i)[1]);

                }
                for (int j = 0; j < 4; j++) {
                    perceptron.printFunction();
                    total = perceptron.calculateFunction(x.get(j)[0], x.get(j)[1]);
                    y1[j] = perceptron.activationFunction(total);
                    error[j] = perceptron.error(s.get(j), y1[j]);
                    System.out.println("x1 vale : " + x.get(j)[0] + " x2 vale: " + x.get(j)[1] + "solucion esperada :" + s.get(j) + "solucion recibida: " + y1[j]);
                }

            }

            System.out.println("----------------");

            for (int i = 0; i < 4; i++) {
                if (error[i] != 0) {
                    c++;
                }
            }
            if (c == 0) {
                for (int i = 0; i < 4; i++) {
                    System.out.println("error" + error[i]);
                }
                // System.out.println(perceptron.error( 0,perceptron.activationFunction(perceptron.calculateFunction(1, 0))));
                break;
            } else {
                c = 0;
            }
        }
        
  
    }
    
    public void printValuesXnSn(){  // IMPRIME VALORES X1,X2...Xn y las soluciones esperadas
         System.out.println((x.get(0))[0] + "" + (x.get(0))[1]);
        Iterator I = x.iterator();
        System.out.println("x1" + " " + "x2" + " " + "s1");
        int count = 0;
        while (I.hasNext()) {
            Object m = I.next();
            Integer k[] = (Integer[]) m;
            System.out.println(k[0] + "  " + k[1] + "   " + s.get(count));
            count++;

        }

    }
    
    public void printFunction(){
        this.perceptron.printFunction();
    }

    public ArrayList<Integer[]> getX() {
        return x;
    }

    public ArrayList<Integer> getS() {
        return s;
    }

    public Perceptron getPerceptron() {
        return perceptron;
    }

    public float[] getW() {
        return w;
    }
    
    
   
}
