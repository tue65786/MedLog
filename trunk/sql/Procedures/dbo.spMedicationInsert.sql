SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- |CurrentDate|
CREATE PROC [dbo].[spMedicationInsert] 
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
, @inserted INT OUTPUT
AS 
BEGIN
	SET NOCOUNT ON 
	INSERT INTO [dbo].[Medication] ([PatientID], [PharmID], [PhysicianID], [Instructions], [Sig], [StartDate], [EndDate], [Dosage], [FrequencySig], [Active])
	SELECT @PatientID, @PharmID, @PhysicianID, @Instructions, @Sig, @StartDate, @EndDate, @Dosage, @FrequencySig, @Active      
SET @inserted = Ident_current ('[dbo].[Medication]')
END
GO
