# How to start this project?

**First of all, install Docker**

1. Clone the repository - ```git clone https://github.com/yeeeip/MtsDocAI```
2. Create .env file in the root directory.
## Example of the .env file:
```
PG_USER=postgres
PG_PASSWORD=postgres
PG_DB=docs-db
PG_HOST=pgvector-db:5432
LLAMA_URI=https://mts-aidocprocessing-case.olymp.innopolis.university/generate
EMBEDDER_URI=https://mts-aidocprocessing-case-embedder.olymp.innopolis.university
```
3. Run the following command in the root project directory: ```docker-compose up -d```
4. [CLICK](http://localhost:3000/dashboard)
