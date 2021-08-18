package com.cajero.cajero;

public class Cuenta {
   private int numeroCuenta;
   private int NIP;
   private double  saldo;
public Cuenta(int numeroCuenta, int nIP, double saldo) {
	
	this.numeroCuenta = numeroCuenta;
	this.NIP = nIP;
	this.saldo = saldo;
}


public int getNumeroCuenta() {
	return numeroCuenta;
}
public int getNIP() {
	return NIP;
}
public double getSaldo() {
	return saldo;
}


public void setSaldo(double saldo) {
	this.saldo = saldo;
}

 


   
}
