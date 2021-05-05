package Abstract;

import Entities.Player;

public interface CRUDService {
	void add(Player player);
	void update(Player player);
	void delete(Player player);
}
