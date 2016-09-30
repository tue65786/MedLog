SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HealthcareProvider] (
		[PhysicianID]                               [int] NOT NULL,
		[last_name]                                 [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[first_name]                                [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[specialty]                                 [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[WorkPhone]                                 [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[CellPhone]                                 [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Pager]                                     [varbinary](50) NULL,
		[Email]                                     [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[Fax]                                       [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[pathient_log_communication_preference]     [varchar](20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[HealthcareProvider]
	ADD
	CONSTRAINT [PK__Physicia__7AD04FF12C3393D0]
	PRIMARY KEY
	CLUSTERED
	([PhysicianID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[HealthcareProvider] SET (LOCK_ESCALATION = TABLE)
GO
