package com.github.ron99.poke.api.services;

import com.github.ron99.poke.api.model.response.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RestService {
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(RestService.class);

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private StringBuilder baseUrl(){
        StringBuilder baseurl = new StringBuilder();

        baseurl.append("https://pokeapi.co/api/v2");
        return baseurl;
    }

    public Pokemon getById(Integer id){
        try{
            StringBuilder url = baseUrl();
            url.append("/pokemon/{id}");

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

            ResponseEntity<Pokemon> response = this.restTemplate.exchange(url.toString(), HttpMethod.GET, request, Pokemon.class, id);
            if(response.getStatusCode() == HttpStatus.OK){
                logger.info("Pokemon found with ID {}", id);
                return response.getBody();
            }
        }catch(HttpStatusCodeException ex){
            logger.error("Pokemons request error", ex);
        }
        return null;
    }
}
