package com.example.ailawyerbackend.Repositories;

import com.example.ailawyerbackend.Models.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
}
