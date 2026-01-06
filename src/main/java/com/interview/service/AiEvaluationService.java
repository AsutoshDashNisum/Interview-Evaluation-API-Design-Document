package com.interview.service;

import com.interview.config.AppProperties;
import com.interview.dto.CandidateEvaluationRequest;
import com.interview.dto.CandidateEvaluationResponse;
import com.interview.dto.FullEvaluationRequest;
import com.interview.dto.FullEvaluationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * AiEvaluationService - Real evaluation using AI/LLM provider
 *
 * Active when: ai.enabled=true
 *
 * This is a placeholder implementation that will integrate with:
 * - OpenAI API
 * - Anthropic API
 * - Other LLM providers
 *
 * Currently returns error indicating AI integration is not yet implemented.
 * Once ai.enabled=true, this service will handle actual AI evaluation calls.
 */
@Service
@ConditionalOnProperty(name = "ai.enabled", havingValue = "true")
public class AiEvaluationService implements EvaluationService {

    private static final Logger logger = LoggerFactory.getLogger(AiEvaluationService.class);
    private final AppProperties appProperties;

    public AiEvaluationService(AppProperties appProperties) {
        this.appProperties = appProperties;
        logger.warn("AiEvaluationService initialized. Provider: {}, Model: {}",
                appProperties.getProvider(), appProperties.getModel());
    }

    @Override
    public Mono<CandidateEvaluationResponse> evaluateCandidate(CandidateEvaluationRequest request) {
        logger.info("AiEvaluationService: Evaluating candidate with AI (provider={}, model={})",
                appProperties.getProvider(), appProperties.getModel());

        // TODO: Implement actual AI integration
        // 1. Construct prompt from request
        // 2. Call LLM API (OpenAI, Anthropic, etc.)
        // 3. Parse response
        // 4. Map to CandidateEvaluationResponse
        // 5. Return via Mono

        return Mono.error(new UnsupportedOperationException(
                "AI evaluation not yet implemented. Please set ai.enabled=false to use dummy evaluation service."
        ));
    }

    @Override
    public Mono<FullEvaluationResponse> evaluateFull(FullEvaluationRequest request) {
        logger.info("AiEvaluationService: Full evaluation with AI (provider={}, model={})",
                appProperties.getProvider(), appProperties.getModel());

        // TODO: Implement actual AI integration for full evaluation
        // Similar to evaluateCandidate but includes optional interviewer evaluation

        return Mono.error(new UnsupportedOperationException(
                "AI evaluation not yet implemented. Please set ai.enabled=false to use dummy evaluation service."
        ));
    }

}

