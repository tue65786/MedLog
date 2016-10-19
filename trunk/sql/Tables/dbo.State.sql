SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[State] (
		[StateID]               [int] IDENTITY(1, 1) NOT NULL,
		[StateName]             [nvarchar](150) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[StateAbbreviation]     [nchar](2) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[State]
	ADD
	CONSTRAINT [PK_State]
	PRIMARY KEY
	CLUSTERED
	([StateID])
	ON [PRIMARY]
GO
EXEC sp_addextendedproperty N'MS_Description', N'Primary key', 'SCHEMA', N'dbo', 'TABLE', N'State', 'COLUMN', N'StateID'
GO
ALTER TABLE [dbo].[State] SET (LOCK_ESCALATION = TABLE)
GO
