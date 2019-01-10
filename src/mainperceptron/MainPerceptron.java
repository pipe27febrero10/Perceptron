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
public class MainPerceptron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer[]> x = new ArrayList<Integer[]>();  // inputs
        ArrayList<Integer> s = new ArrayList<Integer>();  // solutions
        Integer[] xx ;
        
        for(int i=0;i<=1;i++){
            for(int j=0;j<=1;j++){
                xx = new Integer[2];
                xx[0] = i;
                xx[1] = j;
                x.add(xx); // add binary par  entry x1 and x2
            }
        }
       s.add(0); //s1
       s.add(0); //s2
       s.add(0); //s3 
       s.add(1); //s4

      System.out.println((x.get(0))[0]+""+(x.get(0))[1]);
      Iterator I = x.iterator();
      System.out.println("x1"+" "+"x2"+" "+"s1");
      int count =0;
      while(I.hasNext()){
          Object m = I.next();
          Integer k[] = (Integer[])m;
          System.out.println(k[0]+"  "+k[1]+"   "+s.get(count));
          count++;
         
      }
        
     
        
        

        float w[] ={1,1}; //weight
        Perceptron[] perceptron = new Perceptron[4];
        
        
        for(int i=0;i<4;i++){
            perceptron[i] = new Perceptron(w,x.get(i)[0],x.get(i)[1]);
            perceptron[i].calculateFunction();
            perceptron[i].activationFunction();
        }
        count = 0;
        int error[] = new int[4]; // errores del perceptron
        for (Perceptron p : perceptron) {
          System.out.println("resultado del perceptron "+p.getY1()); 
          System.out.println("error "+p.error(s.get(count)));
          error[count] = p.error(s.get(count)); // asignar los errores si todos son ceros la red ha aprendido
          count++;
          
        }
        boolean sinError = false;
        int c=0;
        while(!sinError){ //ajustar hasta que no hayan errores 
            for(int i=0;i<4;i++){
                if(error[i]!=0){
                    c++;
                }
            }
            if(c==0){
                sinError = true;
               
                continue;
            }
            else{
                c=0;
            }
            
            // arreglar pesos ahora
            for(int i=0;i<4;i++){
                perceptron[i].setW(error[i]);
                // recalcular valores
                perceptron[i].calculateFunction();
                perceptron[i].activationFunction();
               error[i] = perceptron[i].error(s.get(i));
            
            }
            
        
        }
      
        
 
        
    }
    
}
