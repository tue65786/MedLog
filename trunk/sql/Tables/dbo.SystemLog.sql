SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SystemLog] (
		[LogID]            [int] NOT NULL,
		[log_type_id]      [int] NULL,
		[log_soiurce]      [nvarchar](2000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[log_message]      [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[log_severity]     [int] NULL,
		[logged_at]        [datetime] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[SystemLog]
	ADD
	CONSTRAINT [PK_SystemLog]
	PRIMARY KEY
	CLUSTERED
	([LogID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[SystemLog] SET (LOCK_ESCALATION = TABLE)
GO
