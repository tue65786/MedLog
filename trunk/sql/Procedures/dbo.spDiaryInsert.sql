SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 
-- Description:	Inserts  Diary  record
-- =============================================
CREATE PROC [dbo].[spDiaryInsert]
@Title nvarchar (250) 
,@Notes nvarchar (max) 
,@NotesActivity nvarchar (max) = NULL
,@PatientID int
,@USER_FieldAId int
,@created_date datetime
,@updated_date datetime = NULL
,@includce_meds_current nchar (10) = NULL
,@attachment_path nvarchar (255) = NULL
,@USER_FieldA2Id int = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO [dbo].[Diary] ([Title]
,							   [Notes]
,							   [NotesActivity]
,							   [PatientID]
,							   [USER_FieldAId]
,							   [created_date]
,							   [updated_date]
,							   [includce_meds_current]
,							   [attachment_path]
,							   [USER_FieldA2Id]) 
	SELECT @Title
,		   @Notes
,		   @NotesActivity
,		   @PatientID
,		   @USER_FieldAId
,		   @created_date
,		   @updated_date
,		   @includce_meds_current
,		   @attachment_path
,		   @USER_FieldA2Id
	SET @inserted = IDENT_CURRENT ('[dbo].[Diary]') 
END
GO
