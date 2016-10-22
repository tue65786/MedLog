SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Diary] (
		[Id]                        [int] IDENTITY(1, 1) NOT NULL,
		[PatientID]                 [int] NOT NULL,
		[Title]                     [nvarchar](250) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[Notes]                     [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[NotesActivity]             [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[createdDate]               [datetime] NOT NULL,
		[updatedDate]               [datetime] NULL,
		[includce_meds_current]     [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[attachmentPath]            [nvarchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[ratingMood]                [int] NULL,
		[ratingProductivity]        [int] NULL,
		[USER_FieldA2Id]            [int] NULL,
		[USER_FieldAId]             [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Diary]
	ADD
	CONSTRAINT [PK_Diary]
	PRIMARY KEY
	CLUSTERED
	([Id])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Diary]
	ADD
	CONSTRAINT [DF__Diary__CreatedDa__681373AD]
	DEFAULT (getdate()) FOR [createdDate]
GO
ALTER TABLE [dbo].[Diary]
	ADD
	CONSTRAINT [DF_Diary_ratingMood]
	DEFAULT ((1)) FOR [ratingMood]
GO
ALTER TABLE [dbo].[Diary]
	ADD
	CONSTRAINT [DF_Diary_ratingProductivity]
	DEFAULT ((1)) FOR [ratingProductivity]
GO
ALTER TABLE [dbo].[Diary]
	WITH CHECK
	ADD CONSTRAINT [FK_Diary_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[Diary]
	CHECK CONSTRAINT [FK_Diary_Patient]

GO
ALTER TABLE [dbo].[Diary]
	WITH NOCHECK
	ADD CONSTRAINT [FK_Diary_USER_FieldA]
	FOREIGN KEY ([USER_FieldAId]) REFERENCES [dbo].[USER_FieldA] ([Id])
ALTER TABLE [dbo].[Diary]
	CHECK CONSTRAINT [FK_Diary_USER_FieldA]

GO
ALTER TABLE [dbo].[Diary]
	WITH CHECK
	ADD CONSTRAINT [FK_Diary_USER_FieldA1]
	FOREIGN KEY ([USER_FieldA2Id]) REFERENCES [dbo].[USER_FieldA] ([Id])
	ON DELETE CASCADE
ALTER TABLE [dbo].[Diary]
	CHECK CONSTRAINT [FK_Diary_USER_FieldA1]

GO
CREATE FULLTEXT INDEX ON [dbo].[Diary]
	([Title] LANGUAGE 1033, [Notes] LANGUAGE 1033, [NotesActivity] LANGUAGE 1033)
	KEY INDEX [PK_Diary]
	ON (FILEGROUP [PRIMARY], [ftMedLog])
	WITH CHANGE_TRACKING AUTO, STOPLIST SYSTEM
GO
EXEC sp_addextendedproperty N'MS_Description', N'2nd Value To Track', 'SCHEMA', N'dbo', 'TABLE', N'Diary', 'COLUMN', N'USER_FieldA2Id'
GO
ALTER TABLE [dbo].[Diary] SET (LOCK_ESCALATION = TABLE)
GO
