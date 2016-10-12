SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spTagDelete] 
    @Id int
AS 
	SET NOCOUNT OFF 
	
	DELETE
	FROM   [dbo].[Tag]
	WHERE  [Id] = @Id
	
GO
