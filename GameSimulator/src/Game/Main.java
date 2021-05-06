package Game;

import java.util.Date;

import Abstract.BaseCampaignManager;
import Abstract.BaseGameManager;
import Abstract.BasePlayerManager;
import Abstract.BaseSalesManager;
import Adapters.MernisServiceAdapter;
import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.PlayerManager;
import Concrete.SalesManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public class Main {

	public static void main(String[] args) {
		BasePlayerManager playerManager = new PlayerManager(new MernisServiceAdapter());
		Player busra = new Player(1, "Hacer Büşra", "KILIÇ", new Date(1995,01,20), "60694307656");
		playerManager.add(busra);

		BaseGameManager gameManagger = new GameManager();
		Game volarant = new Game(1, "Valorant", 999);
		gameManagger.add(volarant);
		
		BaseCampaignManager campaignManager = new CampaignManager();
		Campaign valorant_50 = new Campaign(1, "Valorant %50", new Date(2021,05,06), new Date(2021,07,01), 50);
		campaignManager.add(valorant_50);
		
		BaseSalesManager salesManager = new  SalesManager();
		salesManager.buyGame(busra, volarant, valorant_50);
	}

}
