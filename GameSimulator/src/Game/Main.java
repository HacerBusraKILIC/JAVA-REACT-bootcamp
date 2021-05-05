package Game;

import java.util.Date;

import Abstract.BasePlayerManager;
import Adapters.MernisServiceAdapter;
import Concrete.GamePlayerManager;
import Entities.Player;

public class Main {

	public static void main(String[] args) {
		BasePlayerManager playerManager = new GamePlayerManager(new MernisServiceAdapter());
		playerManager.Save(new Player(1, "Hacer Büşra", "KILIÇ", new Date(1995,01,20), "60694307656"));


	}

}
