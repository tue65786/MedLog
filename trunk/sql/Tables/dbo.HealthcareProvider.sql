SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HealthcareProvider] (
		[PhysicianID]                               [int] IDENTITY(1, 1) NOT NULL,
		[lastname]                                  [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[firstname]                                 [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[specialty]                                 [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[phoneWork]                                 [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[phoneMobile]                               [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[phonePager]                                [varbinary](50) NULL,
		[phoneFax]                                  [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[email]                                     [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[pathient_log_communication_preference]     [varchar](20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[addressStreet]                             [nvarchar](512) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[addressCity]                               [nvarchar](128) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[addressStateID]                            [int] NULL,
		[addressZip]                                [varchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
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
ALTER TABLE [dbo].[HealthcareProvider]
	WITH CHECK
	ADD CONSTRAINT [FK_HealthcareProvider_State]
	FOREIGN KEY ([addressStateID]) REFERENCES [dbo].[State] ([StateID])
ALTER TABLE [dbo].[HealthcareProvider]
	CHECK CONSTRAINT [FK_HealthcareProvider_State]

GO
ALTER TABLE [dbo].[HealthcareProvider] SET (LOCK_ESCALATION = TABLE)
GO
