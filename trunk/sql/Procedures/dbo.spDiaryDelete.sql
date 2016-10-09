SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K., MedLog
-- Create date: 2016-10-10
-- Modify date: 
-- Description:	Deletes diary record
-- =============================================
CREATE PROC [dbo].[spDiaryDelete]
@Id int
AS
BEGIN
	SET NOCOUNT OFF
	DELETE
	FROM   [dbo].[Diary]
	WHERE  [Id] = @Id
END

GO
