package com.erpai.repository;

import com.erpai.domain.Informativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformativoRepository extends JpaRepository<Informativo, Long> {
}

