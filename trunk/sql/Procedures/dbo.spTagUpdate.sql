SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- |CurrentDate|
CREATE PROC [dbo].[spTagUpdate] 
    @Id int,
    @PatientID int,
    @TagName nvarchar(256)
AS 
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Tag]
	SET    [PatientID] = @PatientID, [TagName] = @TagName
	WHERE  [Id] = @Id
	
END
GO
