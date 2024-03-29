package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import javax.servlet.http.HttpServletRequest;

public interface RegisterProducerUseCase {
    Producer registerProducer(Long communityId, ProducerToRegister producerToRegister, HttpServletRequest request);
}
