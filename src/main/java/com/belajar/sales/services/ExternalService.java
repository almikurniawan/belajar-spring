package com.belajar.sales.services;

import com.belajar.sales.dtos.IPubersVersionResponseDto;
import com.belajar.sales.entities.ErrorRetry;
import com.belajar.sales.exceptionHandler.exception.CallHttpException;
import com.belajar.sales.repositories.IErrorRetryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class ExternalService {
    private static final Logger logger = LoggerFactory.getLogger(ExternalService.class);

    @Autowired
    public WebClient webClient;

    @Autowired
    public IErrorRetryRepository errorRetryRepository;

    @Retryable(
            value = { CallHttpException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public String callError() throws CallHttpException {
        String payload = "tes-payload";
        try{
            var result = webClient.get()
                    .uri("web-api-core/asfnasfasf")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            return result;
        }catch (Exception e){
            logger.error("error panggil ipubers : "+e.getMessage());
            throw new CallHttpException("API failed",payload);
        }
    }

    @Async
    public CompletableFuture<IPubersVersionResponseDto> callSuccess() {
        var result = webClient.get()
                .uri("web-api-core/Auth/GetLastVersion")
                .retrieve()
                .bodyToMono(IPubersVersionResponseDto.class)
                .block();
        return CompletableFuture.completedFuture(result);
    }

    @Recover
    public String recover(CallHttpException ex, String recipient) {
        var error = new ErrorRetry();
        error.setError(ex.message);
        error.setAction("call-external");
        error.setPayload(ex.payload);
        errorRetryRepository.save(error);
        return ex.message;
    }
}
