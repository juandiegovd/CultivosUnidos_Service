package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class ScheduleHectaresNotValidException extends RuntimeException implements UserInputException {
    private final String code = "CRG_99";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        Double hectares;
        Integer cantProducers;
    }

    public ScheduleHectaresNotValidException(Double hectares, Integer cantProducers) {
        super();
        this.message = ErrorMessages.CRG_99_MESSAGE;
        this.data = new Data(hectares, cantProducers);
    }
}
