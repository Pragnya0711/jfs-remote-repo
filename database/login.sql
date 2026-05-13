-- login.sql
-- This file is executed automatically when SQL*Plus starts

-- Set SQL prompt
SET SQLPROMPT "_USER'@'_CONNECT_IDENTIFIER > "

-- Display current user and database
COLUMN user_name NEW_VALUE user_var
COLUMN db_name NEW_VALUE db_var

SELECT USER AS user_name,
       SYS_CONTEXT('USERENV','DB_NAME') AS db_name
FROM dual;

PROMPT Connected to &user_var on database &db_var

-- Formatting settings
SET LINESIZE 200
SET PAGESIZE 50
SET LONG 10000
SET TRIMSPOOL ON
SET TAB OFF

-- Date format
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';

-- Enable timing
SET TIMING ON

-- Show null values clearly
SET NULL '[NULL]'

-- Turn on server output
SET SERVEROUTPUT ON SIZE 1000000

-- Command history (for SQLcl / SQL Developer)
SET HISTORY ON

-- Optional: define editor
DEFINE _EDITOR = vi

-- End of login.sql
