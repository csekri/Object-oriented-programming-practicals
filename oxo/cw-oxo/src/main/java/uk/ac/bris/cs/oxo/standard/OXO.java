package uk.ac.bris.cs.oxo.standard;

import static java.util.Objects.requireNonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import uk.ac.bris.cs.gamekit.matrix.ImmutableMatrix;
import uk.ac.bris.cs.gamekit.matrix.Matrix;
import uk.ac.bris.cs.gamekit.matrix.SquareMatrix;
import uk.ac.bris.cs.oxo.Cell;
import uk.ac.bris.cs.oxo.Outcome;
import uk.ac.bris.cs.oxo.Player;
import uk.ac.bris.cs.oxo.Side;
import uk.ac.bris.cs.oxo.Spectator;
import uk.ac.bris.cs.gamekit.matrix.SquareMatrix;
import uk.ac.bris.cs.oxo.Cell;
import uk.ac.bris.cs.oxo.Player;
import uk.ac.bris.cs.oxo.Side;
import uk.ac.bris.cs.oxo.Spectator;

public class OXO implements OXOGame, Consumer<Move> {

	private int size;
	private Side currentSide;
	private Player nought,cross;
	private final SquareMatrix<Cell> matrix;
	
	public OXO(int size, Side startSide, Player nought, Player cross) {
		if(size <= 0) throw new IllegalArgumentException("Invalid size");
		if(startSide == null) throw new NullPointerException("Starting side must be specified");
		if(nought == null) throw new NullPointerException("The nought player must be specified");
		if(cross == null) throw new NullPointerException("The cross player must be specified");
		this.size = size;
		currentSide = startSide;
		this.nought = nought;
		this.cross = cross;
		this.matrix = new SquareMatrix<Cell>(size, new Cell());
		// TODO
	}

	@Override
	public void registerSpectators(Spectator... spectators) {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public void unregisterSpectators(Spectator... spectators) {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public void start() {
		Player player = (currentSide == Side.CROSS) ? cross : nought;
		player.makeMove(this, validMoves(), this);
	}

	@Override
	public ImmutableMatrix<Cell> board() {
		return new ImmutableMatrix<>(matrix);
	}

	@Override
	public Side currentSide() {
		return this.currentSide;
	}
	
	private Set<Move> validMoves() {
		  Set<Move> moves = new HashSet<>();
		  for (int row = 0; row < matrix.rowSize(); row++) {
		    for (int col = 0; col < matrix.columnSize(); col++) {
		      if(matrix.get(row, col) == null) moves.add(new Move(row,col));//add moves here via moves.add(new Move(row, col)) if the matrix is empty at this location
		  } }
		  //...
		  return moves;
		}
	
	 @Override
	   public void accept(Move move) {
	     // do something with the Move the current Player wants to play
	   }

}
