/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainperceptron;

import java.util.ArrayList;

/**
 *
 * @author Pipe
 */
public class Perceptron {
    private float w[];
    private float umbral=1.5f;
    private float x0 = 1;
    private float factorGanancia=1;


    public Perceptron(float[] w) {
        this.w = w;
      
    }
    
    public float calculateFunction(int x1,int x2){
      float total  = w[0]*x1 + w[1]*x2+x0*umbral;  
       return total; 
    }
    
    public int activationFunction(float total){
        if(total>=0){
            
            return 1;
        }
        else{
            return 0;
        }
    }
    public void printFunction(){
        System.out.println("Funcion nueva ajustada: "+this.w[0]+"*x1 +"+this.w[1]+"*x2 + "+this.umbral+"*x0");
    }
    public int error(int salidaDeseada,int salidaY1){
      //  System.out.println("salidadeseada "+ salidaDeseada+ " salida real"+this.y1);
        int error = salidaDeseada - salidaY1;
        return error;
    }

    public float[] getW() {
        return w;
    }

    public float getUmbral() {
        return umbral;
    }

    public float getX0() {
        return x0;
    }

   

    public void setW(float[] w) {
        this.w = w;
    }
    public void setW(int error,int x1,int x2) {
        
           this.umbral = this.umbral +this.factorGanancia*error*this.x0;
           this.w[0] = this.w[0] + this.factorGanancia*error*x1;
           this.w[1] = this.w[1] + this.factorGanancia*error*x2;
        
    }

    public void setUmbral(float umbral) {
        this.umbral = umbral;
    }

    public void setX0(float x0) {
        this.x0 = x0;
    }

 
   
   
    
    
    
}
