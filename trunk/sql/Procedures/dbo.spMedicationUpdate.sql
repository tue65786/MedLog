SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[spMedicationUpdate] 
    @MedicationID int,
    @PatientID int,
    @PharmID int = NULL,
    @PhysicianID int = NULL,
    @Instructions nvarchar(MAX) = NULL,
    @Sig varchar(50),
    @StartDate date,
    @EndDate date = NULL,
    @Dosage nvarchar(256) = NULL,
    @FrequencySig varchar(30) = NULL,
    @Active bit
AS 
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Medication]
	SET    [PatientID] = @PatientID, [PharmID] = @PharmID, [PhysicianID] = @PhysicianID, [Instructions] = @Instructions, [Sig] = @Sig, [StartDate] = @StartDate, [EndDate] = @EndDate, [Dosage] = @Dosage, [FrequencySig] = @FrequencySig, [Active] = @Active
	WHERE  [MedicationID] = @MedicationID
	
END
GO
