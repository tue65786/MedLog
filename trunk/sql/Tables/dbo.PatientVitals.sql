SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[PatientVitals] (
		[PatientID]      [int] NOT NULL,
		[height_cm]      [decimal](18, 2) NULL,
		[weight_kg]      [decimal](18, 4) NULL,
		[VitalsMeta]     [xml] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientVitals]
	ADD
	CONSTRAINT [PK_PatientVitals]
	PRIMARY KEY
	CLUSTERED
	([PatientID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientVitals]
	WITH CHECK
	ADD CONSTRAINT [FK_PatientVitals_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
	ON DELETE CASCADE
	ON UPDATE CASCADE
ALTER TABLE [dbo].[PatientVitals]
	CHECK CONSTRAINT [FK_PatientVitals_Patient]

GO
ALTER TABLE [dbo].[PatientVitals] SET (LOCK_ESCALATION = TABLE)
GO
