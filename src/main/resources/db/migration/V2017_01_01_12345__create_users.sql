CREATE TABLE users (
  id                 SERIAL PRIMARY KEY,
  first_name         TEXT      NOT NULL,
  last_name          TEXT      NOT NULL,
  username           TEXT      NOT NULL,
  encrypted_password TEXT      NOT NULL,
  created_at         TIMESTAMP NOT NULL,
  updated_at         TIMESTAMP NOT NULL
);