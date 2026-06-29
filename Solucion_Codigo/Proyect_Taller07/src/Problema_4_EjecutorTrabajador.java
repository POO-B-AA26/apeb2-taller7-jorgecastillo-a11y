/**
 * Problema 4 - Sistema de nómina para trabajadores
 * Se desea desarrollar un sistema de nómina para los trabajadores de una empresa.
 * Los datos personales de los trabajadores son nombre y apellidos, dirección y DNI. 
 * Además, existen diferentes tipos de trabajadores:
 * Fijos Mensuales: que cobran una cantidad fija al mes.
 * Comisionistas: cobran un porcentaje fijo por las ventas que han realizado
 * Por Horas: cobran un precio por cada una de las horas que han realizado durante el mes. 
 * El precio es fijo para las primeras 40 horas y es otro para las horas realizadas a partir de la 40 hora mensual.
 * Jefe: cobra un sueldo fijo (no hay que calcularlo). Cada empleado tiene obligatoriamente 
 * un jefe (exceptuando los jefes que no tienen ninguno). El programa debe permitir dar de alta 
 * a trabajadores, así como fijar horas o ventas realizadas e imprimir la nómina correspondiente al final de mes.
 * 
 * @author Jorge Castillo
 * @version 1.0
 */
class Trabajador{
    public String nombre;
    public String apellido;
    public String direccion;
    public String dni;
    public Jefe jefe;

    public Trabajador(String nombre, String apellido, String direccion, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
    }
    public void altaTrabajador(Jefe jefe){
        this.jefe = jefe;
    }
    public double calcularNomina(){
        return 0.0;
    }
    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellido=" + apellido + 
                ", direccion=" + direccion + ", dni=" + dni + '}';
    }
}
class Jefe extends Trabajador{
    public double sueldo;

    public Jefe(double sueldo, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        return "Jefe{" + "sueldo=" + sueldo + '}'+ super.toString();
    }
}
class FijosMensuales extends Trabajador{
    public double pagoMensual;

    public FijosMensuales(double pagoMensual, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.pagoMensual = pagoMensual;
    }
    @Override
    public double calcularNomina(){
        return this.pagoMensual;
    }
    @Override
    public String toString() {
        return "FijosMensuales{" + "pagoMensual=" + pagoMensual + '}'+ super.toString();
    }
}
class Comisionista extends Trabajador{
    public int ventas;
    public double porcentajeComision;

    public Comisionista(double porcentajeComision, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.porcentajeComision = porcentajeComision;
    }
    public void fijarVentas(int ventas) {
        this.ventas = ventas;
    }
    @Override
    public double calcularNomina() {
        return ventas * porcentajeComision;
    }
    @Override
    public String toString() {
        return "Comisionistas{" + "ventas=" + ventas + 
                ", porcentajeComision=" + porcentajeComision + '}'+ super.toString();
    }
}
class PorHora extends Trabajador{
    public double horas;
    public double precioNormal;
    public double precioHoraExtra;

    public PorHora(double precioNormal, double precioHoraExtra, 
            String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.precioNormal = precioNormal;
        this.precioHoraExtra = precioHoraExtra;
    }
    public void fijarHoras(double horas) {
        this.horas = horas;
    }
    @Override
    public double calcularNomina() {
        if (horas > 40) {
            double extras = horas - 40;
            return (40 * precioNormal) + (extras * precioHoraExtra);
        } else {
            return horas * precioNormal;
        }
    }
    @Override
    public String toString() {
        return "PorHoras{" + "horas=" + horas + ", precioNormal=" + precioNormal + 
                ", precioHoraExtra=" + precioHoraExtra + '}'+ super.toString();
    }
}
public class Problema_4_EjecutorTrabajador {
    public static void main(String[] args) {
        Jefe jefe1 = new Jefe(1500, "Luis", "Cordoba", "Cuenca", "0348897890");
        FijosMensuales emp1 = new FijosMensuales(500, "Liss", "Gonzales", "Zamora", "1986749952");
        PorHora emp2 = new PorHora(20, 10, "Margarita", "Fernandez", "Loja", "1901433643");
        Comisionista emp3 = new Comisionista(20, "Xavier", "Muñoz", "Yantzaza", "0185399732");
        
        emp2.fijarHoras(50);
        emp3.fijarVentas(88);
        
        emp1.altaTrabajador(jefe1);
        emp2.altaTrabajador(jefe1);
        emp3.altaTrabajador(jefe1);
        
        System.out.println("****** NOMINAS GENERAL DE FIN DE MES ******");
        System.out.println(jefe1.toString());
        System.out.println("--------------------------------------------------");
        System.out.println(emp1.toString());
        System.out.println("Sueldo Total: "+emp1.calcularNomina());
        System.out.println("--------------------------------------------------");
        System.out.println(emp2.toString());
        System.out.println("Sueldo Total: "+emp2.calcularNomina());
        System.out.println("--------------------------------------------------");
        System.out.println(emp3.toString());
        System.out.println("Sueldo Total: "+emp3.calcularNomina());
        System.out.println("--------------------------------------------------");
    }
}
/**
 run:
****** NOMINAS GENERAL DE FIN DE MES ******
Jefe{sueldo=1500.0}Trabajador{nombre=Luis, apellido=Cordoba, direccion=Cuenca, dni=0348897890}
--------------------------------------------------
FijosMensuales{pagoMensual=500.0}Trabajador{nombre=Liss, apellido=Gonzales, direccion=Zamora, dni=1986749952}
Sueldo Total: 500.0
--------------------------------------------------
PorHoras{horas=50.0, precioNormal=20.0, precioHoraExtra=10.0}Trabajador{nombre=Margarita, apellido=Fernandez, direccion=Loja, dni=1901433643}
Sueldo Total: 900.0
--------------------------------------------------
Comisionistas{ventas=88, porcentajeComision=20.0}Trabajador{nombre=Xavier, apellido=Mu�oz, direccion=Yantzaza, dni=0185399732}
Sueldo Total: 1760.0
--------------------------------------------------
BUILD SUCCESSFUL (total time: 0 seconds)


 */