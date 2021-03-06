SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Procedure] (
		[Code]     [int] NOT NULL,
		[Name]     [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[Cost]     [real] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Procedure]
	ADD
	CONSTRAINT [PK__Procedur__A25C5AA63A81B327]
	PRIMARY KEY
	CLUSTERED
	([Code])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Procedure] SET (LOCK_ESCALATION = TABLE)
GO
