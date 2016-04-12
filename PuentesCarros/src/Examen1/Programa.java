package Examen1;

/**
 *
 * @author Luisa Maria Vivas
 */
public class Programa {
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
       Puente puente = new Puente();
       
       for (int i = 1; i < 12; i++) {
           CochesIzq carroI = new CochesIzq(puente,i);
           carroI.start();
       }
      
       for (int i = 1; i < 12; i++) {
           CochesDer carroD = new CochesDer(puente, i);
           carroD.start();
       }
       
    }
}
