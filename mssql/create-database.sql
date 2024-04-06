IF NOT EXISTS(SELECT *
FROM sys.databases
WHERE name = 'demoDB')
BEGIN
    CREATE DATABASE demoDB
END
    GO

select Name
from sys.databases 