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

        String context="Context: The conversation started with a user seeking guidance on a particular issue related to the safety of women in India, specifically with respect to assault cases and lengthy judgment periods. Summary: The user expressed concern about the safety of women in India, citing issues with loose laws against assault and long judgment periods. The AI Legal Assistant acknowledged the significance of these issues and provided steps to address them, including reporting incidents, seeking medical attention, contacting a lawyer or legal aid, and reaching out to support groups. The conversation highlighted key Indian laws and sections relevant to assault cases, such as Section 375 of the IPC, Section 354 of the IPC, and The Protection of Women from Domestic Violence Act, 2005. The AI Legal Assistant also provided accessible Indian helplines and organizations for immediate assistance, including the National Commission for Women (NCW), All India Women's Conference (AIWC), and National Domestic Violence Helpline.";
        String promptText = env.getProperty("env.api.promptText");
        String prompt = promptText+ " Question:"+input;

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
