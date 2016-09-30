SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PatienLogType] (
		[PatientLogTypeID]           [int] NOT NULL,
		[PatientLogTypeName]         [varchar](250) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[PatientLogTypeDataType]     [varchar](250) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatienLogType]
	ADD
	CONSTRAINT [PK_PatienLogType]
	PRIMARY KEY
	CLUSTERED
	([PatientLogTypeID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatienLogType] SET (LOCK_ESCALATION = TABLE)
GO
