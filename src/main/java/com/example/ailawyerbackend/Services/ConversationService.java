package com.example.ailawyerbackend.Services;

import com.example.ailawyerbackend.Models.Conversation;
import com.example.ailawyerbackend.Repositories.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    public Conversation saveConversation(Conversation conversation){
        return conversationRepository.save(conversation);
    }

}
