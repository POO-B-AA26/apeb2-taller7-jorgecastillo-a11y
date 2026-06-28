/**
 * Problema 5 - Venta de entradas al teatro
Dadas las siguientes clases, que expresan una relación de herencia entre las entidades:
Se desea gestionar la venta de entradas para un espectáculo en un teatro. El patio de butacas del t
* eatro se divide en varias zonas, cada una identificada por su nombre. Los datos de las zonas son los mostrados en la siguiente tabla:

NOMBRE ZONA	NÚMERO DE LOCALIDADES	PRECIO NORMA	PRECIO ABONADO
Principal	200	25$	17.5$
PalcoB	40	70$	40$
Central	400	20$	14$
Lateral	100	15.5$	10$
Para realizar la compra de una entrada, un espectador debe indicar la zona que desea y presentar al vend
* edor el documento que justifique que tiene algún tipo de descuento (estudiante, abonado o pensionista). 
* El vendedor sacará la entrada del tipo apropiado y de la zona indicada, en el momento de la compra se asignará 
* a la entrada un identificador (un número entero) que permitirá la identificación de la entrada en todas las operaciones 
* que posteriormente se desee realizar con ella.

Una entrada tiene como datos asociados su identificador, la zona a la que pertenece y el nombre del comprador.
Los precios de las entradas dependen de la zona y del tipo de entrada según lo explicado a continuación:
Entradas normales: su precio es el precio normal de la zona elegida sin ningún tipo de descuento.
Entradas reducidas (para estudiantes o pensionistas): su precio tiene una rebaja del 15% sobre el precio normal de la zona elegida.
Entradas abonado: su precio es el precio para abonados de la zona elegida.
La interacción entre el vendedor y la aplicación es la descrita en los siguientes casos de usos.
 * @author Jorge Castillo
 * @version 1.0
 */

class Zona{
    public String nombreZona;
    public int cantidadLocalidades;
    public double precioNormal, precioAbonado;

    public Zona(String nombreZona, int cantidadLocalidades, double precioNormal, double precioAbonado) {
        this.nombreZona = nombreZona;
        this.cantidadLocalidades = cantidadLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombreZona=" + nombreZona + ", cantidadLocalidades=" + cantidadLocalidades + 
                ", precioNormal=" + precioNormal + ", precioAbonado=" + precioAbonado + '}';
    }
}

class Entrada{
    public int id, cantidadEnt;
    public String nombreComprador;
    public Zona zona;
    public double costoEnt;

    public Entrada(int id, int cantidadEnt, String nombreComprador, Zona zona) {
        this.id = id;
        this.cantidadEnt = cantidadEnt;
        this.nombreComprador = nombreComprador;
        this.zona = zona;
        this.costoEnt = costoEnt;
    }
    
    public double calcularCostoEntrada(double precioEntrada){
        this.costoEnt = this.cantidadEnt* precioEntrada;
        return this.costoEnt;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", cantidadEnt=" + cantidadEnt + 
                ", nombreComprador=" + nombreComprador + ", zona=" + zona + ", costoEnt=" + costoEnt + '}';
    }
    
}

class Entrada_Normal extends Entrada{

    public Entrada_Normal(int id, int cantidadEnt, String nombreComprador, Zona zona) {
        super(id, cantidadEnt, nombreComprador, zona);
    }
    
    public double calcularCostoEntrada(){
        this.costoEnt = super.calcularCostoEntrada(this.zona.precioNormal);
        return this.costoEnt;
    }
}

class Entrada_Reducida extends Entrada{

    public Entrada_Reducida(double porcentajeRebaja, int id, int cantidadEnt, String nombreComprador, Zona zona) {
        super(id, cantidadEnt, nombreComprador, zona);
        this.porcentajeRebaja = porcentajeRebaja;
    }
    
    public double porcentajeRebaja;
    public double calcularCostoEntrada(){
        this.costoEnt = super.calcularCostoEntrada(this.zona.precioNormal - (this.zona.precioNormal * (this.porcentajeRebaja/100)));
        return this.costoEnt;
    }

    @Override
    public String toString() {
        return "Entrada_Reducida{" + "porcentajeRebaja=" + porcentajeRebaja + '}' + super.toString();
    }
    
}

class Entrada_Abonado extends Entrada{

    public Entrada_Abonado(int id, int cantidadEnt, String nombreComprador, Zona zona) {
        super(id, cantidadEnt, nombreComprador, zona);
    }
    
    public double calcularCostoEntrada(){
        this.costoEnt = super.calcularCostoEntrada(this.zona.precioAbonado);
        return this.costoEnt;
    }
}

public class Problema_5_EjecutorEntrada {
    public static void main(String[] args) {
        Zona zona1 = new Zona("Principal", 200, 25, 17.5);
        Zona zona2 = new Zona("PalcoB", 40, 70, 40);
        Zona zona3 = new Zona("Central", 400, 20, 14);
        Zona zona4 = new Zona("Lateral", 100, 15.5, 10);
        
        Entrada_Normal e1= new Entrada_Normal(1, 2, "Daniel", zona1);
        Entrada_Reducida r1 = new Entrada_Reducida(15, 2, 1, "Gaby", zona2);
        Entrada_Abonado ab1 = new Entrada_Abonado(3, 1, "Alyson", zona4);
        
        e1.calcularCostoEntrada();
        r1.calcularCostoEntrada();
        ab1.calcularCostoEntrada();
        
        System.out.println(e1);
        System.out.println(r1);
        System.out.println(ab1);
    }
}
