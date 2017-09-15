-- Create a group that has basic privileges to connect to this database.
CREATE ROLE analytics_read_only_user LOGIN;
GRANT CONNECT ON DATABASE sbbc_db TO analytics_read_only_user;
GRANT USAGE ON SCHEMA public, activiti TO analytics_read_only_user;

GRANT SELECT ON ALL TABLES IN SCHEMA public, activiti TO analytics_read_only_user;
GRANT SELECT ON ALL SEQUENCES IN SCHEMA public, activiti TO analytics_read_only_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public, activiti GRANT SELECT ON TABLES TO analytics_read_only_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public, activiti GRANT SELECT ON SEQUENCES TO analytics_read_only_user;