package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers.MerchandiseEntryDetailMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories.SpringJpaMerchandiseEntryDetailRepository;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.GetMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class MerchandiseEntryDetailPersistenceAdapter implements RegisterMerchandiseEntryDetailsPort, GetMerchandiseEntryDetailsPort {
    private final SpringJpaMerchandiseEntryDetailRepository entryDetailRepository;
    private final MerchandiseEntryDetailMapper entryDetailMapper;

    @Override
    public List<MerchandiseEntryDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToPersist> details) {
        var entities = entryDetailMapper.toMerchandiseEntriesDetailJpa(details);
        var result = entryDetailRepository.saveAll(entities);
        return entryDetailMapper.toMerchandiseEntriesDetail(result);
    }

    @Override
    public Paginator<MerchandiseEntryDetail> getMerchandiseEntryDetails(Filters filters, Long merchandiseEntryId) {
        var pageable = PageRequest.of(filters.getPage(), filters.getPageSize());
        var page = entryDetailRepository.findByMerchandiseEntry_MerchandiseEntryId(pageable, merchandiseEntryId);
        var data = page.getContent()
                .stream().map(entryDetailMapper::toMerchandiseEntryDetail)
                .collect(Collectors.toList());

        return Paginator.<MerchandiseEntryDetail>builder()
                .page(filters.getPage())
                .pageSize(filters.getPageSize())
                .total(page.getTotalElements())
                .data(data)
                .build();
    }
}
