/**
 * Problema 6 - Sistema Un Banco
 * El banco UN BANCO mantiene las cuentas de varios clientes. Los datos que describen a 
 * cada una de las cuentas consisten en el número de cuenta, el nombre del cliente y el 
 * balance actual. Escriba una clase para implementar dicha cuenta bancaria. El método constructor
 * debe aceptar como parámetros el número de cuenta y el nombre. Debe proporcionarse métodos para 
 * depositar o retirar una cantidad de dinero y obtener el balance actual.
 * El banco ofrece a sus clientes dos tipos de cuentas, una de CHEQUES y una de AHORROS. Una cuenta 
 * de cheques puede sobregirarse (el balance puede ser menor que cero), pero una cuenta de ahorros no.
 * Al final de cada mes, se calcula el interés sobre la cantidad que tenga la cuenta de ahorros. 
 * Este interés se suma al balance. Escriba clases para describir cada uno de estos tipos de cuentas, 
 * haciendo un máximo uso de la herencia. La clase de la cuenta de ahorros debe proporcionar un método que
 * sea invocado para calcular el interés. Además, el banco está pensando en implementar una cuenta PLATINO 
 * que viene siendo similar a los otros dos tipos anteriores de cuentas bancarias, ésta tiene el interés del
 * 10%, sin cargos ni castigos por sobregiro.
 * 
 * @author Jorge Castillo
 * @version 1.0
 */

class Cuenta{
    public String nombreCliente;
    public String numeroCuenta;
    public double balanceActual;

    public Cuenta(String nombreCliente, String numeroCuenta) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
    }
    public void depositarDinero(double cantidad){
        this.balanceActual += cantidad;
    }
    public void retirarDinero(double cantidad){
        this.balanceActual -= cantidad;
    }
    @Override
    public String toString() {
        return "Cuentas{" + "nombreCliente=" + nombreCliente + 
                ", numeroCuenta=" + numeroCuenta + ", balanceActual=" + balanceActual + '}';
    }
}
class Cheques extends Cuenta{

    public Cheques(String nombreCliente, String numeroCuenta) {
        super(nombreCliente, numeroCuenta);
    }
    @Override
    public void retirarDinero(double cantidad){
        super.retirarDinero(cantidad);
        System.out.println("[CUENTA DE CUEQUES]: Retiro exitoso de " + cantidad +" $");
    }
    @Override
    public String toString() {
        return "Cheques{" + '}'+ super.toString();
    }
}
class Ahorro extends Cuenta{
    public double porcentajeInteres;

    public Ahorro(double porcentajeInteres, String nombreCliente, String numeroCuenta) {
        super(nombreCliente, numeroCuenta);
        this.porcentajeInteres = porcentajeInteres;
    }
    public void calcularInteres(){
        double interes = this.balanceActual * (this.porcentajeInteres / 100.0); 
        this.balanceActual += interes;
    }
    @Override
    public void retirarDinero(double cantidad){
        if(this.balanceActual >= cantidad){
            super.retirarDinero(cantidad);
            System.out.println("[CUENTA DE AHORRO]: Retiro exitoso de " + cantidad +" $");
        }else{
            System.out.println("ERROR Fondos insuficientes.No se permite sobregiro."); 
        }
    }
    @Override
    public String toString() {
        return "Ahorros{" + "porcentajeInteres=" + porcentajeInteres + '}'+super.toString();
    }
}
class Platino extends Cuenta{
    public double porcentajeInteres;

    public Platino(double porcentajeInteres, String nombreCliente, String numeroCuenta) {
        super(nombreCliente, numeroCuenta);
        this.porcentajeInteres = porcentajeInteres;
    }
    public void calcularInteres(){
        double interes = this.balanceActual * (this.porcentajeInteres / 100.0); // Aquí se hace la conversión
        this.balanceActual += interes;
    }
    @Override
    public void retirarDinero(double cantidad){
        super.retirarDinero(cantidad);
        System.out.println("[CUENTA PLATINO]: Retiro exitoso de " + cantidad +" $");
    }
    @Override
    public String toString() {
        return "Platino{" + "porcentajeInteres=" + porcentajeInteres + '}'+super.toString();
    }  
}

public class Problema_6_EjecutorCuenta {
    public static void main(String[] args) {
        Cheques cuenta1 = new Cheques("Julian Martinez", "1983745552");
        Ahorro cuenta2 = new Ahorro(5, "Diego Muñoz", "09877124993");
        Platino cuenta3 = new Platino(10, "Maria Gonzales", "1994592542");
        
        System.out.println("***** ESTADO DE CUENTAS *****");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
        
        System.out.println("\n***** MOVIMIENTOS BANCARIOS *****");
        cuenta1.depositarDinero(170.0);
        cuenta1.retirarDinero(120.0); 
        cuenta2.depositarDinero(500.0);
        cuenta2.retirarDinero(250.0);
        cuenta3.depositarDinero(400.0);
        cuenta3.retirarDinero(100.0);
        
        cuenta2.calcularInteres();
        cuenta3.calcularInteres();
        
        System.out.println("\n***** ESTADO DE CUENTAS (REPORTE) *****");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
    }
}
/**
 run:
***** ESTADO DE CUENTAS *****
Cheques{}Cuentas{nombreCliente=Julian Martinez, numeroCuenta=1983745552, balanceActual=0.0}
Ahorros{porcentajeInteres=5.0}Cuentas{nombreCliente=Diego Mu�oz, numeroCuenta=09877124993, balanceActual=0.0}
Platino{porcentajeInteres=10.0}Cuentas{nombreCliente=Maria Gonzales, numeroCuenta=1994592542, balanceActual=0.0}

***** MOVIMIENTOS BANCARIOS *****
[CUENTA DE CUEQUES]: Retiro exitoso de 120.0 $
[CUENTA DE AHORRO]: Retiro exitoso de 250.0 $
[CUENTA PLATINO]: Retiro exitoso de 100.0 $

***** ESTADO DE CUENTAS (REPORTE) *****
Cheques{}Cuentas{nombreCliente=Julian Martinez, numeroCuenta=1983745552, balanceActual=50.0}
Ahorros{porcentajeInteres=5.0}Cuentas{nombreCliente=Diego Mu�oz, numeroCuenta=09877124993, balanceActual=262.5}
Platino{porcentajeInteres=10.0}Cuentas{nombreCliente=Maria Gonzales, numeroCuenta=1994592542, balanceActual=330.0}
BUILD SUCCESSFUL (total time: 0 seconds)


 */