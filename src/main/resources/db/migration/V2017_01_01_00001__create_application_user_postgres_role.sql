-- Create a group that has basic privileges to connect to this database.
CREATE ROLE application_user LOGIN;
GRANT CONNECT ON DATABASE sbbc_db TO application_user;
GRANT USAGE ON SCHEMA public TO application_user;

-- Create a group that has write-only privileges on the database.
GRANT TEMP ON DATABASE sbbc_db TO application_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO application_user;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public TO application_user;

-- Set up default privileges so that future relations are created with correct access.
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO application_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT INSERT, UPDATE, DELETE ON TABLES TO application_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE ON SEQUENCES TO application_user;

-- Make sure the only way a user gets privileges is via a group that we purposely grant to that user.
REVOKE ALL PRIVILEGES ON DATABASE sbbc_db FROM PUBLIC;
REVOKE ALL PRIVILEGES ON SCHEMA public FROM PUBLIC;