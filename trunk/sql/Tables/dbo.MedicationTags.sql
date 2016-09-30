SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[MedicationTags] (
		[MedicationID]     [int] NOT NULL,
		[TagID]            [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[MedicationTags]
	ADD
	CONSTRAINT [PK_MedicationTags]
	PRIMARY KEY
	CLUSTERED
	([MedicationID], [TagID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[MedicationTags]
	WITH CHECK
	ADD CONSTRAINT [FK_MedicationTags_Medication]
	FOREIGN KEY ([MedicationID]) REFERENCES [dbo].[Medication] ([MedicationID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[MedicationTags]
	CHECK CONSTRAINT [FK_MedicationTags_Medication]

GO
ALTER TABLE [dbo].[MedicationTags]
	WITH CHECK
	ADD CONSTRAINT [FK_MedicationTags_Tag]
	FOREIGN KEY ([TagID]) REFERENCES [dbo].[Tag] ([Id])
	ON DELETE CASCADE
ALTER TABLE [dbo].[MedicationTags]
	CHECK CONSTRAINT [FK_MedicationTags_Tag]

GO
ALTER TABLE [dbo].[MedicationTags] SET (LOCK_ESCALATION = TABLE)
GO
