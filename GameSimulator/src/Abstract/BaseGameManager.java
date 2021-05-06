package Abstract;

import Abstract.GameService;
import Entities.Game;

public class BaseGameManager implements GameService {

	@Override
	public void add(Game game) {
		System.out.println("Add to db (game) " + game.getGameName());		
		
	}

	@Override
	public void update(Game game) {
		System.out.println("Add to db (game) " + game.getGameName());		
		
	}

	@Override
	public void delete(Game game) {
		System.out.println("Add to db (game) " + game.getGameName());		
		
	}


}
