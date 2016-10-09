SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 
-- Description:	Selects Patient record(s)
-- =============================================
CREATE PROC [dbo].[spPatientSelect]
@PatientID int
AS
BEGIN
	SET NOCOUNT ON

	SELECT [PatientID]
,		   [SSN]
,		   [user_name]
,		   [user_password]
,		   [user_hash]
,		   [first_name]
,		   [last_name]
,		   [phone_home]
,		   [phone_mobile]
,		   [primary_email]
,		   [email2]
,		   [status]
,		   [address_street]
,		   [address_city]
,		   [address_state]
,		   [address_country]
,		   [address_postalcode]
,		   [user_preferences]
,		   [pwd_last_changed]
,		   [fitbit_auth]
,		   [lang]
,		   [timezone_id]
,		   [primary_physsician]
,		   [date_of_birth]
,		   [date_joined]
,		   [picture]
,		   [meta_data]
		   FROM [dbo].[Patient]
		   WHERE ([PatientID] = @PatientID
			   OR @PatientID IS NULL) 
END

GO
