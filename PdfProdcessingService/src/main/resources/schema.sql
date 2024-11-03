CREATE EXTENSION IF NOT EXISTS vector;
CREATE EXTENSION IF NOT EXISTS hstore;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS docs (
    id uuid primary key,
    text varchar not null,
    embedding vector(1024) not null
);

CREATE INDEX ON docs USING HNSW (embedding vector_cosine_ops);