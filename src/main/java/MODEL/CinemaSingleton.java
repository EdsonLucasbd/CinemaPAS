/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author lucas
 */
public class CinemaSingleton {

	private static CinemaSingleton cinemaSingleton;
        
	private Cinema cinema;        
        
	private CinemaSingleton() {
	}
	
	public static CinemaSingleton getInstancia() {
		if (cinemaSingleton == null) {
			cinemaSingleton = new CinemaSingleton();
		}
		return cinemaSingleton;
	}
        
        public void setCinema(String endereco, String nomeShopping){
            cinema.setEndereco(endereco);
            cinema.setNomeShopping(nomeShopping);
        }

	public Cinema getCinema() {
		return cinema;
	}

    
}
