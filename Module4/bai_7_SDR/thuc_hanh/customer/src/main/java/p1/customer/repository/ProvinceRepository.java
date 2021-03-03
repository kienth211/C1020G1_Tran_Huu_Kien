package p1.customer.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import p1.customer.model.Province;

@Repository
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
