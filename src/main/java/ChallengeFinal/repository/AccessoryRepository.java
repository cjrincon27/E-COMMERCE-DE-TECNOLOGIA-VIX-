package ChallengeFinal.repository;

import ChallengeFinal.models.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
}
