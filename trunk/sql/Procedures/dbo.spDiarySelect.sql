SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[spDiarySelect]
@Id int = NULL
, @PatientID int
, @Keyword nvarchar (128) 
AS
SET NOCOUNT ON
--TODO ADD DATE FILTERS
SELECT [Id]
,	   [PatientID]
,	   [Title]
,	   [Notes]
,	   [NotesActivity]
,	   [createdDate]
,	   [updatedDate]
,	   [includce_meds_current]
,	   [attachmentPath]
,	   [ratingMood]
,	   [ratingProductivity]
,	   [USER_FieldA2Id]
,	   [USER_FieldAId]
	   FROM [dbo].[Diary]
	   WHERE  ([Id] = @Id OR @Id IS NULL) 
		  AND @PatientID = PatientID  -- Patient
		  AND ((@Keyword IS NOT NULL
			AND ((LOWER (Title) LIKE '%' + LOWER (@keyword) + '%') --Keyword
			  OR Notes LIKE '%' + @keyword + '%')) 
			OR @Keyword IS NULL) 
		   OR ( @Keyword IS NOT NULL
			AND ID IN (
				SELECT  -- FT Search
				TOP 15 ID
					   FROM Diary
								JOIN CONTAINSTABLE (Diary , * , @keyword) FTS
									ON Diary.ID = FTS.[KEY]
					   WHERE PatientID = @PatientID
					   ORDER BY
					   FTS.Rank DESC))

GO
