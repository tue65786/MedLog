SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-25
-- Description:	Inserts  Diary record
-- =============================================
CREATE PROC [dbo].[spDiaryInsert]
@PatientID int
,@Title nvarchar (250) 
,@Notes nvarchar (max) 
,@NotesActivity nvarchar (max) = NULL
,@createdDate datetime = NULL
,@updatedDate datetime = NULL
,@includce_meds_current nchar (10) = NULL
,@attachmentPath nvarchar (255) = NULL
,@ratingMood int = NULL
,@ratingProductivity int = NULL--,
--@USER_FieldA2Id int = NULL,
--@USER_FieldAId int = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO [dbo].[Diary] ([PatientID]
,							   [Title]
,							   [Notes]
,							   [NotesActivity]
,							   [createdDate]
,							   [updatedDate]
,							   [includce_meds_current]
,							   [attachmentPath]
,							   [ratingMood]
,							   [ratingProductivity]
,							   [USER_FieldA2Id]
,							   [USER_FieldAId]) 
	SELECT @PatientID
,		   @Title
,		   @Notes
,		   @NotesActivity
,		   ISNULL(@createdDate,GETDATE())
,		   @updatedDate
,		   @includce_meds_current
,		   @attachmentPath
,		   @ratingMood
,		   @ratingProductivity
,		   NULL
,		   NULL
	SET @inserted = IDENT_CURRENT ('[dbo].[Diary]') 
END
GO
