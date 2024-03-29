package org.sistema.arroz.riceservice.modules.projections.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.*;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/projections")
public class ProjectCropsController {
    private final ProjectCropsUseCase projectCropsUseCase;

    @PostMapping(value = "/crops")
    public ProjectionCropsDTO projectCrops(@RequestBody ProjectProductCrops projectCrops){
        return projectCropsUseCase.projectCrops(projectCrops.getMonth(), projectCrops.getProducts());
    }
}
