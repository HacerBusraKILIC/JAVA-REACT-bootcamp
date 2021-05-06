package Abstract;

import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public class BaseSalesManager implements SalesService {



	@Override
	public void buyGame(Player player, Game game, Campaign campaign) {
		System.out.println( game.getGameName() +  " sales to " +player.getFirstName() + " with campaign " + campaign.getCampaignName());		
		
	}

	@Override
	public void giveBack(Player player, Game game) {
		System.out.println( player.getFirstName() +  " give back the " + game.getGameName() );		
		
	}

}
