/*Jeu des six couleurs- Vue
 * @package view
 * @author Alexis DAHAN
 * @author Nicolas DELTHEIL
 * 2016
 */
package view;
import edu.princeton.cs.introcs.StdDraw;
import model.Colour;
import model.Player;
public class View {
	// voir le type de classe pour la case
	public class Case {
		private double x;
		private double y;
		private Colour c;
		private Player j;
		public Case(double x,double y,Colour c){
			this.x=x;
			this.y=y;
			this.c=c;
			j=null;
		}
		public void displayCase(){
			c.defColour();
			StdDraw.filledSquare(x, y, 0.5);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.square(x, y, 0.5);
		}
		public void setj(Player j){
			this.j=j;
		}
		public void setcolor(Colour c){
			this.c=c;
		}
		public Player getjcase(){
			return this.j;
		}
		public Colour getcasecolor(){
			return this.c;
		}
		}
// voir le type de classe pour les boutons
	public class Button {
		private Colour c;

		public Button(Colour c){
			this.c=c;
		}
		
		public void displayButton(double x, double y){
			if(this.c.getjcolor()==null){
			c.defColour();}
			else{StdDraw.setPenColor(StdDraw.WHITE);}
			StdDraw.filledSquare(x, y, 1);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.square(x, y, 1);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(0.5, y , "RED");
			StdDraw.text(2.5, y , "ORANGE");
			StdDraw.text(4.5, y , "YELLOW");
			StdDraw.text(6.5, y , "GREEN");
			StdDraw.text(8.5, y , "BLUE");
			StdDraw.text(10.5, y , "CYAN");
			
		}
	}

}
