package com.cajero.cajero;

public class DBCuentas {
final Cuenta [] cuentas=new Cuenta[4];

	
	public DBCuentas() {
		Cuenta cuenta1=new Cuenta(12212, 23232, 2323);
		Cuenta cuenta2=new Cuenta(22212, 43232, 0.23);
		Cuenta cuenta3=new Cuenta(32212, 53232, 13.23);
		Cuenta cuenta4=new Cuenta(42212, 63232, 100.23);
				
		cuentas[0]=cuenta1;
		cuentas[1]=cuenta2;
		cuentas[2]=cuenta3;
		cuentas[3]=cuenta4;
		
	}
	
	public Cuenta [] cargarDatos() {
		
	      return cuentas;
	}
	
	public boolean buscarCuenta(int cuenta) {
		boolean existe=false;
		 /*  for (Cuenta cuentaObject : this.cuentas) {
			   System.out.println(this.cuentas.length);
			if (cuentaObject.getNumeroCuenta()==cuenta) {
				existe=true;
			}
		}*/
		   
		   
		   for (int i = 0; i < cuentas.length; i++) {
			   if (cuentas[i].getNumeroCuenta()==cuenta) {
					existe=true;
				}
		}
		
		return existe;
	}
	
	
	public boolean buscarNIP( int nip) {
		boolean existe=false;
		/*   for (Cuenta cuentaObject : this.cuentas) {
			if (cuentaObject.getNIP()==nip) {
				existe=true;
			}
		}*/
		
		for (int i = 0; i < cuentas.length; i++) {
			
			if (cuentas[i].getNIP()==nip) {
				existe=true;
			}
		}
		return existe;
	}
	
	
	public String consultarSaldo(int numerocuenta) {
		String saldo="";
		 for (int i = 0; i < cuentas.length; i++) {
			   if (cuentas[i].getNumeroCuenta()==numerocuenta) {
					saldo="Número de cuenta: "+numerocuenta+"\n Saldo Actual :" +  Math.round(cuentas[i].getSaldo()*100.0)/100.0;
				}
		}
		return saldo;
	}
	
	
	public String retirarDinero(int numerocuenta, int indice) {
		String saldo="";
		int [] valores= {0,20,40,60,100,200};
		 for (int i = 0; i < cuentas.length; i++) {
			   if (cuentas[i].getNumeroCuenta()==numerocuenta) {
					if (valores[indice]<=cuentas[i].getSaldo()) {
						double result=cuentas[i].getSaldo()-valores[indice];
						
						cuentas[i].setSaldo(Math.round(result*100.0)/100.0);
						saldo="Por favor retire el dinero";
					} else {
						saldo="Saldo insuficieente prueba con un monto menor";
					}
				}
		}
		return saldo;
	}
	
	
	
	public String agregarDinero(int numerocuenta, int valor) {
		String saldo="";
		Double monto=Double.valueOf(valor)/100;
		 for (int i = 0; i < cuentas.length; i++) {
			   if (cuentas[i].getNumeroCuenta()==numerocuenta) {
				   cuentas[i].setSaldo(cuentas[i].getSaldo()+monto);
					saldo="Saldo agregado con exito";
				}
		}
		return saldo;
	}
	
	
	
}
