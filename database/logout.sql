-- logout.sql
-- Script to execute clean-up tasks before logging out

PROMPT Logging out from Oracle session...

-- Show user and database before exit
COLUMN user_name NEW_VALUE user_var
COLUMN db_name NEW_VALUE db_var

SELECT USER AS user_name,
       SYS_CONTEXT('USERENV','DB_NAME') AS db_name
FROM dual;

PROMPT Goodbye &user_var from &db_var

-- Disable server output
SET SERVEROUTPUT OFF

-- Turn off timing
SET TIMING OFF

-- Clear screen (optional)
CLEAR SCREEN

-- Exit session
EXIT
