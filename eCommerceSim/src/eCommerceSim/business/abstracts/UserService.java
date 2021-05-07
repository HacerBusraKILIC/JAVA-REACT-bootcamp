package eCommerceSim.business.abstracts;

import eCommerceSim.entities.concretes.User;

public interface UserService {
    void register(User user);
    void delete(User user);
    User getByMail(String mail);
}
