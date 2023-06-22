
package practica2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author jaswl
 */
public class Pedido implements Serializable {
    String repartidor;
    int recorrido;
    int monto;
    LocalDateTime fechaInicio;
    LocalDateTime fechaEntrega;

    public Pedido(String repartidor, int recorrido, int monto, LocalDateTime fechaInicio) {
        this.repartidor = repartidor;
        this.recorrido = recorrido;
        this.monto = monto;
        this.fechaInicio = fechaInicio;

    }

    
    
    
    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public int getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
         
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    public String getFormattedDate(){
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String fechaHoraFormateada = this.fechaInicio.format(formato);
            return fechaHoraFormateada;
    }
    
    public String getFormattedDateEntrega(){
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String fechaHoraFormateada = this.fechaEntrega.format(formato);
            return fechaHoraFormateada;
    }
    
}
