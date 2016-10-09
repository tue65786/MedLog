SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PatientVitals] (
		[PatientID]         [int] NOT NULL,
		[height_cm]         [decimal](18, 2) NULL,
		[weight_kg]         [decimal](18, 4) NULL,
		[vitals_meta]       [xml] NULL,
		[date_recorded]     [datetime] NOT NULL,
		[vitalA_name]       [nvarchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[vitalA_value]      [decimal](18, 4) NULL,
		[vitalB_name]       [nvarchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[vitalB_value]      [decimal](18, 4) NULL
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
	ADD
	CONSTRAINT [DF_PatientVitals_DateRecorded]
	DEFAULT (getdate()) FOR [date_recorded]
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
EXEC sp_addextendedproperty N'MS_Description', N'Extra User Defined Vitals (A and B)', 'SCHEMA', N'dbo', 'TABLE', N'PatientVitals', 'COLUMN', N'vitalA_name'
GO
ALTER TABLE [dbo].[PatientVitals] SET (LOCK_ESCALATION = TABLE)
GO
