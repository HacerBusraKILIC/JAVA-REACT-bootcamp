package eCommerceSim.core;

import eCommerceSim.entities.concretes.User;

public interface AuthService {
	void register(User user);
    void login(String email, String password);
}
