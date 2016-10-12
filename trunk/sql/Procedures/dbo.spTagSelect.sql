SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

-- date created........: |CurrentDate|

CREATE PROC [dbo].[spTagSelect] 
    @Id int
AS 
	SET NOCOUNT ON 
	
	SELECT [Id], [PatientID], [TagName] 
	FROM   [dbo].[Tag] 
	WHERE  ([Id] = @Id OR @Id IS NULL) 

GO
