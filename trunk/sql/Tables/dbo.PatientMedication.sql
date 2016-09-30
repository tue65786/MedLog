SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[PatientMedication] (
		[PatientID]        [int] NOT NULL,
		[MedicationID]     [int] NOT NULL,
		[Date]             [date] NULL,
		[Time]             [time](7) NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientMedication]
	ADD
	CONSTRAINT [PK_PatientMedication]
	PRIMARY KEY
	CLUSTERED
	([PatientID], [MedicationID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientMedication]
	WITH CHECK
	ADD CONSTRAINT [FK_PatientMedication_Medication]
	FOREIGN KEY ([MedicationID]) REFERENCES [dbo].[Medication] ([MedicationID])
ALTER TABLE [dbo].[PatientMedication]
	CHECK CONSTRAINT [FK_PatientMedication_Medication]

GO
ALTER TABLE [dbo].[PatientMedication]
	WITH CHECK
	ADD CONSTRAINT [FK_PatientMedication_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
ALTER TABLE [dbo].[PatientMedication]
	CHECK CONSTRAINT [FK_PatientMedication_Patient]

GO
ALTER TABLE [dbo].[PatientMedication] SET (LOCK_ESCALATION = TABLE)
GO
