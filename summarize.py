from fastapi import FastAPI
from pydantic import BaseModel
from langchain_google_genai import ChatGoogleGenerativeAI
import os
import json
import re
from dotenv import load_dotenv

load_dotenv()

# Set your Gemini API key
os.environ["GOOGLE_API_KEY"] = os.getenv("GOOGLE_API_KEY")

# Initialize FastAPI app
app = FastAPI()

# LangChain Gemini model
llm = ChatGoogleGenerativeAI(model="gemini-pro")

# Request model
class ArticleRequest(BaseModel):
    articleId: int
    content: str
    sourceUrl: str

# Response model
class ArticleResponse(BaseModel):
    articleId: int
    sourceUrl: str
    category: str
    summary: str

# Fallback category guessing
def guess_category_fallback(text: str) -> str:
    text_lower = text.lower()
    counts = {
        "Sports news": sum(word in text_lower for word in ["cricket", "football", "match", "goal", "run", "খেলা", "খেলোয়াড়"]),
        "Politics": sum(word in text_lower for word in ["president", "prime minister", "election", "government", "মন্ত্রী", "রাজনীতি"]),
        "Economy": sum(word in text_lower for word in ["budget", "money", "business", "trade", "অর্থনীতি", "টাকা", "বাজেট"]),
        "Entertainment": sum(word in text_lower for word in ["hollywood", "bollywood", "movie", "actor", "actress", "বিনোদন", "নায়ক", "নায়িকা"]),
        "International news": sum(word in text_lower for word in ["war", "conflict", "international", "UN", "বিদেশ", "আন্তর্জাতিক"])
    }
    best_category = max(counts, key=counts.get)
    if counts[best_category] == 0:
        return "International news"
    return best_category

@app.post("/classify", response_model=ArticleResponse)
def classify_article(article: ArticleRequest):
    category = guess_category_fallback(article.content)
    summary = ""

    try:
        # Prompt Gemini for category + short summary
        prompt = f"""
Classify this article into one of these categories: 
[Sports news, Politics, Economy, Entertainment, International news].

Provide a concise summary of the article (3-4 lines, about 80-120 words).

Respond ONLY in VALID JSON with keys: "category" and "summary".
Do NOT include any explanation or text outside the JSON.

Article:
\"\"\"{article.content}\"\"\"
"""
        response = llm.invoke(prompt)
        text = response.content.strip()

        # Extract JSON using regex (robust)
        json_match = re.search(r"\{.*\}", text, re.DOTALL)
        if json_match:
            try:
                parsed = json.loads(json_match.group())
                category = parsed.get("category", category)
                summary = parsed.get("summary", "")
            except Exception:
                pass

        # Fallback only if summary is missing or too short
        if not summary or len(summary.split()) < 20:
            lines = article.content.split("\n")
            summary = " ".join(lines[:3])
            if len(summary.split()) > 120:
                summary = " ".join(summary.split()[:120]) + "..."

    except Exception:
        # Total fallback
        lines = article.content.split("\n")
        summary = " ".join(lines[:3])
        if len(summary.split()) > 120:
            summary = " ".join(summary.split()[:120]) + "..."

    return ArticleResponse(
        articleId=article.articleId,
        sourceUrl=article.sourceUrl,
        category=category,
        summary=summary
    )
