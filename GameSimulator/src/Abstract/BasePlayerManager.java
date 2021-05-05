package Abstract;

import Entities.Player;

public class BasePlayerManager implements CRUDService {

	@Override
	public void add(Player player) {
		System.out.println("Add to db " + player.FirstName);	
	}

	@Override
	public void update(Player player) {
		System.out.println("Update to db " + player.FirstName);
	}

	@Override
	public void delete(Player player) {
		System.out.println("Delete to db " + player.FirstName);
	}
	
}
