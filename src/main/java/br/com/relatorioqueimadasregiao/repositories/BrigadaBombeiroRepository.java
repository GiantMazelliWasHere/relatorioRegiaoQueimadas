package br.com.relatorioqueimadasregiao.repositories;

import br.com.relatorioqueimadasregiao.entities.BrigadaBombeiro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BrigadaBombeiroRepository extends JpaRepository<BrigadaBombeiro, Integer> {
    @Transactional
    BrigadaBombeiro findByNBrigada(Integer nBrigada);

}
