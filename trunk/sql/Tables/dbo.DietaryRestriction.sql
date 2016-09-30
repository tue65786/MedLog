SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DietaryRestriction] (
		[DietaryRestrictionID]     [int] NOT NULL,
		[Name]                     [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Restrictions]             [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[DietaryRestriction]
	ADD
	CONSTRAINT [PK_Dietary]
	PRIMARY KEY
	CLUSTERED
	([DietaryRestrictionID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[DietaryRestriction] SET (LOCK_ESCALATION = TABLE)
GO
