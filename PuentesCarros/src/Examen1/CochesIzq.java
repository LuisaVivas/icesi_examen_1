package Examen1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luisa Maria
 */
public class CochesIzq  extends Thread{
    
     Puente puenteCarros;
    int num;
    
    public CochesIzq(Puente puenteCarros, int num){
    this.puenteCarros = puenteCarros;
    this.num = num;
    }
    
    
     public void run(){
        while(true){
              try {
                puenteCarros.turnoIzqu();
            } catch (Exception ex) {
                Logger.getLogger(CochesIzq.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempos = (int) (Math.random() * 10);
            System.out.println("CarroIzq " + num + " Ingresa al puente en " + tiempos + " minutos");


            try {
                sleep(tiempos * 1000);
            } catch (InterruptedException e) {
            }

            try {
                puenteCarros.finIzqu();
            } catch (Exception ex) {
                Logger.getLogger(CochesIzq.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("CarroIzq " + num + " Sale del puente"+tiempos);

        }
            
            
        }
    
    
}
