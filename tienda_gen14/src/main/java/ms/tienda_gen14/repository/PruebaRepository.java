package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.PruebaEntity;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository <PruebaEntity,Long>{
}
