package Abstract;

import Entities.Player;

public class BasePlayerManager implements PlayerService {

	@Override
	public void add(Player player) {
		System.out.println("Add to db (player) " + player.getFirstName());		
		
	}

	@Override
	public void update(Player player) {
		System.out.println("Update to db (player) " + player.getFirstName() );		
		
	}

	@Override
	public void delete(Player player) {
		System.out.println("Delete to db (player) " + player.getFirstName());		
		
	}


	
}
