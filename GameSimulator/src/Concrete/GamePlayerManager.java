package Concrete;

import Abstract.BasePlayerManager;
import Abstract.PlayerCheckService;
import Entities.Player;

public class GamePlayerManager extends BasePlayerManager {
private PlayerCheckService playerCheck;

public GamePlayerManager(PlayerCheckService playerCheck) {
	this.playerCheck = playerCheck;
}
@Override
public void add(Player player) {
	if(playerCheck.CheckIfRealPerson(player)) {
		super.add(player);
	} else {
		System.out.println("Not a valid Person");
	}
	
}
@Override
public void update(Player player) {
	if(playerCheck.CheckIfRealPerson(player)) {
	super.update(player);
	} else {
		System.out.println("Not a valid Person");
	}
}
@Override
public void delete(Player player) {
	if(playerCheck.CheckIfRealPerson(player)) {
	super.delete(player);
} else {
	System.out.println("Not a valid Person");
}
}
}
