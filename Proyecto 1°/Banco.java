public class Banco {
	static int Monto;
	static int numeroUsuario;
	static int PinUser;
	static int Pin = 1234;
	static int Eleccion;
	static int posCuenta = -1;
	static String Cuenta;
	static int CuentaPin;
	static int MaxCuenta = 7;
	static String [] arrCuenta = new String [MaxCuenta];
  static int [] arrPin = new int [MaxCuenta];
  static int [] arrSaldo = new int [MaxCuenta];
  static int total = 0;
	static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) { 
        agregar("Admin",1893);
        agregar("Eduardo",4545);
        agregar("Juan",3333);
        agregar("Pedro",6373);
        agregar("Jose",1000);
        agregar("Maria",7878);
        System.out.println("|:::::::::::::::::::|");
        System.out.println("|:::::: BANCO ::::::|");
        System.out.println("|:::::::::::::::::::|");
    
    
       int op;
       do {
    	   System.out.println("     ===========");
    	   System.out.println("     |1| Login |\n     |2| Salir |");
    	   System.out.println("     ===========");
    	   op = lector.nextInt();
    	   switch(op) {
    	   case 1:
    		   InicioSesion();
    	        if(arrCuenta[0].equals(Cuenta) && arrPin[0] == CuentaPin) {
    	        	InicioSesionAdmin();
    	        }else {
    	    		if((CuentaPin+"").length() != 4)
    	    			System.out.println("-|Error, el pin ingresado|-\n-|no esta permitido|-");
    	    		else {
    	    			numeroUsuario = -1;
    	    			for(int a = 0 ; a < total; a++) { 
    	    				if(arrCuenta[a].equals(Cuenta) && arrPin[a] == CuentaPin) {
    	    					numeroUsuario = a;
    	    					break;
    	    				}
    	    			}
    	    			if(numeroUsuario != -1) {
    	    			
    	    			
    	    				if(CuentaPin == 1234) {
    	    					do {
    	    						System.out.println("-|Ingrese un nuevo Pin|-");
    	    						arrPin[numeroUsuario] = lector.nextInt();	    					
    	    					}while(arrPin[numeroUsuario] == 1234);
    	    				}

    	    			
    	    				InicioSesionUser();	
    	    			}
    	    			
    	    			}
    	        }

    		   break;
    	   case 2:
    		   System.out.println("-|Fin del programa|-");
    		   break;
    		   default:
    		   System.out.println("-|Opcion incorrecta|-");
    	   }
       }while(op != 2);

	}
//########################################################################## 
	static void agregar(String user,int Pin) {
		if(total < MaxCuenta) {
		arrCuenta[total]=user;
        arrPin[total]=Pin;
        arrSaldo[total]=0;
        total++;
	}else
			System.out.println("-|Error, se llego al maximo|-\n-|de cuentas posibles|-");
	}
//##########################################################################
	static void InicioSesion() {
   		System.out.println("-|Ingrese su nombre|-");
   		Cuenta = lector.next();
   		System.out.println("-|Ingrese su pin|-");
   		CuentaPin = lector.nextInt();
	}
//##########################################################################
	static void InicioSesionAdmin() {
do {
	    System.out.println("  ===================");	
		System.out.println("  |1| Crear Cuenta  |\r  |2| Listar        |\r  |3| Cerrar Sesion |");
	    System.out.println("  ===================");	
        Eleccion = lector.nextInt();
    	switch(Eleccion) {
		case 1:
			boolean Crear = true;
			System.out.println("-|Ingrese el nombre de la cuenta a crear|-");
			String temp = lector.next();
			for(int q = 0 ; q < total; q++) {
			System.out.println("-|Buscando...");
				if(temp.equals(arrCuenta[q])) {
				System.out.println("-|Error, Este nombre de usuario ya existe|-");
				Crear = false;
				break;
			}
			}
			if(Crear) 
				agregar(temp,1234);
			break;
		case 2:
			for(int b = 0 ; b < total; b++) {
			System.out.println("|> " + arrCuenta[b] +" || "+ arrPin[b]);
			}
    		break;
		case 3:
			break;
		default:
			System.out.println("-|Esa opcion no esta disponible|-");
			
			}
    	
}while(Eleccion != 3);
System.out.println("Fin");
	}
//##########################################################################
	static void InicioSesionUser() {
do {
				System.out.println("============================");
				System.out.println("          Bienvenido\r|1| Ver saldo de la cuenta |\r|2| Cargar Saldo           |\r|3| Retirar Saldo          |\r|4| Cambiar Pin            |\r|5| Cerrar Sesion          |");   
				System.out.println("============================");
		Eleccion = lector.nextInt();
		switch(Eleccion) {
		case 1:
				System.out.println("-|Su saldo actual es de:\n | " + arrSaldo[numeroUsuario]);
			break;
		case 2:
			do {
			System.out.println("-|Ingrese el monto que desea cargar|-");
		      Monto = lector.nextInt();
		      if(Monto % 100 == 0) 
		    	  arrSaldo[numeroUsuario] =+Monto ;
		      else
		    	  System.out.println("-|La cantidad ingresada no esta permitida|-");
		      }while(Monto %100 != 0);  
		      break;                                                                                                                                                                                
		case 3:
			do {
			System.out.println("-|Ingrese el monto que desea retirar|-");
		      Monto = lector.nextInt();
		      if(Monto % 100 == 0) {
		    	  if((arrSaldo[numeroUsuario] - Monto) == (-arrSaldo[numeroUsuario]))
		    		  System.out.println("-|Dinero insuficiente|-");
		    	  else
		    		  arrSaldo[numeroUsuario] -=Monto;
		      }else
		    	  System.out.println("-|La cantidad ingresada no esta permitida|-");
		      }while(Monto %100 != 0);  
		      break;
		case 4:
  		  System.out.println("-|Ingrese el Pin actual|-");
  		  PinUser = lector.nextInt();
  		  if(PinUser == arrPin[numeroUsuario]) {
    		  System.out.println("-|Ingrese el nuevo Pin|-");
  		  		arrPin[numeroUsuario]= lector.nextInt();
		}else
  		  		  System.out.println("-|El Pin ingresado no es correcto|-");
			break;
		case 5:
			break;
    default:
    	System.out.println("-|Esa opcion no esta disponible-|");
    	}
}while(Eleccion != 5);
System.out.println("-|Fin|-");
		}
    	
	
}
