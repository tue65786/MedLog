SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TrustedDevices] (
		[DeviceID]               [varchar](800) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[PatientID]              [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Trusted]                [bit] NULL,
		[trusted_on]             [date] NULL,
		[expires_after_days]     [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[TrustedDevices]
	ADD
	CONSTRAINT [PK_TrustedDevices]
	PRIMARY KEY
	CLUSTERED
	([DeviceID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[TrustedDevices] SET (LOCK_ESCALATION = TABLE)
GO
