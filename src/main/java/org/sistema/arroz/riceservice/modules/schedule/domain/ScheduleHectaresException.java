package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class ScheduleHectaresException extends RuntimeException implements UserInputException {
    private final String code = "CRG_03";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        Double hectares;
        Double actualHectares;
    }

    public ScheduleHectaresException(Double hectares, Double actualHectares) {
        super();
        this.message = String.format(ErrorMessages.CRG_03_MESSAGE, actualHectares, hectares);
        this.data = new Data(hectares, actualHectares);
    }
}
