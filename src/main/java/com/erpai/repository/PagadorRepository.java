package com.erpai.repository;

import com.erpai.domain.Pagador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagadorRepository extends JpaRepository<Pagador, Long> {
}
