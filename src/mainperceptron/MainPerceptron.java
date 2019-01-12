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
       s.add(1); //s2
       s.add(1); //s3 
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
   
     
        
        

        float w[] ={0.5f,1.5f}; //pesos w1 y w2
        Perceptron perceptron = new Perceptron(w); // inicializar perceptron
        int error[] = new int[4]; // errores del perceptron
        int y1[] = new int[4]; // salidas del perceptron
        
             // codigo revisado sin errores
        for(int i=0;i<4;i++){
           float total= perceptron.calculateFunction(x.get(i)[0],x.get(i)[1]);
            y1[i] = perceptron.activationFunction(total);
            error[i] = perceptron.error(s.get(i),y1[i]);
           
        }
         
        
     
        float total;
        int c=0;
        while(true){ //ajustar hasta que no hayan errores 
         
           
           
            
            for(int i=0;i<4;i++){
          
             
               
      
             if(error[i]!=0){ 
               
               perceptron.setW(error[i],x.get(i)[0],x.get(i)[1]);
             
             }
                 for(int j=0;j<4;j++){
                     perceptron.printFunction();
                    total = perceptron.calculateFunction(x.get(j)[0],x.get(j)[1]);
                    y1[j] = perceptron.activationFunction(total);
                    error[j] = perceptron.error(s.get(j),y1[j]);
                    System.out.println("x1 vale : "+x.get(j)[0]+" x2 vale: "+x.get(j)[1]+"solucion esperada :"+s.get(j)+"solucion recibida: "+y1[j]);
                 }  
                
            }
            
            System.out.println("----------------");
            
               for(int i=0;i<4;i++){
                if(error[i]!=0){
                    c++;
                }
            }
            if(c==0){
               for(int i=0;i<4;i++){
                   System.out.println("error"+error[i]);
               }
              // System.out.println(perceptron.error( 0,perceptron.activationFunction(perceptron.calculateFunction(1, 0))));
                break;
            }
            else{
                c=0;
            }
        }
 
        
        // fin
     
        
        
        // perceptron.printFunction();
        float weight[] = {perceptron.getW()[0],perceptron.getW()[1]};
        Perceptron nuevo = new Perceptron(weight);
        nuevo.setUmbral(perceptron.getUmbral());
       System.out.println(nuevo.getUmbral());
     /*   nuevo.setX1(1);
        nuevo.setX2(0);
        nuevo.calculateFunction();
        nuevo.activationFunction();
        System.out.println(nuevo.getY1());
        perceptron.printFunction();
        
     */
        
        
        
        
      
        
 
        
    }
    
}
