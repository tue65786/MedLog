SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-21
-- Modify date: 2016-10-24
-- Description:	SELECT
-- =============================================
CREATE PROC [dbo].[spHealthcareProviderSelect]
@PhysicianID int = NULL
, @PatientID int = NULL
, @keyword nvarchar (128) =null
AS
--TODO - ADD SEARCH
SET NOCOUNT ON

SELECT [PhysicianID]
,	   [lastname]
,	   [firstname]
,	   [specialty]
,	   [phoneWork]
,	   [phoneMobile]
,	   [phonePager]
,	   [phoneFax]
,	   [email]
,	   [pathient_log_communication_preference]
,	   [addressStreet]
,	   [addressCity]
,	   [addressStateID]
,	   [addressZip]
	   FROM [dbo].[HealthcareProvider]
	   WHERE (([PhysicianID] = @PhysicianID
			OR @PhysicianID IS NULL) 
		  AND ((EXISTS (
						SELECT 1
							   FROM PatientPhysician
							   WHERE @PatientID = PatientID
								 AND PhysicianID = @PhysicianID) 
			 OR @PatientID IS NULL))) 
	   ORDER BY 	UPPER (LASTNAME) , UPPER (FIRSTNAME)
GO
