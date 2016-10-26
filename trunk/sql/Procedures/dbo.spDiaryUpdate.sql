SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-22
-- Description:	Updates  Diary record
-- =============================================
CREATE PROC [dbo].[spDiaryUpdate]
 @Id int
,@PatientID int
,@Title nvarchar (250) = NULL 
,@Notes nvarchar (max) 
,@NotesActivity nvarchar (max) = NULL
,@createdDate datetime = NULL
,@updatedDate datetime = GETDATE
,@includce_meds_current nchar (10) = NULL
,@attachmentPath nvarchar (255) = NULL
,@ratingMood int = NULL
,@ratingProductivity int = NULL
,@USER_FieldA2Id int = NULL
,@USER_FieldAId int = NULL
AS
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Diary]
	SET    [PatientID] = @PatientID
,		   [Title] = ISNULL(@Title,Title)
,		   [Notes] = @Notes
,		   [NotesActivity] = @NotesActivity
,		   [createdDate] = ISNULL (@createdDate , createdDate) 
,		   [updatedDate] = @updatedDate
,		   [includce_meds_current] = @includce_meds_current
,		   [attachmentPath] = @attachmentPath
,		   [ratingMood] = @ratingMood
,		   [ratingProductivity] = @ratingProductivity
,		   [USER_FieldA2Id] = @USER_FieldA2Id
,		   [USER_FieldAId] = @USER_FieldAId
	WHERE  [Id] = @Id

END
GO
