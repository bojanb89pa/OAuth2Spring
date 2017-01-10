/**
 * 
 */
package rs.bojanb89.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.bojanb89.datamodel.entity.User;


/**
 * @author Bojan Bogojevic
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User findById(Long userId);
}
