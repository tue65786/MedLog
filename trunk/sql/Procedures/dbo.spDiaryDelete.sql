SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-22
-- Description:	Deletes  Diary record
-- =============================================
CREATE PROC [dbo].[spDiaryDelete]
@Id int
AS
SET NOCOUNT OFF
DELETE
FROM   [dbo].[Diary]
WHERE  [Id] = @Id
GO
