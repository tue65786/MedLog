SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Diary_Sent_Log] (
		[SentLogID]                          [int] NOT NULL,
		[PatientID]                          [int] NULL,
		[date_from]                          [date] NULL,
		[date_to]                            [date] NULL,
		[template_id]                        [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[PhysicianID]                        [int] NULL,
		[delivery_method]                    [int] NULL,
		[sent_on]                            [date] NULL,
		[delivered_on]                       [date] NULL,
		[delivery_confirmationn_on]          [date] NULL,
		[include_drug_history_for_range]     [bit] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Diary_Sent_Log]
	ADD
	CONSTRAINT [PK_Diary_Sent_Log]
	PRIMARY KEY
	CLUSTERED
	([SentLogID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Diary_Sent_Log]
	WITH CHECK
	ADD CONSTRAINT [FK_Diary_Sent_Log_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
ALTER TABLE [dbo].[Diary_Sent_Log]
	CHECK CONSTRAINT [FK_Diary_Sent_Log_Patient]

GO
ALTER TABLE [dbo].[Diary_Sent_Log] SET (LOCK_ESCALATION = TABLE)
GO
