package code.Fractals;

public class Mandelbrot extends Fractal{
	
	public Mandelbrot(){
		this(512, 512);
	}
	
	public Mandelbrot(int rows, int cols){
		super(rows, cols, 0.6, -2.15, 1.30000000000000, -1.3);
	}

	@Override
	public int calculate(double xCalc, double yCalc) {
		double tX, tY, tmp, dist;
		tX = xCalc;
		tY = yCalc;
		
		
		int passes = 0; // Start passes at -1 because it passes once by default
		
		dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc); // (0,0) has a distance of 0 from (0,0)
		
		while(dist < this.getEscapeDistance() && passes < this.getMaxEscapes()){
			tmp = tX*tX - tY*tY + xCalc; // TEMP X: x' = x^2 - y^2 + (original x value)
			tY = 2.0 * tX * tY + yCalc; // y' = 2xy + (original y value)
			tX = tmp; // set X to TEMP X
			dist = Math.sqrt(tX*tX + tY*tY); // recalculate distance
			passes++; // add a pass
		}
		return passes;
	}
}
