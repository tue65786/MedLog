SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Patient] (
		[PatientID]              [int] IDENTITY(1, 1) NOT NULL,
		[SSN]                    [nvarchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[user_name]              [nvarchar](60) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[user_password]          [nvarchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[user_hash]              [nvarchar](32) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[first_name]             [nvarchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[last_name]              [nvarchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[phone_home]             [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[phone_mobile]           [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[primary_email]          [nvarchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[email2]                 [nvarchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[status]                 [nvarchar](25) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[address_street]         [nvarchar](150) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[address_city]           [nvarchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[address_state]          [nvarchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[address_country]        [nvarchar](25) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[address_postalcode]     [nvarchar](9) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[user_preferences]       [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[pwd_last_changed]       [datetime] NULL,
		[fitbit_auth]            [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[lang]                   [nvarchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[timezone_id]            [nvarchar](128) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[primary_physsician]     [int] NULL,
		[date_of_birth]          [bit] NULL,
		[date_joined]            [date] NOT NULL,
		[picture]                [nvarchar](max) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[meta_data]              [xml] NULL
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
ALTER TABLE [dbo].[Patient] SET (LOCK_ESCALATION = TABLE)
GO
