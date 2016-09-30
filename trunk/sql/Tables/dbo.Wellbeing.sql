SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Wellbeing] (
		[WellbeingID]     [int] NOT NULL,
		[Date]            [datetime] NULL,
		[Diary]           [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Wellbeing]
	ADD
	CONSTRAINT [PK_Wellbeing]
	PRIMARY KEY
	CLUSTERED
	([WellbeingID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Wellbeing] SET (LOCK_ESCALATION = TABLE)
GO
