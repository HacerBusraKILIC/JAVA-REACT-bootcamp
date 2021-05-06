package Abstract;

import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public interface SalesService {
	void buyGame(Player player, Game game, Campaign campaign);
	void giveBack(Player player, Game game);
}
