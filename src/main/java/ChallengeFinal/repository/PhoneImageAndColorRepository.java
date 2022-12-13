package ChallengeFinal.repository;

import ChallengeFinal.models.Phone;
import ChallengeFinal.models.PhoneImageAndColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PhoneImageAndColorRepository extends JpaRepository<PhoneImageAndColor, Long> {
    public PhoneImageAndColor findByPhone(Phone phone);
}
