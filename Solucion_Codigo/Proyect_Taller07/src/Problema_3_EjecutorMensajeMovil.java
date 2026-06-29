/**
 * Problema 3 - Sistema de envío de mensajes a móviles
* Implemente un sistema de envío de mensajes a móviles. Existen dos tipos de mensajes que se
* pueden enviar entre móviles, mensajes de texto (SMS) y mensajes que contienen imágenes (MMS).
* Por un lado, los mensajes de texto contienen un mensaje en caracteres que se desea enviar de
* un móvil a otro. Por otro lado, los mensajes que contienen imágenes almacenan información sobre
* la imagen a enviar, la cual se representará por el nombre del fichero que la contiene. Independientemente
* del tipo de mensaje, cada mensaje tendrá asociado un remitente de dicho mensaje y un destinatario. 
* Ambos estarán definidos obligatoriamente por un número de móvil, y opcionalmente se podrá guardar 
* información sobre su nombre. Además, los métodos enviarMensaje y visualizarMensaje deben estar definidos.
* 
 * @author Jorge Castillo
 * @version 1.0
 */
class Asociado{
    public String numeroMovil;
    public String nombre;

    public Asociado(String numeroMovil, String nombre) {
        this.numeroMovil = numeroMovil;
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Asociado{" + "numeroMovil=" + numeroMovil + ", nombre=" + nombre + '}';
    }
}
class MensajeMovil{
    public Asociado remitente;
    public Asociado destinatario;

    public MensajeMovil(Asociado remitente, Asociado destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }
    public void enviarMensaje(){}
    public void visualizarMensaje(){}
}
class SMS extends MensajeMovil{
    public String texto;

    public SMS(String texto, Asociado remitente, Asociado destinatario) {
        super(remitente, destinatario);
        this.texto = texto;
    }
    @Override
    public void enviarMensaje(){
        System.out.println("[SMS]Enviando texto: " + this.texto);
    }
    @Override
    public void visualizarMensaje(){
        System.out.println("****SMS****");
        System.out.println("De: " + remitente.nombre);
        System.out.println("Para: " + destinatario.nombre);
        System.out.println("Mensaje: " + this.texto);
    }
    @Override
    public String toString() {
        return "Sms{" + "texto=" + texto + '}';
    }
}
class MMS extends MensajeMovil{
    public String fichero;

    public MMS(String fichero, Asociado remitente, Asociado destinatario) {
        super(remitente, destinatario);
        this.fichero = fichero;
    }
    @Override
    public void enviarMensaje(){
        System.out.println("[MMS]Enviando imagen: " + this.fichero);
    }
    @Override
    public void visualizarMensaje(){
        System.out.println("****MMS****");
        System.out.println("De: " + remitente.nombre);
        System.out.println("Para: " + destinatario.nombre);
        System.out.println("Mensaje: " + this.fichero);
    }
    @Override
    public String toString() {
        return "Mms{" + "fichero=" + fichero + '}';
    }
}
public class Problema_3_EjecutorMensajeMovil {
    public static void main(String[] args) {
        Asociado aso1 = new Asociado("0967543489", "Diego");
        Asociado aso2 = new Asociado("0933540387", "Martin");
        
        MensajeMovil[] bandeja = new MensajeMovil[2];
        bandeja[0] = new SMS("!Messi la cabra!", aso1, aso2);
        bandeja[1] = new MMS("Messi_mundial.png", aso2, aso1);
        
        System.out.println("--- Envio de Mensajes ---");
        for (MensajeMovil msg : bandeja) {
            msg.enviarMensaje(); 
        }
        System.out.println("\n--- Visualizacion de Mensajes ---");
        for (MensajeMovil msg : bandeja) {
            msg.visualizarMensaje();
            System.out.println();
        }
    }
}
/**
 * run:
--- Envio de Mensajes ---
[SMS]Enviando texto: !Messi la cabra!
[MMS]Enviando imagen: Messi_mundial.png

--- Visualizacion de Mensajes ---
****SMS****
De: Diego
Para: Martin
Mensaje: !Messi la cabra!

****MMS****
De: Martin
Para: Diego
Mensaje: Messi_mundial.png

BUILD SUCCESSFUL (total time: 0 seconds)


 */