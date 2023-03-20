CREATE TABLE movies (
    id SERIAL PRIMARY KEY,
    title TEXT,
    description TEXT,
    image_link TEXT,
    release_date timestamp without time zone
)