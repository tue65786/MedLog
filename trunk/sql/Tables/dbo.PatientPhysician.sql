SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[PatientPhysician] (
		[PatientID]       [int] NOT NULL,
		[PhysicianID]     [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientPhysician]
	ADD
	CONSTRAINT [PK_PatientPhysician]
	PRIMARY KEY
	CLUSTERED
	([PatientID], [PhysicianID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientPhysician]
	WITH CHECK
	ADD CONSTRAINT [FK_PatientPhysician_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
ALTER TABLE [dbo].[PatientPhysician]
	CHECK CONSTRAINT [FK_PatientPhysician_Patient]

GO
ALTER TABLE [dbo].[PatientPhysician]
	WITH CHECK
	ADD CONSTRAINT [FK_PatientPhysician_Physician]
	FOREIGN KEY ([PhysicianID]) REFERENCES [dbo].[HealthcareProvider] ([PhysicianID])
ALTER TABLE [dbo].[PatientPhysician]
	CHECK CONSTRAINT [FK_PatientPhysician_Physician]

GO
ALTER TABLE [dbo].[PatientPhysician] SET (LOCK_ESCALATION = TABLE)
GO
