/*Jeu des six couleurs- Plateau
 * @package model
 * @author Alexis DAHAN
 * @author Nicolas DELTHEIL
 * 2016
 */
package model;

import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;
import view.View;
import view.View.Case;
import model.Colour;
public class Tray {
	private Case[][] p;
	private View view=new View();
	private int l;
	private  Colour RED=new Colour(1);
	private  Colour ORANGE=new Colour(2);
	private  Colour YELLOW=new Colour(3);
	private  Colour GREEN=new Colour(4);
	private  Colour BLUE=new Colour(5);
	private  Colour CYAN=new Colour(6);
	
	private view.View.Button buttonRed=view.new Button(RED);
	private view.View.Button buttonOrange=view.new Button(ORANGE);
	private view.View.Button buttonYellow=view.new Button(YELLOW);
	private view.View.Button buttonGreen=view.new Button(GREEN);
	private view.View.Button buttonBlue=view.new Button(BLUE);
	private view.View.Button buttonCyan=view.new Button(CYAN);

	public Tray(int l){
		this.l=l;
		this.p=new Case[l][l];
	}
	public Colour random(){
		int r=(int)(6*(Math.random()));
		Colour c=this .RED;
		switch(r){
		case 0:
		c=this.RED;
		break;
		case 1:
			c=this.ORANGE;
			break;
		case 2:
			c=this.YELLOW;
			break;
		case 3:
			c=this.GREEN;
			break;
		case 4:
			c=this.BLUE;
			break;
		case 5:
			c=this.CYAN;
			break;
		case 6:
			c=this.CYAN;
			break;
		}
		return(c);
			
	}

	public void defTray(){
		View view=new View();
		for(int i=0;i<l;i++){
			for(int j=0;j<l;j++){
				Colour c=random();
				p[i][j]=view.new Case(i,j,c);
		}
	}
	}

	public void displayTray(Player[] play){
		StdDraw.clear();
		for(int i=0;i<l;i++){
			for(int j=0;j<l;j++){
				p[i][j].displayCase();
			}
		}
		if(play!=null){
			StdDraw.setFont(new Font("arial", Font.BOLD,20));
			StdDraw.text(this.l+1,this.l-2,  "Live Score:");
		for(int t=0;t<play.length;++t){
			if(play[t]!=null){
				this.p[play[t].getx0()][play[t].gety0()].getcasecolor().defColour();
			
			StdDraw.text(this.l+1,this.l-2-2*t-5,play[t].getname());
			StdDraw.text(this.l+1,this.l-3-2*t-5,Integer.toString(play[t].getscore()));
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.square(l, t, l+1);
		}}}
		if(play!=null && play[play.length-1]!=null){
		buttonRed.displayButton(0.5, -1.5);
		buttonOrange.displayButton(2.5, -1.5);
		buttonYellow.displayButton(4.5, -1.5);
		buttonGreen.displayButton(6.5, -1.5);
		buttonBlue.displayButton(8.5, -1.5);
		buttonCyan.displayButton(10.5, -1.5);}
	}
	public void possessCase(int x,int y){
		int neighbour=0;
	if(p[x][y].getcasecolor().getjcolor()!=null && p[x][y].getjcase()==null){
		if(y>0 &&(p[x][y].getcasecolor()==p[x][y-1].getcasecolor()) && p[x][y-1].getjcase()!=null){
			p[x][y].setj(p[x][y-1].getjcase());
			neighbour=1;
		}
		if(y<this.l-1 &&(p[x][y].getcasecolor()==p[x][y+1].getcasecolor()) && p[x][y+1].getjcase()!=null){
			p[x][y].setj(p[x][y+1].getjcase());
			neighbour=1;
		}
		if(x>0 &&(p[x][y].getcasecolor()==p[x-1][y].getcasecolor()) && p[x-1][y].getjcase()!=null){
			p[x][y].setj(p[x-1][y].getjcase());
			neighbour=1;
		}
		if(x<this.l-1 &&(p[x][y].getcasecolor()==p[x+1][y].getcasecolor()) && p[x+1][y].getjcase()!=null){
			p[x][y].setj(p[x+1][y].getjcase());
			neighbour=1;
		}
		if(neighbour==1){
			p[x][y].getcasecolor().getjcolor().setscore(p[x][y].getcasecolor().getjcolor().getscore()+1);

		}
	}	
	}
	public int neighbourCase(int i,int j){
		if(p[i][j].getcasecolor().getjcolor()==null){
			//if((i<1 ||p[i-1][j].getcasecolor()!=p[i][j].getcasecolor())&& (j<1||p[i][j-1].getcasecolor()!=p[i][j].getcasecolor()) ){
			//return 1;	
			//}
			if(i>0 && p[i-1][j].getcasecolor()==p[i][j].getcasecolor()&& (j<1 ||p[i][j-1].getcasecolor()!=p[i][j].getcasecolor()) ){
				return 1+neighbourCase(i-1,j);	
				}
			if((i<1 ||p[i-1][j].getcasecolor()!=p[i][j].getcasecolor())&& j>0 && p[i][j-1].getcasecolor()==p[i][j].getcasecolor()) {
				return 1+neighbourCase(i,j-1);	
				}
			if(i>0 && p[i-1][j].getcasecolor()==p[i][j].getcasecolor()&&j>0 && p[i][j-1].getcasecolor()==p[i][j].getcasecolor()){
				return 1+neighbourCase(i-1,j)+neighbourCase(i,j-1);	
			}
			else{return 1;}
		}
		else{return 0;}
	}
	public int[] caseDepIa(){
		int score=0;
		int x=0;
		int y=0;
		for(int i=0;i<this.l;++i){
			for(int j=0;j<this.l;++j){
				int provi=Math.max(score, neighbourCase(i,j));
				if(provi>score){
					x=i;
					y=j;
					score=provi;
				}
			}
		}
		int[] tab={x,y};
		return tab;
	}
	public Case[][] getp(){
		return this.p;
	}
	public int getl(){
		return l;
	}
	public Colour getrouge(){
		return RED;
	}
	public Colour getorange(){
		return ORANGE;
	}
	public Colour getjaune(){
		return YELLOW;
	}
	public Colour getvert(){
		return GREEN;
	}
	public Colour getbleu(){
		return BLUE;
	}
	public Colour getcyan(){
		return CYAN;
	}

}
