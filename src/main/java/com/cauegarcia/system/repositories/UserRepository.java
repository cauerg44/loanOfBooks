package com.cauegarcia.system.repositories;

import com.cauegarcia.system.entities.User;
import com.cauegarcia.system.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(nativeQuery = true, value = """
				SELECT clients.email AS username, clients.password, roles.id AS roleId, roles.authority
				FROM clients
				INNER JOIN user_role ON clients.id = user_role.user_id
				INNER JOIN roles ON roles.id = user_role.role_id
				WHERE clients.email = :email
			""")
	List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

	Optional<User> findByEmail(String email);
}