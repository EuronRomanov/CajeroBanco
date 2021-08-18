package com.cajero.cajero;

import java.util.Scanner;

public class AdministrarCuentas {
	
	private DBCuentas dbCuentas=new DBCuentas();
	private Dispensador_Cajero dispensador=new Dispensador_Cajero();
	private Scanner entradaEscaner = new Scanner (System.in);
	
	private Cuenta [] cuentas=dbCuentas.cuentas;
	private boolean autorizado=false;
	private int nip;
	private int numeroCuenta;
	private String messageErrorAuthentication="";
	
	public void autentificacion(String numeroCuenta, String nip) {
		
		
		if (this.validarFormato(nip)==false && this.validarFormato(numeroCuenta)==false ) {
			this.messageErrorAuthentication="El nip y número de cuenta deben tener 5 digitos";
		}else {
			
			if (this.cuentaOnipInvalidados(numeroCuenta, nip)==false && this.existeCuenta(numeroCuenta, nip)) {
				
				this.autorizado=true;
				this.resetMessageErrorAuthentication();
			} 
			
		}
		
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
	
	
	
	//validate format account and nip
	public boolean validarFormato(String credencial) {
		boolean flag=false;
		if (credencial.matches("[0-9]{5}")) {
			flag=true;
		}
		return flag;
	}
	
	public boolean cuentaOnipInvalidados(String numeroCuenta, String nip) {
		boolean flag=false;
		if (this.validarFormato(numeroCuenta)==false) {
			this.messageErrorAuthentication="El numero de cuenta debe tener 5 digitos";
			flag=true;
		}else if(this.validarFormato(nip)==false) {
			this.messageErrorAuthentication="El nip debe tener 5 digitos";
			flag=true;
		}
		
		
		return flag;
	}

	//validate exist nip or account
	
	public boolean existeCuenta(String numeroCuenta,String nip ) {
		boolean flag=true;
		
		if (dbCuentas.buscarCuenta(Integer.parseInt(numeroCuenta))==false && dbCuentas.buscarNIP(Integer.parseInt(nip))==false) {
			this.messageErrorAuthentication="No exite cuenta";
			flag=false;
		} else {
			
			if (dbCuentas.buscarCuenta(Integer.parseInt(numeroCuenta))==false && dbCuentas.buscarNIP(Integer.parseInt(nip))) {
				this.messageErrorAuthentication="Numero de cuenta equivocado";
				flag=false;
			} else if(dbCuentas.buscarNIP(Integer.parseInt(nip))==false && dbCuentas.buscarCuenta(Integer.parseInt(numeroCuenta))){
				this.messageErrorAuthentication="Nip incorrecto";
				flag=false;

			}

		}
		
		return flag;
	}

	//Messages
	
	public String getMessageErrorAuthentication() {
		return messageErrorAuthentication;
	}

	public void resetMessageErrorAuthentication() {
		this.messageErrorAuthentication = "";
	}
	
	
	
	//operations menu principal
	
	public void desplegarOpcionSeleccionada(int opcion, int numeroCuentaMenu) {
		switch (opcion) {
		case 1:
			
			System.out.println(dbCuentas.consultarSaldo(numeroCuentaMenu));
			break;
		case 2:
			
			this.retirarDinero( numeroCuentaMenu );
			break;
		case 3:
			this.depositarDinero(numeroCuentaMenu);
			break;
		case 4:
			System.out.println("-------------FIN OPERACION--------------");
			this.autorizado=false;
			break;
		default:
			System.out.println("Por favor seleccione una opcion");
			break;
		}
	}
	
	

	private void depositarDinero(int numeroCuentaMenu) {
		String valor=null;
		int opcion=1;
		while (opcion!=0) {
			System.out.println("Despositar");
			System.out.println("0 - Cancelar transacion");
			System.out.println("Ingrese el monto a depositar sin comas:");
			valor=entradaEscaner.nextLine();
			if (valor.matches("[0-9]*")) {
				dbCuentas.agregarDinero(numeroCuentaMenu, Integer.parseInt(valor));
			}
			if (valor.equalsIgnoreCase("0")) {
				opcion=0;
			}
		}
		
	}

	public void retirarDinero(int numeroCuentaMenu ) {
		int valor=0;
		while (valor!=6) {
			System.out.println("Menú de retiro");
			System.out.println("1 - $20 \n"+
							   "2 - $40 \n"+
							   "3 - $60  \n"+
							   "4 - $100 \n"+
							   "5 - $200 \n"+
							   "6 - Cancelar transacion");
			System.out.println("Elija un monto de retiro:");
			valor=entradaEscaner.nextInt();
			
			if (valor>=1 && valor <=5 && dispensador.verificarDisponibilidadDinero()) {
				
				
				System.out.println(dbCuentas.retirarDinero(numeroCuentaMenu, valor));
			}
			
			if(dispensador.verificarDisponibilidadDinero()==false){
				System.out.println("El monto excede a lo disponible actualmente en el cajero");
			}
			
		}
		
	}
	
	
 
	

	
	
	
	
	

}
