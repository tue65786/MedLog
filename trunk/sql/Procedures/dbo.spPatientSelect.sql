SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-19
-- Description:	Retrieves patient by ID, userName, or userName & password
-- =============================================

CREATE PROC [dbo].[spPatientSelect] 
    @PatientID int = NULL
,	@userName nvarchar(512) = NULL
,	@password nvarchar(512) = NULL
AS 
	

	SELECT [PatientID], [userName], [userPassword], [user_hash], [firstName], [lastName], [phoneHome], [phoneMobile], [email], [status], [addressStreet], [addressCity], [addressState], [address_country], [address_postalcode], [user_preferences], [pwd_last_changed], [lang], [timezone_id], [primary_physsician], [date_of_birth], [date_joined], [picture], [meta_data], [userRole] 
	FROM   [dbo].[Patient] 
	WHERE  (([PatientID] = @PatientID OR @PatientID IS NULL)
			AND LOWER(userName) = LOWER(@userName) OR @userName = NULL
			AND userPassword = @password OR @password IS NULL) 

	
GO
