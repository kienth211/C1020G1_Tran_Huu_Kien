package p1.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import p1.phone.model.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
