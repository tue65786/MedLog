SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ActivityType] (
		[ActivityTypeID]          [int] NOT NULL,
		[activitiy_type_name]     [nvarchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ActivityType]
	ADD
	CONSTRAINT [PK_ActivityType]
	PRIMARY KEY
	CLUSTERED
	([ActivityTypeID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[ActivityType] SET (LOCK_ESCALATION = TABLE)
GO
