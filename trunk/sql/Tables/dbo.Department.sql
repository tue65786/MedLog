SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Department] (
		[DepartmentID]     [int] NOT NULL,
		[Name]             [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[Head]             [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Department]
	ADD
	CONSTRAINT [PK__Departme__B2079BCD300424B4]
	PRIMARY KEY
	CLUSTERED
	([DepartmentID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Department]
	WITH CHECK
	ADD CONSTRAINT [fk_Physician_EmployeeID]
	FOREIGN KEY ([Head]) REFERENCES [dbo].[HealthcareProvider] ([PhysicianID])
ALTER TABLE [dbo].[Department]
	CHECK CONSTRAINT [fk_Physician_EmployeeID]

GO
ALTER TABLE [dbo].[Department] SET (LOCK_ESCALATION = TABLE)
GO
