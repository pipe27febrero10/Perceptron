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
    private float umbral=1;
    private float x0 = 1;
    private int x1,x2;
    private int y1;
    private float total;
    private float factorGanancia=1;


    public Perceptron(float[] w,int x1, int x2) {
        this.w = w;
        this.x1 = x1;
        this.x2 = x2;
    }
    
    public float calculateFunction(){
       this.total = w[0]*x1 + w[1]*x2-x0*umbral;  
       return this.total; 
    }
    
    public int activationFunction(){
        if(this.total>0){
            y1 = 1;
            return y1;
        }
        else{
            y1 = 0;
            return y1;
        }
    }
    
    public int error(int salidaDeseada){
        System.out.println("salidadeseada "+ salidaDeseada+ " salida real"+this.y1);
        int error = salidaDeseada - this.y1;
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

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public float getTotal() {
        return total;
    }

    public void setW(float[] w) {
        this.w = w;
    }
    public void setW(int error) {
        if(error!=0){ // arreglar si no es cero
           this.w[0] = this.w[0] + this.factorGanancia*error*this.x1;
           this.w[1] = this.w[1] + this.factorGanancia*error*this.x2;
        }
    }

    public void setUmbral(float umbral) {
        this.umbral = umbral;
    }

    public void setX0(float x0) {
        this.x0 = x0;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setTotal(float total) {
        this.total = total;
    }
  
   
   
    
    
    
}
