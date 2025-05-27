package br.com.relatorioqueimadasregiao.repositories;

import br.com.relatorioqueimadasregiao.entities.Dado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DadoRepository extends JpaRepository<Dado, Integer> {
    @Transactional
    Dado findByMunicipio(String municipio);
}
