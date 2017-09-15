-- Create a group that has basic privileges to connect to this database.
CREATE ROLE basic_access_group;
GRANT CONNECT ON DATABASE sbbc_db TO basic_access_group;
GRANT USAGE ON SCHEMA public TO basic_access_group;

-- Create a group that has read-only privileges on the database.
CREATE ROLE read_group;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO read_group;
GRANT SELECT ON ALL SEQUENCES IN SCHEMA public TO read_group;

-- Create a group that has write-only privileges on the database.
CREATE ROLE write_group;
GRANT TEMP ON DATABASE sbbc_db TO write_group;
GRANT INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO write_group;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public TO write_group;

-- Create users that can log in. Grant privileges to these users via group membership, NOT directly to the users themselves.
CREATE ROLE read_only_user WITH LOGIN IN ROLE basic_access_group, read_group INHERIT;
CREATE ROLE read_write_user WITH LOGIN IN ROLE basic_access_group, read_group, write_group INHERIT;

-- Set up default privileges so that future relations are created with correct access.
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO read_group;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT INSERT, UPDATE, DELETE ON TABLES TO write_group;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE ON SEQUENCES TO write_group;

-- Make sure the only way a user gets privileges is via a group that we purposely grant to that user.
REVOKE ALL PRIVILEGES ON DATABASE sbbc_db FROM PUBLIC;
REVOKE ALL PRIVILEGES ON SCHEMA public FROM PUBLIC;