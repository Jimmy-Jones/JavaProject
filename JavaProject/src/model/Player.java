/*Jeu des six couleurs- classe des joueurs
 * @package model
 * @author Alexis DAHAN
 * @author Nicolas DELTHEIL
 * 2016
 */
package model;

public class Player {
	private String name;
	private int x0;
	private int y0;
	private int score;
	private boolean ai;


	public Player(String name, int x0,int y0, boolean ai){
		this.name=name;
		this.x0=x0;
		this.y0=y0;
		this.score=1;
		this.ai=ai;
	}
	public int getx0(){
		return this.x0;
	}
	public int gety0(){
		return this.y0;
	}
	public String getname(){
		return this.name;
	}
	public int getscore(){
		return this.score;
	}
	public boolean getia(){
		return this.ai;
	}
	public void setscore(int score){
		this.score=score;
	}

}
