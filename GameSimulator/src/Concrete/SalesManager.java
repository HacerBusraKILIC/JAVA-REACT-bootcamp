package Concrete;

import Abstract.BaseSalesManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public class SalesManager extends BaseSalesManager {

	@Override
	public void buyGame(Player player, Game game, Campaign campaign) {
		// TODO Auto-generated method stub
		super.buyGame(player, game, campaign);
	}

	@Override
	public void giveBack(Player player, Game game) {
		// TODO Auto-generated method stub
		super.giveBack(player, game);
	}

}
