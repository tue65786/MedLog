SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 
-- Description:	Updates diary  record
-- =============================================
CREATE PROC [dbo].[spDiaryUpdate]
@Id int
,@Title nvarchar (250) 
,@Notes nvarchar (max) 
,@NotesActivity nvarchar (max) = NULL
,@PatientID int
,@USER_FieldAId int
,@created_date datetime
,@updated_date datetime = NULL
,@includce_meds_current nchar (10) = NULL
,@attachment_path nvarchar (255) = NULL
,@USER_FieldA2Id int = NULL
AS
/*
TODO add ISNULL(
*/
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Diary]
	SET    [Title] = ISNULL(@Title,Title)
,		   [Notes] = @Notes
,		   [NotesActivity] = @NotesActivity
,		   [PatientID] = @PatientID
,		   [USER_FieldAId] = @USER_FieldAId
,		   [created_date] = @created_date
,		   [updated_date] = @updated_date
,		   [includce_meds_current] = @includce_meds_current
,		   [attachment_path] = @attachment_path
,		   [USER_FieldA2Id] = @USER_FieldA2Id
	WHERE  [Id] = @Id

END
GO
