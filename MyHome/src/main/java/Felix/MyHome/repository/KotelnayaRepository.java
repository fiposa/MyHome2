package Felix.MyHome.repository;

import Felix.MyHome.model.Kotelnaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KotelnayaRepository extends JpaRepository<Kotelnaya, Integer> {
    public Optional <Kotelnaya> findKotelnayaByHouseId (int id);
    public Kotelnaya findKotelnayaById (int id);
}
