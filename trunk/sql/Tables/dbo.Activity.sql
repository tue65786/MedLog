SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[Activity] (
		[ExerciseID]            [int] IDENTITY(1, 1) NOT NULL,
		[PatientID]             [int] NOT NULL,
		[ExerciseTypeID]        [int] NOT NULL,
		[Calories]              [decimal](10, 2) NULL,
		[Steps]                 [int] NULL,
		[Distance]              [decimal](10, 2) NULL,
		[Floors]                [int] NULL,
		[Date]                  [date] NULL,
		[start_time]            [datetime] NULL,
		[end_time]              [time](7) NULL,
		[minutes_peak_hr]       [int] NULL,
		[minutes_target_hr]     [int] NULL,
		[minutes_cardio_hr]     [int] NULL,
		[ActivityMetaData]      [xml] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Activity]
	ADD
	CONSTRAINT [PK_Exercise]
	PRIMARY KEY
	CLUSTERED
	([ExerciseID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Activity]
	WITH CHECK
	ADD CONSTRAINT [FK_Activity_ActivityType1]
	FOREIGN KEY ([ExerciseTypeID]) REFERENCES [dbo].[ActivityType] ([ActivityTypeID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[Activity]
	CHECK CONSTRAINT [FK_Activity_ActivityType1]

GO
ALTER TABLE [dbo].[Activity]
	WITH CHECK
	ADD CONSTRAINT [FK_Activity_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
	ON DELETE CASCADE
ALTER TABLE [dbo].[Activity]
	CHECK CONSTRAINT [FK_Activity_Patient]

GO
ALTER TABLE [dbo].[Activity] SET (LOCK_ESCALATION = TABLE)
GO
