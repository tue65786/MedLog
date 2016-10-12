SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LogData] (
		[LogDataID]          [int] NOT NULL,
		[LogDataType]        [smallint] NOT NULL,
		[LogIntData]         [int] NULL,
		[LogStringData]      [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[LogNumericData]     [numeric](18, 0) NULL,
		[LogMetaData]        [xml] NULL,
		[LogAtttach]         [varbinary](max) NULL,
		[PatientLogID]       [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[LogData]
	ADD
	CONSTRAINT [PK_LogData]
	PRIMARY KEY
	CLUSTERED
	([LogDataID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[LogData] SET (LOCK_ESCALATION = TABLE)
GO
