package com.interview.router;

import com.interview.handler.EvaluationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Router configuration for WebFlux
 * Defines API routes and maps them to handlers
 * Uses functional routing (type-safe alternative to @RestController)
 */
@Configuration
public class RouterConfig {

    /**
     * Configures the evaluation endpoints:
     * - POST /api/v1/evaluate - candidate only
     * - POST /api/v1/evaluate/full - candidate + optional interviewer
     */
    @Bean
    public RouterFunction<ServerResponse> evaluateRoutes(EvaluationHandler handler) {
        return route(POST("/api/v1/evaluate"), handler::evaluateCandidate)
                .andRoute(POST("/api/v1/evaluate/full"), handler::evaluateFull);
    }

}
