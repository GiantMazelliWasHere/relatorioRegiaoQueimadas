package br.com.relatorioqueimadasregiao.repositories;

import br.com.relatorioqueimadasregiao.entities.DadosIncendio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DadosIncendioRepository extends JpaRepository<DadosIncendio, Integer> {
    @Transactional
    DadosIncendio findByLocal(String local);

}
