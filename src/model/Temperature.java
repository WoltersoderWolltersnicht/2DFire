package model;

import control.CMainWindow;

public class Temperature {
	
	public int[][] temperatureList;
	public int intensity;

	/**
	 * Temperature Constructor:
	 * @param x Width
	 * @param y Height
	 */
	public Temperature(int x, int y) {
		
		this.temperatureList = new int[x][y];
		
		inicializesTemperature();
		
		setHeatPoints();
		
		calculateTemperature();
		
	}
	
	/**
	 * Inicialices Arrays.
	 * Set all Array possitions to 0:
	 * 
	 */
	public void inicializesTemperature(){
	
		for (int x=0;x<temperatureList.length;x++) {
			for (int y=0; y<temperatureList[0].length;y++) {
				
				temperatureList[x][y]=0;
				
			}
		}
		
	}
	
	//Introduces in the botom row randomly 0 or 99: 
	public void setHeatPoints() {
		
		for (int i=0; i<temperatureList.length;i++ ) {
			
			temperatureList[i][temperatureList[0].length-1] = (Math.random() > 0.10) ? 0 : intensity ;
		
		}
	}
	
	
	/**
	 * 
	 * Calculates the average of the three below pixels 
	 * (ignores the botom row because it has no below pixels):
	 * 
	 */
	public void calculateTemperature() {
		
		int resultados;
		for (int y = temperatureList[0].length-2; y>0 ; y--) {

			for(int x =temperatureList.length-2 ; x>1; x-- ) {
				
				resultados = temperatureList[x][y];

					try {
						resultados+=temperatureList[x][y+1];
					}catch(Exception e) {}
					
					try {
						resultados+=temperatureList[x-1][y+1];
					}catch(Exception e) {}
					
					try {
						resultados+=temperatureList[x+1][y+1];
					}catch(Exception e) {}
					resultados=resultados/4;
					
					temperatureList[x][y]=(resultados>1)? resultados-1 : resultados;
			}
		}		
		
	}
	
	
	

}

