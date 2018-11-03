package assignment7;


class Tool {
	   // add your code here
	protected int strength;
	protected char type;
	public void setStrength( int strength ) {
		this.strength = strength;
	}
	public Tool() {
		
	}
	public Tool(int strength, char type) {
		this.strength = strength;
		this.type = type;
	}
	}

	/* Implement class Scissors */
class Scissors extends Tool{
	public Scissors(int strength) {
		super(strength,'s');
	}
	public boolean fight(Tool t) {
		if(t.getClass() == Paper.class) {
			if(this.strength * 2 > t.strength)
				return true;
			else {
				return false;
			}
		}else if(t.getClass() == Rock.class) {
			if(this.strength > t.strength * 2)
				return true;
			else {
				return false;
			}
		}else
			return false;
	}
}
	/* Implement class Paper */
class Paper extends Tool{
	public Paper(int strength) {
		super(strength,'p');
	}
	public boolean fight(Tool t) {
		if(t.getClass() == Rock.class) {
			if(this.strength * 2 > t.strength)
				return true;
			else {
				return false;
			}
		}else if(t.getClass() == Scissors.class) {
			if(this.strength > t.strength * 2)
				return true;
			else {
				return false;
			}
		}else
			return false;
	}
}
	/* Implement class Rock */
class Rock extends Tool{
	public Rock(int strength) {
		super(strength,'r');
	}
	public boolean fight(Tool t) {
		if(t.getClass() == Scissors.class) {
			if(this.strength * 2 > t.strength)
				return true;
			else {
				return false;
			}
		}else if(t.getClass() == Paper.class) {
			if(this.strength > t.strength * 2)
				return true;
			else {
				return false;
			}
		}else
			return false;
	}
}
public class RockPaperScissorsGame {
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}