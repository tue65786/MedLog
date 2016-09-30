SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Diary] (
		[Id]                        [int] IDENTITY(1, 1) NOT NULL,
		[Title]                     [nvarchar](250) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[Notes]                     [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[PatientID]                 [int] NOT NULL,
		[USER_FieldAId]             [int] NOT NULL,
		[created_date]              [datetime] NOT NULL,
		[updated_date]              [datetime] NULL,
		[includce_meds_current]     [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[attachment_path]           [nvarchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
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
	DEFAULT (getdate()) FOR [created_date]
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
ALTER TABLE [dbo].[Diary] SET (LOCK_ESCALATION = TABLE)
GO
