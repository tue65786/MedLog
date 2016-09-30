SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Medication] (
		[MedicationID]     [int] IDENTITY(1, 1) NOT NULL,
		[PatientID]        [int] NOT NULL,
		[PharmID]          [int] NULL,
		[PhysicianID]      [int] NULL,
		[Instructions]     [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Sig]              [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[StartDate]        [date] NOT NULL,
		[EndDate]          [date] NULL,
		[Dosage]           [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[FrequencySig]     [varchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Active]           [bit] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Medication]
	ADD
	CONSTRAINT [PK_Medication_1]
	PRIMARY KEY
	CLUSTERED
	([MedicationID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Medication]
	ADD
	CONSTRAINT [DF_Medication_Active]
	DEFAULT ((1)) FOR [Active]
GO
ALTER TABLE [dbo].[Medication]
	ADD
	CONSTRAINT [DF_Medication_StartDate]
	DEFAULT (getdate()) FOR [StartDate]
GO
ALTER TABLE [dbo].[Medication]
	WITH CHECK
	ADD CONSTRAINT [FK_Medication_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
ALTER TABLE [dbo].[Medication]
	CHECK CONSTRAINT [FK_Medication_Patient]

GO
ALTER TABLE [dbo].[Medication]
	WITH CHECK
	ADD CONSTRAINT [FK_Medication_Sig]
	FOREIGN KEY ([Sig]) REFERENCES [dbo].[Sig] ([SigAbbrID])
ALTER TABLE [dbo].[Medication]
	CHECK CONSTRAINT [FK_Medication_Sig]

GO
ALTER TABLE [dbo].[Medication] SET (LOCK_ESCALATION = TABLE)
GO
