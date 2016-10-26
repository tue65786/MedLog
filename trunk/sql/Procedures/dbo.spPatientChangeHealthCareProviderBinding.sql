SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-24
-- Modify date: 2016-10-24
-- Description:	ASSIGN/UNASSIGN
-- =============================================
CREATE PROCEDURE [dbo].[spPatientChangeHealthCareProviderBinding]
@PatientID int
,@PhysicianID int
,@mustAssign bit

AS
BEGIN

	SET NOCOUNT OFF
	IF (@mustAssign = 1) 
		BEGIN
			IF NOT EXISTS (SELECT 1
								  FROM  [dbo].[PatientPhysician]
								  WHERE PatientID = @PatientID
									AND PhysicianID = @PhysicianID) 
				BEGIN
					INSERT INTO [MedLog].[dbo].[PatientPhysician]
					([PatientID]
,					 [PhysicianID]) 
					VALUES
					(
						   @PatientID
						 , @PhysicianID) 
				END
		END
	ELSE
		BEGIN
			DELETE FROM [dbo].[PatientPhysician]
			WHERE PatientID = @PatientID
			  AND PhysicianID = @PhysicianID
		END
	RETURN @@ROWCOUNT
END
GO
