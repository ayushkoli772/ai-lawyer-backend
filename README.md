# AI Legal Assistant Backend

## Overview

The AI Legal Assistant backend is developed using Spring Boot to provide a robust and scalable solution for delivering accurate legal advice through an API. This backend seamlessly integrates with the Next.js frontend, handling user queries and leveraging a trained language model to generate responses.

## Demo

You can interact with the API via the frontend [Live Link](https://ai-lawyer-sigma.vercel.app).

## Features

- **RESTful API**: Implements a clean and intuitive API for the frontend to communicate with.
- **Legal Query Processing**: Processes user queries and provides contextually relevant legal advice.
- **Integration with LLM**: Utilizes a trained language model to generate accurate responses based on user input.
- **Security**: Implements security best practices to protect sensitive user data.

## Installation

1. Clone the repository locally:
```
git clone https://github.com/ayushkoli772/ai-lawyer-backend.git
```  
2. Navigate to the Project Directory:
```
cd ai-lawyer-backend
```
3. Run the application:
```
./mvnw spring-boot:run
```
4. The server will start at [http://localhost:8080](http://localhost:8080).

## API Endpoints

### POST `/chat`

#### Description: Receives user messages and returns appropriate legal advice.
#### Request Body:
```
"Your query here"
```

### Response:

```
Returns a plain text string containing the legal advice.
```

## Technologies Used

- **Spring Boot:** For building the RESTful API.
- **MongoDB:** For data storage and management.

## Future Improvements
- **Enhanced AI Capabilities**: Integrate more advanced LLM models for higher accuracy in legal advice.
- **User Authentication**: Implement secure user login and account management features.
- **Dashboard for Legal Experts**: Allow experts to validate and improve the AI responses continuously.
