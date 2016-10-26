SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-21
-- Modify date: 2016-10-24
-- Description:	UPDATE
-- =============================================
CREATE PROC [dbo].[spHealthcareProviderUpdate]
@PhysicianID int
,@lastname nvarchar (max) 
,@firstname nvarchar (max) 
,@specialty nvarchar (256) = NULL
,@phoneWork nvarchar (256) 
,@phoneMobile nvarchar (256) = NULL
,@phonePager varbinary (50) = NULL
,@phoneFax nchar (10) = NULL
,@email nvarchar (256) = NULL
,@pathient_log_communication_preference varchar (20) = NULL
,@addressStreet nvarchar (512) = NULL
,@addressCity nvarchar (128) = NULL
,@addressStateID int = NULL
,@addressZip varchar (10) = NULL
AS
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[HealthcareProvider]
	SET     [lastname] = @lastname
,		   [firstname] = @firstname
,		   [specialty] = @specialty
,		   [phoneWork] = @phoneWork
,		   [phoneMobile] = @phoneMobile
,		   [phonePager] = @phonePager
,		   [phoneFax] = @phoneFax
,		   [email] = @email
,		   [pathient_log_communication_preference] = @pathient_log_communication_preference
,		   [addressStreet] = @addressStreet
,		   [addressCity] = @addressCity
,		   [addressStateID] = @addressStateID
,		   [addressZip] = @addressZip
	WHERE  [PhysicianID] = @PhysicianID

END
GO
