
package Examen1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Lusia MAria
 */
public class Puente {

	int cantidad;
	int numCochesDer;
	int numCochesIzq;

	Semaphore semaforoDer;
	Semaphore semaforoIzq;
	
	Semaphore mutexD;
	Semaphore mutexI;

	Semaphore puente;
	Semaphore mucantidad;


	public Puente() {

		numCochesIzq = 0;
		numCochesDer = 0;
		mutexD = new Semaphore(1, true);
		mutexI = new Semaphore(1, true);
		semaforoDer = new Semaphore(10, true);
		semaforoIzq = new Semaphore(10, true);
		puente = new Semaphore(1, true);
		mucantidad = new Semaphore(10, true);
	}

	public void turnoDer() throws Exception {
		semaforoIzq.acquire();
		semaforoDer.acquire();
		mutexD.acquire();
		numCochesDer = numCochesDer + 1;
		if (numCochesDer == 1) {
			puente.acquire();
		}
		mucantidad.acquire();
		mutexD.release();
		semaforoDer.release();

	}

	public void turnoIzqu() throws Exception {
		semaforoDer.acquire();
		semaforoIzq.acquire();
		mutexI.acquire();
		numCochesIzq = numCochesIzq + 1;
		if (numCochesIzq == 1) {
			puente.acquire();
		}
		mucantidad.acquire();
		mutexI.release();
		semaforoIzq.release();

	}

	public void finIzqu() throws Exception {
		mutexI.acquire();
		numCochesIzq = numCochesIzq - 1;
		semaforoDer.release();
		mucantidad.release();
		mutexI.release();
		if (numCochesIzq == 0) {
			puente.release();

		}
	}

	public void finDer() throws Exception {
		mutexD.acquire();
		numCochesDer = numCochesDer - 1;
		semaforoIzq.release();
		mucantidad.release();
		mutexD.release();
		if (numCochesDer == 0) {
			puente.release();

		}
	}

}
