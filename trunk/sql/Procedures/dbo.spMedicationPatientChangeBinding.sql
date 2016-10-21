SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].spMedicationPatientChangeBinding
@PatientID int,
@PharmID int,
@PhysicanID int=NULL,
@Instructions nvarchar(max) = NULL,
@Sig varchar(50),
@StartDate date = getdate,
@endDate date = NULL,
@active bit = 1

AS
IF @endDate is null
SET @endDate = dateadd(year,1,getdate())

SET NOCOUNT OFF
IF (@active = 1)
BEGIN
  IF NOT EXISTS(SELECT 1 FROM dbo.Medication WHERE PatientID = @PatientID AND @PharmID = PharmID)
  BEGIN
    INSERT INTO [dbo].Medication(PatientID, PharmID,PhysicianID,Sig,StartDate,EndDate) VALUES(@PatientID, @PharmID, @PhysicanID,@Sig,@StartDate,@endDate)
  END
  ELSE
  	BEGIN
  		  UPDATE Medication SET  Instructions = ISNULL(@Instructions,Instructions), EndDate = ISNULL(@endDate,EndDate),Active = ISNULL(@active,1)
  		   WHERE  PatientID = @PatientID AND @PharmID = PharmID
  	END 	
END
ELSE
BEGIN
  UPDATE  dbo.Medication SET Active = 1 WHERE  PatientID = @PatientID AND @PharmID = PharmID
END
RETURN @@ROWCOUNT


GO
