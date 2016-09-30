SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[CommunicationLog] (
		[CommunicationLogID]         [int] NOT NULL,
		[PatientID]                  [int] NULL,
		[PhysicianID]                [int] NULL,
		[date]                       [datetime] NULL,
		[ReasonForCommunication]     [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CommunicationLog]
	WITH CHECK
	ADD CONSTRAINT [FK_CommunicationLog_Patient]
	FOREIGN KEY ([PatientID]) REFERENCES [dbo].[Patient] ([PatientID])
	ON DELETE SET NULL
ALTER TABLE [dbo].[CommunicationLog]
	CHECK CONSTRAINT [FK_CommunicationLog_Patient]

GO
ALTER TABLE [dbo].[CommunicationLog]
	WITH CHECK
	ADD CONSTRAINT [FK_CommunicationLog_Physician]
	FOREIGN KEY ([PhysicianID]) REFERENCES [dbo].[HealthcareProvider] ([PhysicianID])
	ON DELETE SET NULL
ALTER TABLE [dbo].[CommunicationLog]
	CHECK CONSTRAINT [FK_CommunicationLog_Physician]

GO
ALTER TABLE [dbo].[CommunicationLog]
	WITH CHECK
	ADD CONSTRAINT [FK_CommunicationLog_ReasonForCommunication]
	FOREIGN KEY ([ReasonForCommunication]) REFERENCES [dbo].[ReasonForCommunication] ([ReasonForCommunicationID])
ALTER TABLE [dbo].[CommunicationLog]
	CHECK CONSTRAINT [FK_CommunicationLog_ReasonForCommunication]

GO
ALTER TABLE [dbo].[CommunicationLog] SET (LOCK_ESCALATION = TABLE)
GO
