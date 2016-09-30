SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Nurse] (
		[EmployeeID]     [int] NOT NULL,
		[Name]           [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[Position]       [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[Registered]     [bit] NOT NULL,
		[SSN]            [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Nurse]
	ADD
	CONSTRAINT [PK__Nurse__7AD04FF15070F446]
	PRIMARY KEY
	CLUSTERED
	([EmployeeID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Nurse] SET (LOCK_ESCALATION = TABLE)
GO
