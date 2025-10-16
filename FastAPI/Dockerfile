# Base image
FROM python:3.11-slim

# Working directory
WORKDIR /app

# Dependencies copy & install
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# Application copy
COPY . .

# Expose port
EXPOSE 8000

# Command to run
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
