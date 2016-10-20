SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Patient] (
		[PatientID]              [int] IDENTITY(1, 1) NOT NULL,
		[userName]               [nvarchar](60) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[userPassword]           [nvarchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[user_hash]              [nvarchar](32) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[firstName]              [nvarchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[lastName]               [nvarchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[phoneHome]              [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[phoneMobile]            [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[email]                  [nvarchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[status]                 [nvarchar](25) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[addressStreet]          [nvarchar](150) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[addressCity]            [nvarchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[addressState]           [int] NULL,
		[address_country]        [nvarchar](25) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[address_postalcode]     [nvarchar](9) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[user_preferences]       [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[pwd_last_changed]       [datetime] NULL,
		[lang]                   [nvarchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[timezone_id]            [nvarchar](128) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[primary_physsician]     [int] NULL,
		[date_of_birth]          [bit] NULL,
		[date_joined]            [date] NOT NULL,
		[picture]                [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[meta_data]              [xml] NULL,
		[userRole]               [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Patient]
	ADD
	CONSTRAINT [PK__Patient__970EC34674794A92]
	PRIMARY KEY
	CLUSTERED
	([PatientID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Patient]
	ADD
	CONSTRAINT [DF__Patient__date_jo__76619304]
	DEFAULT (getdate()) FOR [date_joined]
GO
ALTER TABLE [dbo].[Patient]
	WITH CHECK
	ADD CONSTRAINT [FK_Patient_Physician]
	FOREIGN KEY ([primary_physsician]) REFERENCES [dbo].[HealthcareProvider] ([PhysicianID])
ALTER TABLE [dbo].[Patient]
	CHECK CONSTRAINT [FK_Patient_Physician]

GO
ALTER TABLE [dbo].[Patient]
	WITH CHECK
	ADD CONSTRAINT [FK_Patient_State]
	FOREIGN KEY ([addressState]) REFERENCES [dbo].[State] ([StateID])
ALTER TABLE [dbo].[Patient]
	CHECK CONSTRAINT [FK_Patient_State]

GO
ALTER TABLE [dbo].[Patient] SET (LOCK_ESCALATION = TABLE)
GO
