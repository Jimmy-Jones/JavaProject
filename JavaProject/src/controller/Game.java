/*Jeu des six couleurs- Partie
 * @package controller
 * @author Alexis DAHAN
 * @author Nicolas DELTHEIL
 * 2016
 */
package controller;
import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;

import model.Colour;
import model.Player;
import model.Tray;

public class Game {
	private Player[] j;
	private Tray p =new Tray(13);;
	private boolean endgame;
	
	public Game(){
		j=null;
		endgame=false;
	}
	//Structure of the main menu
	public void menu(){
		StdDraw.setCanvasSize(800,600);
		StdDraw.setXscale(-0.5,p.getl()+3.5);
		StdDraw.setYscale(-2.5,p.getl()-0.5);
		StdDraw.picture(7.5, 5, "imgmenu.png");
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.setFont(new Font("arial", Font.BOLD,56));
			StdDraw.text(p.getl()/2+2, p.getl()-3, "Six colours game");
			StdDraw.setFont(new Font("arial", Font.BOLD,35));
			StdDraw.text(p.getl()/2+2, 8, "Number of players");
			StdDraw.setFont(new Font("arial", Font.BOLD,20));
		StdDraw.circle(p.getl()/2+2, 6,p.getl()/8);
		StdDraw.circle(p.getl()/2+2, 3,p.getl()/8);
		StdDraw.circle(p.getl()/2+2, 0,p.getl()/8);
		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.filledCircle(p.getl()/2+2, 6, p.getl()/8);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledCircle(p.getl()/2+2, 3,p.getl()/8);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledCircle(p.getl()/2+2, 0,p.getl()/8);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(p.getl()/2+2, 6, "2 players");
		StdDraw.text(p.getl()/2+2, 3, "3 players");
		StdDraw.text(p.getl()/2+2, 0, "4 players");
		int choice =0;
		//Different choices of the players 
		while(true){
			if(StdDraw.mousePressed()){
				
				int x=(int)Math.round(StdDraw.mouseX());
				int y=(int)Math.round(StdDraw.mouseY());
			if(x<=8 && x>=8 && y<=7 && y>=5 ){
				choice=2;
				break;
				}
			if(x<=8 && x>=8 && y<=4 && y>=2 ){
				choice=3;
				break;
				}
			if(x<=8 && x>=8 && y<=1 && y>=-1 ){
				choice=4;
				break;
				}
			}}
			p.displayTray(this.j);
				this.initPlayer(choice);
			
	}
	public void initPlayer(int nb){
		this.j=new Player[nb];
       for(int i=0;i<nb;i++){
    	   int c=0;
    	   StdDraw.setPenColor(StdDraw.BLACK);
		   StdDraw.text(p.getl()/2+1, -1, "Player "+Integer.toString(i+1) +" choose an initial case");
		   StdDraw.text(p.getl()/2+1, -1.5, "Press 'space' to play against an AI");
    	   while(c==0){
    	   if(StdDraw.mousePressed()){
				int x=(int)Math.round(StdDraw.mouseX());
				int y=(int)Math.round(StdDraw.mouseY());
				if(y>=0 && x<p.getl()-0.5){
				
				this.j[i]=new Player(
						"Player "+Integer.toString(i+1),
						x,
						y,
						false);
				if(p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().getjcolor()==null){
				p.getp()[j[i].getx0()][j[i].gety0()].setj(j[i]);
				p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().setjcolor(j[i]);
				c+=1;}
				
				}
		 }
    	   if(StdDraw.hasNextKeyTyped() ){
    		   System.out.println("e");
    			int nx=StdDraw.nextKeyTyped();
    			if(nx==32){
    				 System.out.println("space");
    				int[] tab=p.caseDepIa();
    				int x=tab[0];
    				int y=tab[1];
    				this.j[i]=new Player("Player "+Integer.toString(i+1)+" (AI)",x,y,true);
    				p.getp()[j[i].getx0()][j[i].gety0()].setj(j[i]);
    				p.getp()[j[i].getx0()][j[i].gety0()].getcasecolor().setjcolor(j[i]);
    				c+=1;
    			}}
    			}
    	   for(int k=0;k<p.getl();++k){
   			for(int t=0;t<p.getl();++t){
   				for(int l=0;l<p.getl();++l){
   					p.possessCase(t, l);
   				}
   			}}
    	   p.displayTray(this.j);
    	   }
	}
	public void turn(Player j,Colour c){
		Colour exc=p.getp()[j.getx0()][j.gety0()].getcasecolor();
		exc.setjcolor(null);
		c.setjcolor(j);
		for(int i=0;i<p.getl();++i){
			for(int l=0;l<p.getl();++l){
				if (p.getp()[i][l].getjcase()==j){
					p.getp()[i][l].setcolor(c);
				}
			}
		}
		for(int k=0;k<p.getl();++k){
			for(int i=0;i<p.getl();++i){
				for(int l=0;l<p.getl();++l){
					p.possessCase(i, l);
				}
			}
		}
	}
public void pressButton(int i){
int c=0;
boolean freecase=true;
while(c!=1){
	for(int a=0;a<p.getl();++a){
		for(int b=0;b<p.getl();++b){
			if(p.getp()[a][b].getjcase()==null){
				freecase=false;
			}
		}
	}
	for(int d=0;d<j.length;++d){
		if(j[d].getscore()>p.getl()*p.getl()/2){
			freecase=true;	
	}}
		if(freecase==true){
			this.endgame=true;
			c=1;
		}
	
	if(StdDraw.mousePressed()){
		
		int x=(int)Math.round(StdDraw.mouseX());
		int y=(int)Math.round(StdDraw.mouseY());
		
		if(y<0){
		if((x==1||x==0) && (y==-1||y==-2) && p.getrouge().getjcolor()==null){
			turn(j[i],p.getrouge());
			c=1;
		}
		if((x==2||x==3) && (y==-1||y==-2) && p.getorange().getjcolor()==null){
			turn(j[i],p.getorange());
			c=1;
		}
		if((x==4||x==5) && (y==-1||y==-2) && p.getjaune().getjcolor()==null){
			turn(j[i],p.getjaune());
			c=1;
		}
		if((x==6||x==7) && (y==-1||y==-2) && p.getvert().getjcolor()==null){
			turn(j[i],p.getvert());
			c=1;
		}
		if((x==8||x==9) && (y==-1||y==-2) && p.getbleu().getjcolor()==null){
			turn(j[i],p.getbleu());
			c=1;
		}
		if((x==10||x==11) && (y==-1||y==-2) && p.getcyan().getjcolor()==null){
			turn(j[i],p.getcyan());
			c=1;
		}
		if(c==1){
		p.displayTray(this.j);}}}
	}
}
public void displayScore(){
	StdDraw.setPenColor(StdDraw.BLACK);
	Player count=j[0];
	int best=j[0].getscore();
	for(int i=1;i<this.j.length;++i){
		int score=j[i].getscore();
		if(score>best){
			best=score;
			count=j[i];	
		}
	}
	StdDraw.clear();
	StdDraw.setPenColor(StdDraw.BLACK);
	StdDraw.setPenRadius(1000);
	StdDraw.picture(7.5, 5, "imgwinner.png");
	StdDraw.setFont(new Font("arial", Font.BOLD,35));
	StdDraw.text(p.getl()/2,p.getl()/2,"And the winner is: "+ count.getname());
	StdDraw.setFont(new Font("arial", Font.BOLD,25));
	StdDraw.text(p.getl()/2,p.getl()/2-1,"with "+Integer.toString(count.getscore())+" points");
	
}
	public void game(){
		p.defTray();
		menu();
		int t=0;
		while(t==0){
			for(int i=0;i<this.j.length;++i){
		this.pressButton(i);
		if(this.endgame==true){
			t=1;
			break;
		}}
			
	}
		displayScore();}



}
