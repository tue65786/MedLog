SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Sigs] (
		[SigAbbrID]      [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Definition]     [varchar](150) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[category]       [varchar](150) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Sigs] SET (LOCK_ESCALATION = TABLE)
GO
