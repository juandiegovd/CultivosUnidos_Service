package org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringJpaProducerRepository extends JpaRepository<ProducerJpaEntity, Long> {
    Optional<ProducerJpaEntity> findByDni(String dni);
    List<ProducerJpaEntity> findAllByCommunity_CommunityIdAndUser_State(Long communityId, Boolean state);
}