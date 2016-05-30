/*Jeu des six couleurs- liste des couleurs disponibles
 * @package model
 * @author Alexis DAHAN
 * @author Nicolas DELTHEIL
 * 2016
 */package model;
import edu.princeton.cs.introcs.StdDraw;
public class Colour {
	private int id;
	private Player p;

	public Colour(int id){
		this.id=id;
		this.p=null;
	}

	public void defColour(){
		if (this.id==1){
			StdDraw.setPenColor(StdDraw.RED);
		}
		if (this.id==2){
			StdDraw.setPenColor(StdDraw.ORANGE);
		}
		if (this.id==3){
			StdDraw.setPenColor(StdDraw.YELLOW);
		}
		if (this.id==4){
			StdDraw.setPenColor(StdDraw.GREEN);
		}
		if (this.id==5){
			StdDraw.setPenColor(StdDraw.BLUE);
		}
		if (this.id==6){
			StdDraw.setPenColor(StdDraw.CYAN);
		}
	}
	public Player getjcolor(){
		return this.p;
	}
	public void setjcolor(Player p){
		this.p=p;
	}
}
