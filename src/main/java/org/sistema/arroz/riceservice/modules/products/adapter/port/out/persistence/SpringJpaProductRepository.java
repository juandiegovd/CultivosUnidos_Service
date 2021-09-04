package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringJpaProductRepository extends JpaRepository<ProductJpaEntity, Long> {
    @Query("SELECT P FROM ProductJpaEntity P WHERE P.communityJpaEntity.communityId = :communityId AND P.state = :state AND (UPPER(P.productName) LIKE CONCAT('%', UPPER(:search), '%' )) ORDER BY P.productName DESC")
    Page<ProductJpaEntity> searchProducts(Pageable pageable, @Param("search") String search, @Param("communityId") Long communityId, @Param("state") Boolean state);
}
