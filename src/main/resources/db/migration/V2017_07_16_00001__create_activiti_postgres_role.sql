CREATE SCHEMA activiti;

-- Create a group that has basic privileges to connect to this database.
CREATE ROLE activiti_user LOGIN;
GRANT CONNECT ON DATABASE sbbc_db TO activiti_user;
GRANT USAGE ON SCHEMA activiti TO activiti_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA activiti TO activiti_user;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA activiti TO activiti_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA activiti GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO activiti_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA activiti GRANT USAGE ON SEQUENCES TO activiti_user;