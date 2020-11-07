package com.springreactive.udemyreactive.router;

import com.springreactive.udemyreactive.handler.ItemHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.springreactive.udemyreactive.constants.ItemConstants.ITEM_FUNCTIONAL_END_POINT;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ItemsRouter {
    @Bean
    public RouterFunction<ServerResponse> itemRouter(ItemHandler itemHandler) {
        return RouterFunctions
                .route(GET(ITEM_FUNCTIONAL_END_POINT).and(accept(MediaType.APPLICATION_JSON)), itemHandler::getAllItems)
                .andRoute(GET(ITEM_FUNCTIONAL_END_POINT).and(accept(MediaType.APPLICATION_JSON)), itemHandler::getById);
    }
}
