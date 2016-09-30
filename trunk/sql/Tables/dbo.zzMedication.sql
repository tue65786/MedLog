SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[zzMedication] (
		[MedicationID]     [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[zzMedication]
	ADD
	CONSTRAINT [PK_Medication]
	PRIMARY KEY
	CLUSTERED
	([MedicationID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[zzMedication] SET (LOCK_ESCALATION = TABLE)
GO
