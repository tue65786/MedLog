SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spMedicationDelete] 
    @MedicationID int
AS 
	SET NOCOUNT OFF 

	DELETE
	FROM   [dbo].[Medication]
	WHERE  [MedicationID] = @MedicationID
	
GO
