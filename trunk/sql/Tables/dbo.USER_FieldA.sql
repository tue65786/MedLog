SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USER_FieldA] (
		[Id]              [int] IDENTITY(1, 1) NOT NULL,
		[PatientID]       [int] NOT NULL,
		[Description]     [nvarchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[Value]           [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[USER_FieldA]
	ADD
	CONSTRAINT [PK_USER_FieldA]
	PRIMARY KEY
	CLUSTERED
	([Id])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[USER_FieldA]
	WITH CHECK
	ADD CONSTRAINT [FK_USER_FieldA_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[USER_FieldA]
	CHECK CONSTRAINT [FK_USER_FieldA_Patient]

GO
ALTER TABLE [dbo].[USER_FieldA] SET (LOCK_ESCALATION = TABLE)
GO
