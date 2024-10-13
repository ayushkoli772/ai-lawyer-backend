package com.example.ailawyerbackend.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Service
public class AdviceService {

    @Autowired
    private Environment env;


    public String getAdvice(String input) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        String API_KEY= env.getProperty("env.api.key");

        httpHeaders.set("Authorization","Bearer "+API_KEY);
        httpHeaders.set("Content-Type","application/json");


        String promptText = env.getProperty("env.api.promptText");
        String prompt = promptText+input;

        String body = "{ \"model\": \"meta-llama/llama-3.1-70b-instruct:free\", \"messages\": [{ \"role\": \"user\", \"content\": \"" + prompt + "\" }] }";

        HttpEntity<String> httpEntity = new HttpEntity<>(body,httpHeaders);


        String API_URL = env.getProperty("env.api.url");
        ResponseEntity<String> responseEntity = restTemplate.exchange(API_URL, HttpMethod.POST,httpEntity,String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseEntity.getBody());

        String output = root.path("choices").get(0).path("message").path("content").asText();

        return output;
    }
}
