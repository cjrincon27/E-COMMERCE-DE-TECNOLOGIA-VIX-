package ChallengeFinal.repository;

import ChallengeFinal.models.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConsoleRepository extends JpaRepository<Console,Long> {
}
