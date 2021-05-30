package kodlamaio.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.core.entitites.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
