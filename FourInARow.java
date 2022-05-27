package game;

public class FourInARow extends Game {

	public FourInARow(String player1, String player2) {  //constructor for initializing this play
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	@Override
	protected boolean doesWin(int i, int j) { //override method -if the max line is 4 we have a winner
		if (maxLineContaining(i, j) == 4)
			return true;
		return false;
	}

	@Override
	protected boolean onePlay(Player p) { //override method

		System.out.format("%s, please enter column:", p.toString()); //ask for number of col
		int col = s.nextInt();
		while ((super.isEmpty(0, col)) == false) { //if this column is not empty
			System.out.format("%s, please enter column:", p.toString());
			col = s.nextInt();
		}
		int i=5;
		while(super.set(i, col, p)==false) //insert the write place in the column
			i--;
		System.out.format(super.toString()); //print the board after the moving
		if (doesWin(i, col)) { //checking if we have winner
			System.out.format("%s Won!", p.toString());
			return true;
		}
		return false; //we haven't winner
	}

}
