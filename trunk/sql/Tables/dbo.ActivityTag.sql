SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[ActivityTag] (
		[ExerciseID]     [int] NOT NULL,
		[TagID]          [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ActivityTag]
	ADD
	CONSTRAINT [PK_ActivityTag]
	PRIMARY KEY
	CLUSTERED
	([ExerciseID], [TagID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[ActivityTag]
	WITH CHECK
	ADD CONSTRAINT [FK_ActivityTag_Activity]
	FOREIGN KEY ([ExerciseID]) REFERENCES [dbo].[Activity] ([ExerciseID])
ALTER TABLE [dbo].[ActivityTag]
	CHECK CONSTRAINT [FK_ActivityTag_Activity]

GO
ALTER TABLE [dbo].[ActivityTag]
	WITH CHECK
	ADD CONSTRAINT [FK_ActivityTag_Tag]
	FOREIGN KEY ([TagID]) REFERENCES [dbo].[Tag] ([Id])
ALTER TABLE [dbo].[ActivityTag]
	CHECK CONSTRAINT [FK_ActivityTag_Tag]

GO
ALTER TABLE [dbo].[ActivityTag] SET (LOCK_ESCALATION = TABLE)
GO
