SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- |CurrentDate|
CREATE PROC [dbo].[spTagInsert] 
    @PatientID int,
    @TagName nvarchar(256)
, @inserted INT OUTPUT
AS 
BEGIN
	SET NOCOUNT ON 
	INSERT INTO [dbo].[Tag] ([PatientID], [TagName])
	SELECT @PatientID, @TagName      
SET @inserted = Ident_current ('[dbo].[Tag]')
END
GO
