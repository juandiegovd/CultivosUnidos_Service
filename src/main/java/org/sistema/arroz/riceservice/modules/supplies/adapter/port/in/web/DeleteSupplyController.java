package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.DeleteSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.ValidateSupplyDeletionUseCase;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotValidToDeleteException;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class DeleteSupplyController {
    private final DeleteSupplyUseCase deleteSupplyUseCase;
    private final ValidateSupplyDeletionUseCase validateSupplyDeletionUseCase;

    @DeleteMapping(value = "/{supplyId}")
    public Long deleteSupply(@PathVariable Long supplyId){
        var result = validateSupplyDeletionUseCase.validateSupplyDeletion(supplyId);
        if (result != null) throw new SupplyNotValidToDeleteException(supplyId, result);
        return deleteSupplyUseCase.deleteSupply(supplyId);
    }
}
