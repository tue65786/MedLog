SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ReasonForCommunication] (
		[ReasonForCommunicationID]     [int] NOT NULL,
		[ReasonForCommunication]       [varchar](127) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Urgent]                       [bit] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ReasonForCommunication]
	ADD
	CONSTRAINT [PK_ReasonForCommunication]
	PRIMARY KEY
	CLUSTERED
	([ReasonForCommunicationID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[ReasonForCommunication] SET (LOCK_ESCALATION = TABLE)
GO
