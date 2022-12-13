package ChallengeFinal.repository;

import ChallengeFinal.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
