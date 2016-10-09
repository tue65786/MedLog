SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[spDiarySelect]
@Id int
AS
BEGIN
	SET NOCOUNT ON

	SELECT [Id]
,		   [Title]
,		   [Notes]
,		   [NotesActivity]
,		   [PatientID]
,		   [USER_FieldAId]
,		   [created_date]
,		   [updated_date]
,		   [includce_meds_current]
,		   [attachment_path]
,		   [USER_FieldA2Id]
		   FROM [dbo].[Diary]
		   WHERE  ([Id] = @Id OR @Id IS NULL) 
END

GO
