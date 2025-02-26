package com.mehmetsolak.apigateway.service.filter;

import com.mehmetsolak.apigateway.service.JwtService;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtSecurityFilter implements GatewayFilter {
    private final JwtService jwtService;

    public JwtSecurityFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        final String authenticationHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")) {
            return setComplete(response);
        }
        final String token = authenticationHeader.substring(7);
        if(!jwtService.isTokenValid(token)) {
            return setComplete(response);
        }
        return chain.filter(exchange);
    }

    private Mono<Void> setComplete(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}
