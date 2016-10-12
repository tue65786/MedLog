SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[spMedicationSelect] 
    @MedicationID int
AS 
	SET NOCOUNT ON 


	SELECT [MedicationID], [PatientID], [PharmID], [PhysicianID], [Instructions], [Sig], [StartDate], [EndDate], [Dosage], [FrequencySig], [Active] 
	FROM   [dbo].[Medication] 
	WHERE  ([MedicationID] = @MedicationID OR @MedicationID IS NULL) 

	
GO
