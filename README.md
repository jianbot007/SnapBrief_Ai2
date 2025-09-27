# SnapBrief_Ai2

## Overview

SnapBrief_Ai2 is a powerful news aggregation and summarization platform built using Spring Boot, FastAPI, and Langchain (LLM). This project collects news from RSS feeds of various Bangladeshi news portals, sends all the news to a Langchain+FastAPI backend for summarization and categorization using Gemini API and prompt engineering, and stores the processed data in a PostgreSQL database. The entire workflow is connected and accessible through APIs.

## Features

- **News Collection**: Aggregates news from multiple Bangladeshi RSS feeds using Spring Boot.
- **Summarization & Categorization**: Utilizes Langchain with Gemini API and prompt engineering for concise summaries and automatic categorization.
- **API Driven**: Fully connected via REST APIs for easy integration and access.
- **Database Storage**: Persists all news summaries and metadata in PostgreSQL.
- **Tech Stack**: Combines the robustness of Spring Boot (Java) for backend logic and FastAPI (Python) for AI-powered text processing.

## Technology Stack

- **Java (Spring Boot)**: 88%
- **Python (FastAPI, Langchain)**: 12%
- **PostgreSQL**: For persistent data storage
- **Gemini API**: For advanced LLM-based summarization and categorization

## Architecture

1. **Spring Boot**: Handles the collection of news from RSS feeds, API orchestration, and business logic.
2. **FastAPI + Langchain**: Processes news summaries and categories using LLMs.
3. **Gemini API**: Delivers high-quality AI-driven text summarization.
4. **PostgreSQL**: Stores original and processed news data.
5. **APIs**: Connects all modules for seamless operation.

## Setup Instructions

> _Note: Actual file structure and detailed setup instructions may differ. Please refer to project files for specifics._

### Prerequisites

- Java 11+
- Python 3.8+
- PostgreSQL (configured and running)
- Maven & pip (for dependency management)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/jianbot007/SnapBrief_Ai2.git
   cd SnapBrief_Ai2
   ```

2. **Backend (Spring Boot)**
   - Configure database settings in `application.properties`
   - Build and run:
     ```bash
     mvn clean install
     mvn spring-boot:run
     ```

3. **AI Service (FastAPI + Langchain)**
   - Navigate to the Python service directory (refer to actual repo structure)
   - Install dependencies:
     ```bash
     pip install -r requirements.txt
     ```
   - Run FastAPI service:
     ```bash
     uvicorn main:app --reload
     ```

4. **Environment Variables**
   - Set up Gemini API keys and other secrets in `.env` or your system environment.

## Usage

- Query the Spring Boot API to trigger news collection.
- News is sent to the FastAPI service for summarization.
- Summarized and categorized news is stored in PostgreSQL.
- Retrieve processed news via API endpoints.

## Contributing

Contributions are welcome! Please open issues or submit pull requests for improvements, bugfixes, or new features.

## License

This project is licensed under the MIT License.

## Contact

For questions or support, contact [jianbot007](https://github.com/jianbot007).
