package com.cajero.cajero;

public class Dispensador_Cajero {
    private double cantidaDineroDisponible=200;
    
    public boolean verificarDisponibilidadDinero() {
    	boolean disponibilidad=true;
    	if (cantidaDineroDisponible==0) {
			disponibilidad=false;
		}
    	
    	return disponibilidad;
    }
    
    
    public boolean descontarDinero(int valor) {
    	boolean exitoOperacion=true;
    	int [] valores= {0,20,40,60,100,200};
    	if (valores[valor]<=this.conseguirParteEntera(cantidaDineroDisponible)) {
			this.cantidaDineroDisponible=this.cantidaDineroDisponible-valores[valor];
        }else {
        	exitoOperacion=false;
        }
    	
    	return exitoOperacion;
	}
    
    
    public void añadirDinero(double valor) {
    	this.cantidaDineroDisponible+=valor;
    }
    
    
    
    
   
    
    public double conseguirParteEntera(double valor) {
    	double parteDecimal = valor % 1;
    	return (valor - parteDecimal);
    }
    	
    
}
