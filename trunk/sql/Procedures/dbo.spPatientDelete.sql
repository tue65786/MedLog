SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 
-- Description:	Deletes patient record
-- =============================================
CREATE PROC [dbo].[spPatientDelete]
@PatientID int
AS
BEGIN
	SET NOCOUNT OFF

	DELETE
	FROM   [dbo].[Patient]
	WHERE  [PatientID] = @PatientID
END

GO
