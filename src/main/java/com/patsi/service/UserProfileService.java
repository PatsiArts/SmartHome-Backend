package com.patsi.service;

import com.patsi.controller.RecipeController;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserProfileService {

    @Autowired
    private HttpServletRequest request;
    Logger log = LoggerFactory.getLogger(RecipeController.class);


    public String getUidFromToken() {
        String token = (String) request.getAttribute("token");
        log.info("token in getUidFromToken"+ token);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/logInSession";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/plain");
        String cleanedToken = token.replace("Bearer ", "");
        HttpEntity<String> requestEntity = new HttpEntity<>(cleanedToken, headers);
        ResponseEntity<String> responseEntity =
            restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }
}
