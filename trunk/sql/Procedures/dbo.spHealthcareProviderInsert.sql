SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-21
-- Modify date: 2016-10-24
-- Description:	INSERT
-- =============================================
CREATE PROC [dbo].[spHealthcareProviderInsert]
@lastname nvarchar (max) 
,@firstname nvarchar (max) 
,@specialty nvarchar (256) = NULL
,@phoneWork nvarchar (256) =''
,@phoneMobile nvarchar (256) = NULL
,@phonePager varbinary (50) = NULL
,@phoneFax nchar (10) = NULL
,@email nvarchar (256) = NULL
,@pathient_log_communication_preference varchar (20) = NULL
,@addressStreet nvarchar (512) = NULL
,@addressCity nvarchar (128) = NULL
,@addressStateID int = NULL
,@addressZip varchar (10) = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO [dbo].[HealthcareProvider] (
											[lastname]
,											[firstname]
,											[specialty]
,											[phoneWork]
,											[phoneMobile]
,											[phonePager]
,											[phoneFax]
,											[email]
,											[pathient_log_communication_preference]
,											[addressStreet]
,											[addressCity]
,											[addressStateID]
,											[addressZip]) 
	SELECT 
		   @lastname
,		   @firstname
,		   @specialty
,		   @phoneWork
,		   @phoneMobile
,		   @phonePager
,		   @phoneFax
,		   @email
,		   @pathient_log_communication_preference
,		   @addressStreet
,		   @addressCity
,		   @addressStateID
,		   @addressZip
	SET @inserted = IDENT_CURRENT ('[dbo].[HealthcareProvider]') 
END
GO
