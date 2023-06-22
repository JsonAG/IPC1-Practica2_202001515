
package practica2;

import javax.swing.JLabel;

/**
 *
 * @author jaswl
 */
public class trayectoria extends Thread{
    private JLabel etiqueta;
    private visTrayectorias auto;
    private int velocidad;
    private int distancia;

    
    //Constructor
    public trayectoria(JLabel etiqueta, visTrayectorias auto, int velocidad, int distancia) {
        this.etiqueta = etiqueta;
        this.auto = auto;
        this.velocidad = velocidad;
        this.distancia = distancia;
    }
    
    @Override
    public void run(){
        boolean regresando = false;
        int repar1 = 0;
        int repar2 = 0;
        int repar3 = 0;
        int metaX = auto.getMeta().getLocation().x - 125;
        
         while (true){
        try{
            Thread.sleep(distancia * 100);
            int etiquetaX = etiqueta.getLocation().x;
            
            if (!regresando && etiquetaX < metaX){
                // Movimiento hacia adelante
                etiqueta.setLocation(etiquetaX + velocidad, etiqueta.getLocation().y);
            }
            else if (regresando && etiquetaX > 0){
                // Movimiento de regreso
                etiqueta.setLocation(etiquetaX - velocidad, etiqueta.getLocation().y);
            }
            
            auto.repaint();
            
            if (etiquetaX >= metaX && !regresando){
                regresando = true;
            }
            else if (etiquetaX <= 0 && regresando){
                break;
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
            }
        }
    }
  
}
