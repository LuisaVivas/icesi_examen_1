package Examen1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luisa Maria 
 */
public class CochesDer extends Thread{
    
    Puente puenteCarros;
    int num;
    
    public CochesDer(Puente puenteCarros, int num){
    this.puenteCarros = puenteCarros;
    this.num = num;
    }
    
    
    public void run(){
        while(true){
              try {
                puenteCarros.turnoDer();
            } catch (Exception ex) {
                Logger.getLogger(CochesDer.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempos = (int) (Math.random() * 10);
            System.out.println("CarroDer " + num + " Ingresa al puente en " + tiempos + " minutos");


            try {
                sleep(tiempos * 1000);
            } catch (InterruptedException e) {
            }

            try {
                puenteCarros.finDer();
            } catch (Exception ex) {
                Logger.getLogger(CochesDer.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("CarroDer " + num + " Sale del puente"+tiempos);

        }
            
            
        }
    }
    
    

