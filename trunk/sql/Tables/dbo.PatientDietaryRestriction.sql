SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[PatientDietaryRestriction] (
		[PatientID]                [int] NOT NULL,
		[DietaryRestrictionID]     [int] NOT NULL,
		[Active]                   [bit] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientDietaryRestriction]
	ADD
	CONSTRAINT [PK_PatientDietaryRestriction]
	PRIMARY KEY
	CLUSTERED
	([PatientID], [DietaryRestrictionID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[PatientDietaryRestriction]
	WITH CHECK
	ADD CONSTRAINT [FK_PatientDietaryRestriction_DietaryRestriction]
	FOREIGN KEY ([DietaryRestrictionID]) REFERENCES [dbo].[DietaryRestriction] ([DietaryRestrictionID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[PatientDietaryRestriction]
	CHECK CONSTRAINT [FK_PatientDietaryRestriction_DietaryRestriction]

GO
ALTER TABLE [dbo].[PatientDietaryRestriction]
	WITH CHECK
	ADD CONSTRAINT [FK_PatientDietaryRestriction_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[PatientDietaryRestriction]
	CHECK CONSTRAINT [FK_PatientDietaryRestriction_Patient]

GO
ALTER TABLE [dbo].[PatientDietaryRestriction] SET (LOCK_ESCALATION = TABLE)
GO
