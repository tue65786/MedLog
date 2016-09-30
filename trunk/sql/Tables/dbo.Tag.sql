SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tag] (
		[Id]            [int] IDENTITY(1, 1) NOT NULL,
		[PatientID]     [int] NOT NULL,
		[TagName]       [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Tag]
	ADD
	CONSTRAINT [PK_Severity]
	PRIMARY KEY
	CLUSTERED
	([Id])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Tag]
	WITH CHECK
	ADD CONSTRAINT [FK_Tag_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[Tag]
	CHECK CONSTRAINT [FK_Tag_Patient]

GO
ALTER TABLE [dbo].[Tag] SET (LOCK_ESCALATION = TABLE)
GO
