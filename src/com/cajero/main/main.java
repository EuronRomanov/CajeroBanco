package com.cajero.main;

import java.util.Scanner;


import com.cajero.cajero.AdministrarCuentas;

public class main {
	
	
	public String mostrarMenu() {
		String ans="";
		System.out.println("Menu Principal");
		System.out.println("1 - Ver mi saldo \n"+
						   "2 - Retirar efecivo \n"+
						   "3 - Depositar fondos \n"+
						   "4 - Salir");
		System.out.println("Escriba una opción: ");
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdministrarCuentas adCuentas=new AdministrarCuentas();
		  Scanner entradaEscaner = new Scanner (System.in);
		  String numeroCuenta, nip;
		  int opcionMenu=0;
		
		  
		
			
		while (adCuentas.isAutorizado()==false) {
				//authentification
				System.out.println("BIENVENIDO");
				System.out.println("Escriba su número de cuenta :");
				numeroCuenta=entradaEscaner.nextLine();
				System.out.println("Escriba su NIP :");
				nip=entradaEscaner.nextLine();
				
				adCuentas.autentificacion(numeroCuenta, nip);
				System.out.println(adCuentas.getMessageErrorAuthentication());
			
				
				if (adCuentas.isAutorizado()) {
					while (opcionMenu != 4) {
						new main().mostrarMenu();
						opcionMenu=entradaEscaner.nextInt();
						
						adCuentas.desplegarOpcionSeleccionada(opcionMenu,Integer.parseInt(numeroCuenta) );
						
					}
					
				}
			
			}
			
			

			
			
			
		

	}

}
