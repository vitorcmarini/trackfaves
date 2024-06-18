CREATE TABLE mangas (
                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        title VARCHAR(255) NOT NULL,
                        author VARCHAR(255) NOT NULL,
                        description TEXT,
                        image VARCHAR(255),
                        year INTEGER,
                        chapters INTEGER,
                        genre VARCHAR(255),
                        status VARCHAR(255),
                        score DOUBLE PRECISION
);
