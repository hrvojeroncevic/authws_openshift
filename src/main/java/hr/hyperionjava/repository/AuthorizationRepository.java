package hr.hyperionjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.hyperionjava.model.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

}
