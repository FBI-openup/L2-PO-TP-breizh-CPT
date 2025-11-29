File imcomplete from gitlab
---
# Breizh CPT: Multilingual City Guide Chatbot

## 📌 Project Overview
Breizh CPT is a domain-specific chatbot designed to assist users in navigating the city of Rennes. It provides location intelligence, landmark information, and functional queries in **6 different languages**.
The system prioritizes deterministic accuracy and robustness, utilizing a **Knowledge Base**, a **Finite State Machine (FSM)**, and **Fuzzy String Matching** algorithms to handle real-world user inputs.

## 💡 My Contributions (End-to-End Leadership)
*   **Algorithmic Robustness (Input Tolerance):** Implemented a fuzzy matching module using **Levenshtein Distance (Edit Distance)**. This allows the bot to correctly identify user intents and locations even when inputs contain typos or misspellings.
*   **Knowledge Engineering:** Designed and built the structured knowledge base containing Rennes' landmarks, geolocation data, and functional descriptions.
*   **State Machine Design:** Architected the FSM logic to handle conversation flow and seamless context-switching between 6 languages.

## 🛠️ Tech Stack
*   **Core Logic:** Python, Finite State Machine (FSM)
*   **Algorithms:** Levenshtein Distance (for typo tolerance)
*   **Data:** Structured JSON/SQL Knowledge Base

## 📂 Architecture
1.  **Input Processing:** 
    *   Language detection.
    *   **Fault-tolerant Intent Recognition** (using Edit Distance).
2.  **State Machine:** Manages user context.
3.  **Knowledge Retrieval:** Queries the structured database.
4.  **Response Generation:** Assembles the localized response.
