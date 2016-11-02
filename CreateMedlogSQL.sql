USE [MedLog]
GO
/****** Object:  FullTextCatalog [ftMedLog]    Script Date: 11/02/2016 08:46:40 ******/
CREATE FULLTEXT CATALOG [ftMedLog]WITH ACCENT_SENSITIVITY = ON
AS DEFAULT
AUTHORIZATION [dan]
GO
/****** Object:  Table [dbo].[ActivityType]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActivityType](
	[ActivityTypeID] [int] NOT NULL,
	[activitiy_type_name] [nvarchar](255) NULL,
 CONSTRAINT [PK_ActivityType] PRIMARY KEY CLUSTERED 
(
	[ActivityTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LogData]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LogData](
	[LogDataID] [int] NOT NULL,
	[LogDataType] [smallint] NOT NULL,
	[LogIntData] [int] NULL,
	[LogStringData] [nvarchar](max) NULL,
	[LogNumericData] [numeric](18, 0) NULL,
	[LogMetaData] [xml] NULL,
	[LogAtttach] [varbinary](max) NULL,
	[PatientLogID] [int] NOT NULL,
 CONSTRAINT [PK_LogData] PRIMARY KEY CLUSTERED 
(
	[LogDataID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DietaryRestriction]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DietaryRestriction](
	[DietaryRestrictionID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
	[Restrictions] [nvarchar](max) NULL,
 CONSTRAINT [PK_Dietary] PRIMARY KEY CLUSTERED 
(
	[DietaryRestrictionID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sigs]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Sigs](
	[SigAbbrID] [varchar](50) NULL,
	[Definition] [varchar](150) NULL,
	[category] [varchar](150) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Sig]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Sig](
	[SigAbbrID] [varchar](50) NOT NULL,
	[Definition] [varchar](150) NULL,
	[category] [varchar](150) NULL,
 CONSTRAINT [PK_Sig] PRIMARY KEY CLUSTERED 
(
	[SigAbbrID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ReasonForCommunication]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ReasonForCommunication](
	[ReasonForCommunicationID] [int] NOT NULL,
	[ReasonForCommunication] [varchar](127) NULL,
	[Urgent] [bit] NULL,
 CONSTRAINT [PK_ReasonForCommunication] PRIMARY KEY CLUSTERED 
(
	[ReasonForCommunicationID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TrustedDevices]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TrustedDevices](
	[DeviceID] [varchar](800) NOT NULL,
	[PatientID] [nchar](10) NULL,
	[Trusted] [bit] NULL,
	[trusted_on] [date] NULL,
	[expires_after_days] [int] NULL,
 CONSTRAINT [PK_TrustedDevices] PRIMARY KEY CLUSTERED 
(
	[DeviceID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SystemLog]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SystemLog](
	[LogID] [int] NOT NULL,
	[log_type_id] [int] NULL,
	[log_soiurce] [nvarchar](2000) NULL,
	[log_message] [nvarchar](max) NULL,
	[log_severity] [int] NULL,
	[logged_at] [datetime] NULL,
 CONSTRAINT [PK_SystemLog] PRIMARY KEY CLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[State]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[State](
	[StateID] [int] IDENTITY(1,1) NOT NULL,
	[StateName] [nvarchar](150) NOT NULL,
	[StateAbbreviation] [nchar](2) NOT NULL,
 CONSTRAINT [PK_State] PRIMARY KEY CLUSTERED 
(
	[StateID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Primary key' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'State', @level2type=N'COLUMN',@level2name=N'StateID'
GO
/****** Object:  Table [dbo].[MedType]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MedType](
	[MedTypeID] [varchar](16) NOT NULL,
 CONSTRAINT [PK_MedType] PRIMARY KEY CLUSTERED 
(
	[MedTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[spDietaryRestrictionUpdate]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-29
-- Modify date: 
-- Description:	UPDATE
-- =============================================
CREATE PROC [dbo].[spDietaryRestrictionUpdate] 
    @DietaryRestrictionID int
    ,@Name nvarchar(MAX) = NULL
    ,@Restrictions nvarchar(MAX) = NULL
AS 
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[DietaryRestriction]
	SET     [Name] = ISNULL(@Name,Name), [Restrictions] = ISNULL(@Restrictions,Restrictions)
	WHERE  [DietaryRestrictionID] = @DietaryRestrictionID
	
END
GO
/****** Object:  StoredProcedure [dbo].[spStateSelect]    Script Date: 11/02/2016 08:46:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/****** Script for SelectTopNRows command from SSMS  ******/
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-14
-- Modify date: 2016-10-26
-- Description:
-- =============================================
CREATE PROC [dbo].[spStateSelect]
AS
BEGIN
SET NOCOUNT ON;
SELECT [StateID]
      ,[StateName]
      ,[StateAbbreviation]
  FROM [dbo].[State]
  ORDER BY StateAbbreviation
END
GO
/****** Object:  StoredProcedure [dbo].[spSigSelect]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-28
-- Modify date: 2016-10-28
-- Description: Basic fields
-- =============================================

CREATE PROC [dbo].[spSigSelect] 
    @SigAbbrID varchar(50) = null
AS 

	SELECT [SigAbbrID], [Definition], [category] 
	FROM   [dbo].[Sig] 
	WHERE  ([SigAbbrID] = @SigAbbrID OR @SigAbbrID IS NULL) 
	ORDER BY SigAbbrID
GO
/****** Object:  Table [dbo].[Pharma_RX_OTC]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Pharma_RX_OTC](
	[PharmID] [int] IDENTITY(1,1) NOT NULL,
	[MedType] [varchar](16) NULL,
	[RXCUI] [varchar](8) NULL,
	[GENERIC_RXCUI] [varchar](8) NULL,
	[TTY] [varchar](20) NULL,
	[FULL_NAME] [varchar](3000) NOT NULL,
	[RXN_DOSE_FORM] [varchar](100) NULL,
	[FULL_GENERIC_NAME] [varchar](3000) NULL,
	[BRAND_NAME] [varchar](500) NULL,
	[DISPLAY_NAME] [varchar](3000) NULL,
	[ROUTE] [varchar](100) NULL,
	[NEW_DOSE_FORM] [varchar](100) NULL,
	[STRENGTH] [varchar](500) NOT NULL,
	[SUPPRESS_FOR] [varchar](30) NULL,
	[DISPLAY_NAME_SYNONYM] [varchar](500) NULL,
	[IS_RETIRED] [varchar](8) NULL,
	[SXDG_RXCUI] [varchar](8) NULL,
	[SXDG_TTY] [varchar](20) NULL,
	[SXDG_NAME] [varchar](3000) NULL,
	[PSN] [varchar](3000) NULL,
 CONSTRAINT [PK__Pharma_R__16360C9F793DFFAF] PRIMARY KEY CLUSTERED 
(
	[PharmID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HealthcareProvider]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HealthcareProvider](
	[PhysicianID] [int] IDENTITY(1,1) NOT NULL,
	[lastname] [nvarchar](max) NOT NULL,
	[firstname] [nvarchar](max) NOT NULL,
	[specialty] [nvarchar](256) NULL,
	[phoneWork] [nvarchar](256) NOT NULL,
	[phoneMobile] [nvarchar](256) NULL,
	[phonePager] [varbinary](50) NULL,
	[phoneFax] [nchar](10) NULL,
	[email] [nvarchar](256) NULL,
	[pathient_log_communication_preference] [varchar](20) NULL,
	[addressStreet] [nvarchar](512) NULL,
	[addressCity] [nvarchar](128) NULL,
	[addressStateID] [int] NULL,
	[addressZip] [varchar](10) NULL,
 CONSTRAINT [PK__Physicia__7AD04FF12C3393D0] PRIMARY KEY CLUSTERED 
(
	[PhysicianID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Patient]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patient](
	[PatientID] [int] IDENTITY(1,1) NOT NULL,
	[userName] [nvarchar](60) NULL,
	[userPassword] [nvarchar](30) NULL,
	[user_hash] [nvarchar](32) NULL,
	[firstName] [nvarchar](30) NULL,
	[lastName] [nvarchar](30) NULL,
	[phoneHome] [nvarchar](50) NULL,
	[phoneMobile] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[status] [nvarchar](25) NULL,
	[addressStreet] [nvarchar](150) NULL,
	[addressCity] [nvarchar](100) NULL,
	[addressState] [int] NULL,
	[address_country] [nvarchar](25) NULL,
	[address_postalcode] [nvarchar](9) NULL,
	[user_preferences] [nvarchar](max) NULL,
	[pwd_last_changed] [datetime] NULL,
	[lang] [nvarchar](10) NULL,
	[timezone_id] [nvarchar](128) NULL,
	[primary_physsician] [int] NULL,
	[date_of_birth] [date] NULL,
	[date_joined] [date] NOT NULL,
	[picture] [nvarchar](max) NULL,
	[meta_data] [xml] NULL,
	[userRole] [int] NULL,
 CONSTRAINT [PK__Patient__970EC34674794A92] PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[spPharma_RX_OTCUpdate]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-25
-- Modify date: 2016-10-26
-- Description:
-- =============================================
CREATE PROC [dbo].[spPharma_RX_OTCUpdate]
@PharmID int
,@MedType varchar (16) = NULL
,@RXCUI varchar (8) 
,@GENERIC_RXCUI varchar (8) = NULL
,@TTY varchar (20) 
,@FULL_NAME varchar (3000) 
,@RXN_DOSE_FORM varchar (100) 
,@FULL_GENERIC_NAME varchar (3000) 
,@BRAND_NAME varchar (500) = NULL
,@DISPLAY_NAME varchar (3000) 
,@ROUTE varchar (100) 
,@NEW_DOSE_FORM varchar (100) 
,@STRENGTH varchar (500) 
,@SUPPRESS_FOR varchar (30) = NULL
,@DISPLAY_NAME_SYNONYM varchar (500) = NULL
,@IS_RETIRED varchar (8) = NULL
,@SXDG_RXCUI varchar (8) = NULL
,@SXDG_TTY varchar (20) = NULL
,@SXDG_NAME varchar (3000) = NULL
,@PSN varchar (3000) = NULL
AS
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Pharma_RX_OTC]
	SET    [MedType] = @MedType
,		   [RXCUI] = @RXCUI
,		   [GENERIC_RXCUI] = @GENERIC_RXCUI
,		   [TTY] = @TTY
,		   [FULL_NAME] = @FULL_NAME
,		   [RXN_DOSE_FORM] = @RXN_DOSE_FORM
,		   [FULL_GENERIC_NAME] = @FULL_GENERIC_NAME
,		   [BRAND_NAME] = @BRAND_NAME
,		   [DISPLAY_NAME] = @DISPLAY_NAME
,		   [ROUTE] = @ROUTE
,		   [NEW_DOSE_FORM] = @NEW_DOSE_FORM
,		   [STRENGTH] = @STRENGTH
,		   [SUPPRESS_FOR] = @SUPPRESS_FOR
,		   [DISPLAY_NAME_SYNONYM] = @DISPLAY_NAME_SYNONYM
,		   [IS_RETIRED] = @IS_RETIRED
,		   [SXDG_RXCUI] = @SXDG_RXCUI
,		   [SXDG_TTY] = @SXDG_TTY
,		   [SXDG_NAME] = @SXDG_NAME
,		   [PSN] = @PSN
	WHERE  [PharmID] = @PharmID

END
GO
/****** Object:  StoredProcedure [dbo].[spPharma_RX_OTCSelectShort]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-28
-- Modify date: 
-- Description: Basic fields
-- =============================================
create PROC [dbo].[spPharma_RX_OTCSelectShort]
--declare 
@PharmID int = null
, @Keyword nvarchar (128) =null

AS
SELECT
ROW_NUMBER() OVER (ORDER BY  DISPLAY_NAME,STRENGTH) AS Row
, d.PharmID
, d.MedType
, d.RXCUI
--, d.GENERIC_RXCUI
, d.TTY
--, d.FULL_NAME
--, d.RXN_DOSE_FORM
--, d.FULL_GENERIC_NAME
--, d.BRAND_NAME
, d.DISPLAY_NAME
---, d.ROUTE

--, d.NEW_DOSE_FORM

, d.STRENGTH
--, d.SUPPRESS_FOR
--, d.DISPLAY_NAME_SYNONYM
--, d.IS_RETIRED

--, d.SXDG_RXCUI
--, d.SXDG_TTY
--, d.SXDG_NAME
--, d.PSN 
FROM Pharma_RX_OTC d
WHERE (d.FULL_NAME like '%' + @keyword +'%' 
OR d.BRAND_NAME like '%' + @keyword +'%' 
OR d.FULL_GENERIC_NAME like '%' + @keyword +'%' 
OR @keyword  is NULL)

ORDER BY DISPLAY_NAME,STRENGTH
GO
/****** Object:  StoredProcedure [dbo].[spPharma_RX_OTCSelect]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-26
-- Modify date: 2016-10-28
-- Description:
-- =============================================
CREATE PROC [dbo].[spPharma_RX_OTCSelect]
@PharmID int
, @Keyword nvarchar (128) 
AS
BEGIN
	SET NOCOUNT ON;

	SELECT [PharmID]
,		   [MedType]
,		   [RXCUI]
,		   [GENERIC_RXCUI]
,		   [TTY]
,		   [FULL_NAME]
,		   [RXN_DOSE_FORM]
,		   [FULL_GENERIC_NAME]
,		   [BRAND_NAME]
,		   [DISPLAY_NAME]
,		   [ROUTE]
,		   [NEW_DOSE_FORM]
,		   [STRENGTH]
,		   [SUPPRESS_FOR]
,		   [DISPLAY_NAME_SYNONYM]
,		   [IS_RETIRED]
,		   [SXDG_RXCUI]
,		   [SXDG_TTY]
,		   [SXDG_NAME]
,		   [PSN]
		   FROM [dbo].[Pharma_RX_OTC]
		   WHERE ([PharmID] = @PharmID OR @PharmID IS NULL) 
		   ORDER BY DISPLAY_NAME,STRENGTH
END
GO
/****** Object:  StoredProcedure [dbo].[spPharma_RX_OTCInsert]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-26
-- Modify date: 2016-11-02
-- Description:
-- =============================================
CREATE PROC [dbo].[spPharma_RX_OTCInsert]
@MedType varchar (16) = NULL
,@RXCUI varchar (8) 
,@GENERIC_RXCUI varchar (8) = NULL
,@TTY varchar (20) 
,@FULL_NAME varchar (3000) 
,@RXN_DOSE_FORM varchar (100) 
,@FULL_GENERIC_NAME varchar (3000) 
,@BRAND_NAME varchar (500) = NULL
,@DISPLAY_NAME varchar (3000) 
,@ROUTE varchar (100) 
,@NEW_DOSE_FORM varchar (100) 
,@STRENGTH varchar (500) 
,@SUPPRESS_FOR varchar (30) = NULL
,@DISPLAY_NAME_SYNONYM varchar (500) = NULL
,@IS_RETIRED varchar (8) = NULL
,@SXDG_RXCUI varchar (8) = NULL
,@SXDG_TTY varchar (20) = NULL
,@SXDG_NAME varchar (3000) = NULL
,@PSN varchar (3000) = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT OFF;
	INSERT INTO [dbo].[Pharma_RX_OTC] ([MedType]
,									   [RXCUI]
,									   [GENERIC_RXCUI]
,									   [TTY]
,									   [FULL_NAME]
,									   [RXN_DOSE_FORM]
,									   [FULL_GENERIC_NAME]
,									   [BRAND_NAME]
,									   [DISPLAY_NAME]
,									   [ROUTE]
,									   [NEW_DOSE_FORM]
,									   [STRENGTH]
,									   [SUPPRESS_FOR]
,									   [DISPLAY_NAME_SYNONYM]
,									   [IS_RETIRED]
,									   [SXDG_RXCUI]
,									   [SXDG_TTY]
,									   [SXDG_NAME]
,									   [PSN]) 
	SELECT ISNULL(@MedType,'OTC')
,		   @RXCUI
,		   @GENERIC_RXCUI
,		   @TTY
,		   @FULL_NAME
,		   @RXN_DOSE_FORM
,		   @FULL_GENERIC_NAME
,		   @BRAND_NAME
,		   @DISPLAY_NAME
,		   @ROUTE
,		   @NEW_DOSE_FORM
,		   @STRENGTH
,		   @SUPPRESS_FOR
,		   @DISPLAY_NAME_SYNONYM
,		   @IS_RETIRED
,		   @SXDG_RXCUI
,		   @SXDG_TTY
,		   @SXDG_NAME
,		   @PSN
	SET @inserted = IDENT_CURRENT ('[dbo].[Pharma_RX_OTC]') 
END
GO
/****** Object:  StoredProcedure [dbo].[spPharma_RX_OTCDelete]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-26
-- Modify date: 2016-10-26
-- Description:
-- =============================================
CREATE PROC [dbo].[spPharma_RX_OTCDelete]
@PharmID int
AS
BEGIN
	SET NOCOUNT OFF
	DELETE
	FROM   [dbo].[Pharma_RX_OTC]
	WHERE  [PharmID] = @PharmID
END
GO
/****** Object:  StoredProcedure [dbo].[spHealthcareProviderInsert]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-21
-- Modify date: 2016-10-24
-- Description:	INSERT
-- =============================================
CREATE PROC [dbo].[spHealthcareProviderInsert]
@lastname nvarchar (max) 
,@firstname nvarchar (max) 
,@specialty nvarchar (256) = NULL
,@phoneWork nvarchar (256) =''
,@phoneMobile nvarchar (256) = NULL
,@phonePager varbinary (50) = NULL
,@phoneFax nchar (10) = NULL
,@email nvarchar (256) = NULL
,@pathient_log_communication_preference varchar (20) = NULL
,@addressStreet nvarchar (512) = NULL
,@addressCity nvarchar (128) = NULL
,@addressStateID int = NULL
,@addressZip varchar (10) = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO [dbo].[HealthcareProvider] (
											[lastname]
,											[firstname]
,											[specialty]
,											[phoneWork]
,											[phoneMobile]
,											[phonePager]
,											[phoneFax]
,											[email]
,											[pathient_log_communication_preference]
,											[addressStreet]
,											[addressCity]
,											[addressStateID]
,											[addressZip]) 
	SELECT 
		   @lastname
,		   @firstname
,		   @specialty
,		   @phoneWork
,		   @phoneMobile
,		   @phonePager
,		   @phoneFax
,		   @email
,		   @pathient_log_communication_preference
,		   @addressStreet
,		   @addressCity
,		   @addressStateID
,		   @addressZip
	SET @inserted = IDENT_CURRENT ('[dbo].[HealthcareProvider]') 
END
GO
/****** Object:  StoredProcedure [dbo].[spHealthcareProviderDelete]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-21
-- Modify date: 2016-10-24
-- Description:	DELETE
-- =============================================
CREATE PROC [dbo].[spHealthcareProviderDelete]
@PhysicianID int
AS
SET NOCOUNT OFF

DELETE
FROM   [dbo].[HealthcareProvider]
WHERE  [PhysicianID] = @PhysicianID
GO
/****** Object:  StoredProcedure [dbo].[spHealthcareProviderUpdate]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-21
-- Modify date: 2016-10-24
-- Description:	UPDATE
-- =============================================
CREATE PROC [dbo].[spHealthcareProviderUpdate]
@PhysicianID int
,@lastname nvarchar (max) 
,@firstname nvarchar (max) 
,@specialty nvarchar (256) = NULL
,@phoneWork nvarchar (256) 
,@phoneMobile nvarchar (256) = NULL
,@phonePager varbinary (50) = NULL
,@phoneFax nchar (10) = NULL
,@email nvarchar (256) = NULL
,@pathient_log_communication_preference varchar (20) = NULL
,@addressStreet nvarchar (512) = NULL
,@addressCity nvarchar (128) = NULL
,@addressStateID int = NULL
,@addressZip varchar (10) = NULL
AS
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[HealthcareProvider]
	SET     [lastname] = @lastname
,		   [firstname] = @firstname
,		   [specialty] = @specialty
,		   [phoneWork] = @phoneWork
,		   [phoneMobile] = @phoneMobile
,		   [phonePager] = @phonePager
,		   [phoneFax] = @phoneFax
,		   [email] = @email
,		   [pathient_log_communication_preference] = @pathient_log_communication_preference
,		   [addressStreet] = @addressStreet
,		   [addressCity] = @addressCity
,		   [addressStateID] = @addressStateID
,		   [addressZip] = @addressZip
	WHERE  [PhysicianID] = @PhysicianID

END
GO
/****** Object:  StoredProcedure [dbo].[spPatientDelete]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 016-10-19
-- Description:	Delete  Patient record
-- =============================================
CREATE PROC [dbo].[spPatientDelete]
@PatientID int
AS DELETE
   FROM   [dbo].[Patient]
   WHERE  [PatientID] = @PatientID
GO
/****** Object:  StoredProcedure [dbo].[spPatientUpdate]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-30
-- Description:	Updates  Patient record
-- =============================================
CREATE PROC [dbo].[spPatientUpdate]
@PatientID int
,@userPassword nvarchar (30) = NULL
,@firstName nvarchar (30) = NULL
,@lastName nvarchar (30) = NULL
,@phoneHome nvarchar (50) = NULL
,@phoneMobile nvarchar (50) = NULL
,@email nvarchar (100) = NULL
,@addressStreet nvarchar (150) = NULL
,@addressCity nvarchar (100) = NULL
,@addressState int = NULL
,@address_country nvarchar (25) = NULL
,@address_postalcode nvarchar (9) = NULL
,@date_of_birth date = NULL
AS
BEGIN
	SET NOCOUNT OFF;
	UPDATE [dbo].[Patient]
	SET  
		   [userPassword] = ISNULL (@userPassword , userPassword) 
,		   [firstName] = ISNULL (@firstName , firstName) 
,		   [lastName] = ISNULL(@lastName,lastName)
,		   [phoneHome] = ISNULL(@phoneHome,phoneHome)
,		   [phoneMobile] = ISNULL(@phoneMobile,phoneMobile)
,		   [email] = ISNULL(@email,email)
,		   [addressStreet] = @addressStreet
,		   [addressCity] = @addressCity
,		   [addressState] = ISNULL(@addressState,addressState)
,		   [address_country] =ISNULL( @address_country,address_country)
,		   [address_postalcode] = ISNULL(@address_postalcode,address_postalcode)
,		   [pwd_last_changed] = CASE
									WHEN @userPassword IS NULL
										THEN pwd_last_changed
									ELSE GETDATE () 
								END
,		   [date_of_birth] = ISNULL(@date_of_birth,date_of_birth)

	WHERE  [PatientID] = @PatientID
END
GO
/****** Object:  StoredProcedure [dbo].[spPatientSelect]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-24
-- Description:	Retrieves patient by ID, userName, or userName & password
-- =============================================

CREATE PROC [dbo].[spPatientSelect]
@PatientID int = NULL
, @userName nvarchar (512) = NULL
, @password nvarchar (512) = NULL
AS SELECT [PatientID]
,		  [userName]
,		  [userPassword]
,		  [user_hash]
,		  [firstName]
,		  [lastName]
,		  [phoneHome]
,		  [phoneMobile]
,		  [email]
,		  [status]
,		  [addressStreet]
,		  [addressCity]
,		  [addressState]
,		  [address_country]
,		  [address_postalcode]
,		  [user_preferences]
,		  [pwd_last_changed]
,		  [lang]
,		  [timezone_id]
,		  [primary_physsician]
,		  [date_of_birth]
,		  [date_joined]
,		  [picture]
,		  [meta_data]
,		  [userRole]
		  FROM [dbo].[Patient]
		  WHERE (([PatientID] = @PatientID
			   OR @PatientID IS NULL) 
			 AND (LOWER (userName) = LOWER (@userName) 
			  OR @userName = NULL)
			 AND (userPassword = @password
			  OR (@password IS NULL and @userName IS NULL AND @PatientID IS NOT NULL)))
GO
/****** Object:  StoredProcedure [dbo].[spPatientInsert]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-11-02
-- Description:	Inserts  Patient record
-- =============================================
CREATE PROC [dbo].[spPatientInsert]
@userName nvarchar (60)
,@userPassword nvarchar (30)
,@user_hash nvarchar (32) = NULL
,@firstName nvarchar (30) = NULL
,@lastName nvarchar (30) = NULL
,@phoneHome nvarchar (50) = NULL
,@phoneMobile nvarchar (50) = NULL
,@email nvarchar (100) = NULL
,@status nvarchar (25) = NULL
,@addressStreet nvarchar (150) = NULL
,@addressCity nvarchar (100) = NULL
,@addressState int = 2
,@address_country nvarchar (25) = NULL
,@address_postalcode nvarchar (9) = NULL
,@user_preferences nvarchar (max) = NULL
,@pwd_last_changed datetime = NULL
,@lang nvarchar (10) = 'en-us'
,@timezone_id nvarchar (128) = NULL
,@primary_physsician int = NULL
,@date_of_birth date = NULL
,@date_joined date = GETDATE
,@picture nvarchar (max) = NULL
,@meta_data xml = NULL
,@userRole int = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT OFF;
IF @username is null or @userPassword is null or  EXISTS(
SELECT 	1 FROM Patient WHERE lOWER(userName) = LOWER(@userName)) 
	BEGIN
		SET @inserted = -1 
		RAISERROR  (N'[spPatientInsert] FAILED, USERNAME AND PASSWORD ARD REQUIRED', 20, 101) WITH LOG
		RETURN
	END 	
	INSERT INTO [dbo].[Patient] ([userName]
,								 [userPassword]
,								 [user_hash]
,								 [firstName]
,								 [lastName]
,								 [phoneHome]
,								 [phoneMobile]
,								 [email]
,								 [status]
,								 [addressStreet]
,								 [addressCity]
,								 [addressState]
,								 [address_country]
,								 [address_postalcode]
,								 [user_preferences]
,								 [pwd_last_changed]
,								 [lang]
,								 [timezone_id]
,								 [primary_physsician]
,								 [date_of_birth]
,								 [date_joined]
,								 [picture]
,								 [meta_data]
,								 [userRole]) 
	SELECT @userName
,		   @userPassword
,		   @user_hash
,		   @firstName
,		   @lastName
,		   @phoneHome
,		   @phoneMobile
,		   @email
,		   @status
,		   @addressStreet
,		   @addressCity
,		   @addressState
,		   @address_country
,		   @address_postalcode
,		   @user_preferences
,		   @pwd_last_changed
,		   @lang
,		   @timezone_id
,		   @primary_physsician
,		   @date_of_birth
,		   ISNULL(@date_joined,GETDATE())
,		   @picture
,		   @meta_data
,		   ISNULL(@userRole,1)
	SET @inserted = IDENT_CURRENT ('[dbo].[Patient]') 
END
GO
/****** Object:  Table [dbo].[Tag]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tag](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[PatientID] [int] NOT NULL,
	[TagName] [nvarchar](256) NOT NULL,
 CONSTRAINT [PK_Severity] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USER_FieldA]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USER_FieldA](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[PatientID] [int] NOT NULL,
	[Description] [nvarchar](100) NOT NULL,
	[Value] [int] NOT NULL,
	[Grouping] [nvarchar](128) NOT NULL,
 CONSTRAINT [PK_USER_FieldA] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Allows for multiple groups' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'USER_FieldA', @level2type=N'COLUMN',@level2name=N'Grouping'
GO
/****** Object:  Table [dbo].[CommunicationLog]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CommunicationLog](
	[CommunicationLogID] [int] NOT NULL,
	[PatientID] [int] NULL,
	[PhysicianID] [int] NULL,
	[date] [datetime] NULL,
	[ReasonForCommunication] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Medication]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Medication](
	[MedicationID] [int] IDENTITY(1,1) NOT NULL,
	[PatientID] [int] NOT NULL,
	[PharmID] [int] NULL,
	[PhysicianID] [int] NULL,
	[Instructions] [nvarchar](max) NULL,
	[Sig] [varchar](50) NULL,
	[StartDate] [date] NOT NULL,
	[EndDate] [date] NULL,
	[Dosage] [nvarchar](256) NULL,
	[FrequencySig] [varchar](50) NULL,
	[Active] [bit] NOT NULL,
 CONSTRAINT [PK_Medication_1] PRIMARY KEY CLUSTERED 
(
	[MedicationID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PatientDietaryRestriction]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientDietaryRestriction](
	[PatientID] [int] NOT NULL,
	[DietaryRestrictionID] [int] NOT NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_PatientDietaryRestriction] PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC,
	[DietaryRestrictionID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PatientVitals]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientVitals](
	[PatientID] [int] NOT NULL,
	[height_cm] [decimal](18, 2) NULL,
	[weight_kg] [decimal](18, 4) NULL,
	[vitals_meta] [xml] NULL,
	[date_recorded] [datetime] NOT NULL,
	[vitalA_name] [nvarchar](255) NULL,
	[vitalA_value] [decimal](18, 4) NULL,
	[vitalB_name] [nvarchar](255) NULL,
	[vitalB_value] [decimal](18, 4) NULL,
 CONSTRAINT [PK_PatientVitals] PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Extra User Defined Vitals (A and B)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PatientVitals', @level2type=N'COLUMN',@level2name=N'vitalA_name'
GO
/****** Object:  Table [dbo].[PatientPhysician]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientPhysician](
	[PatientID] [int] NOT NULL,
	[PhysicianID] [int] NOT NULL,
 CONSTRAINT [PK_PatientPhysician] PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC,
	[PhysicianID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Activity]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Activity](
	[ExerciseID] [int] IDENTITY(1,1) NOT NULL,
	[PatientID] [int] NOT NULL,
	[ExerciseTypeID] [int] NOT NULL,
	[Calories] [decimal](10, 2) NULL,
	[Steps] [int] NULL,
	[Distance] [decimal](10, 2) NULL,
	[Floors] [int] NULL,
	[Date] [date] NULL,
	[start_time] [datetime] NULL,
	[end_time] [time](7) NULL,
	[minutes_peak_hr] [int] NULL,
	[minutes_target_hr] [int] NULL,
	[minutes_cardio_hr] [int] NULL,
	[ActivityMetaData] [xml] NULL,
 CONSTRAINT [PK_Exercise] PRIMARY KEY CLUSTERED 
(
	[ExerciseID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diary_Sent_Log]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diary_Sent_Log](
	[SentLogID] [int] NOT NULL,
	[PatientID] [int] NULL,
	[date_from] [date] NULL,
	[date_to] [date] NULL,
	[template_id] [nchar](10) NULL,
	[PhysicianID] [int] NULL,
	[delivery_method] [int] NULL,
	[sent_on] [date] NULL,
	[delivered_on] [date] NULL,
	[delivery_confirmationn_on] [date] NULL,
	[include_drug_history_for_range] [bit] NULL,
 CONSTRAINT [PK_Diary_Sent_Log] PRIMARY KEY CLUSTERED 
(
	[SentLogID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diary]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diary](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[PatientID] [int] NOT NULL,
	[Title] [nvarchar](250) NOT NULL,
	[Notes] [nvarchar](max) NOT NULL,
	[NotesActivity] [nvarchar](max) NULL,
	[createdDate] [datetime] NOT NULL,
	[updatedDate] [datetime] NULL,
	[includce_meds_current] [nchar](10) NULL,
	[attachmentPath] [nvarchar](255) NULL,
	[ratingMood] [int] NULL,
	[ratingProductivity] [int] NULL,
	[USER_FieldA2Id] [int] NULL,
	[USER_FieldAId] [int] NULL,
 CONSTRAINT [PK_Diary] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'2nd Value To Track' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Diary', @level2type=N'COLUMN',@level2name=N'USER_FieldA2Id'
GO
CREATE FULLTEXT INDEX ON [dbo].[Diary](
[Notes] LANGUAGE [English], 
[NotesActivity] LANGUAGE [English], 
[Title] LANGUAGE [English])
KEY INDEX [PK_Diary]ON ([ftMedLog], FILEGROUP [PRIMARY])
WITH (CHANGE_TRACKING = AUTO, STOPLIST = SYSTEM)
GO
/****** Object:  Table [dbo].[ActivityTag]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActivityTag](
	[ExerciseID] [int] NOT NULL,
	[TagID] [int] NOT NULL,
 CONSTRAINT [PK_ActivityTag] PRIMARY KEY CLUSTERED 
(
	[ExerciseID] ASC,
	[TagID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PatientMedication]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientMedication](
	[PatientID] [int] NOT NULL,
	[MedicationID] [int] NOT NULL,
	[Date] [date] NULL,
	[Time] [time](7) NULL,
 CONSTRAINT [PK_PatientMedication] PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC,
	[MedicationID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[vwMedication]    Script Date: 11/02/2016 08:46:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[vwMedication]
AS
SELECT     dbo.Medication.MedicationID, dbo.Medication.PatientID, dbo.Medication.PharmID, dbo.Medication.PhysicianID, dbo.Medication.Instructions, dbo.Medication.Sig, dbo.Medication.StartDate, 
                      dbo.Medication.EndDate, dbo.Medication.Dosage, dbo.Medication.FrequencySig, dbo.Medication.Active, dbo.Sig.SigAbbrID, dbo.Sig.Definition, dbo.Sig.category
FROM         dbo.Medication LEFT OUTER JOIN
                      dbo.Pharma_RX_OTC ON dbo.Medication.PharmID = dbo.Pharma_RX_OTC.PharmID LEFT OUTER JOIN
                      dbo.Sig ON dbo.Medication.Sig = dbo.Sig.SigAbbrID
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Medication"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 271
               Right = 190
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Pharma_RX_OTC"
            Begin Extent = 
               Top = 0
               Left = 574
               Bottom = 266
               Right = 784
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Sig"
            Begin Extent = 
               Top = 103
               Left = 387
               Bottom = 267
               Right = 539
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 15
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'vwMedication'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'vwMedication'
GO
/****** Object:  StoredProcedure [dbo].[spTagUpdate]    Script Date: 11/02/2016 08:46:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- |CurrentDate|
CREATE PROC [dbo].[spTagUpdate] 
    @Id int,
    @PatientID int,
    @TagName nvarchar(256)
AS 
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Tag]
	SET    [PatientID] = @PatientID, [TagName] = @TagName
	WHERE  [Id] = @Id
	
END
GO
/****** Object:  StoredProcedure [dbo].[spTagSelect]    Script Date: 11/02/2016 08:46:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- date created........: |CurrentDate|

CREATE PROC [dbo].[spTagSelect] 
    @Id int
AS 
	SET NOCOUNT ON 
	
	SELECT [Id], [PatientID], [TagName] 
	FROM   [dbo].[Tag] 
	WHERE  ([Id] = @Id OR @Id IS NULL)
GO
/****** Object:  StoredProcedure [dbo].[spTagInsert]    Script Date: 11/02/2016 08:46:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- |CurrentDate|
CREATE PROC [dbo].[spTagInsert] 
    @PatientID int,
    @TagName nvarchar(256)
, @inserted INT OUTPUT
AS 
BEGIN
	SET NOCOUNT ON 
	INSERT INTO [dbo].[Tag] ([PatientID], [TagName])
	SELECT @PatientID, @TagName      
SET @inserted = Ident_current ('[dbo].[Tag]')
END
GO
/****** Object:  StoredProcedure [dbo].[spTagDelete]    Script Date: 11/02/2016 08:46:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spTagDelete] 
    @Id int
AS 
	SET NOCOUNT OFF 
	
	DELETE
	FROM   [dbo].[Tag]
	WHERE  [Id] = @Id
GO
/****** Object:  StoredProcedure [dbo].[spPharma_RX_OTCSearch]    Script Date: 11/02/2016 08:46:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-28
-- Modify date: 
-- Description: search fields
-- =============================================
CREATE PROCEDURE [dbo].[spPharma_RX_OTCSearch]

--	DECLARE 
@keyword nvarchar (128) 
, @pageNum int = 1
, @pageSize int = 100
, @onlyMyRX bit = 0
, @PatientID int = 2--null
AS
BEGIN
	SET NOCOUNT ON;

	SET @pageNum = @pageNum - 1
	DECLARE @StartRowIndex int = @pageNum * @pageSize + 1;

	WITH MedCTE
		AS (
		SELECT
		d.PharmID
,		d.MedType
,		d.RXCUI
		--, d.GENERIC_RXCUI
,		d.TTY
,		d.FULL_NAME
		--, d.RXN_DOSE_FORM
		--, d.FULL_GENERIC_NAME
		--, d.BRAND_NAME
		--, d.DISPLAY_NAME
		--,FULL_GENERIC_NAME
		---, d.ROUTE

		--, d.NEW_DOSE_FORM

,		d.STRENGTH
,		ROW_NUMBER () OVER (ORDER BY  D.FULL_NAME) AS RowNum

			   FROM dbo.Pharma_RX_OTC d
			   WHERE ((d.FULL_NAME LIKE '%' + COALESCE (@keyword , FULL_NAME) + '%'
					   OR d.BRAND_NAME like '%' + COALESCE(@keyword,BRAND_NAME) +'%' 
					OR d.FULL_GENERIC_NAME LIKE '%' + COALESCE (@keyword , FULL_GENERIC_NAME) + '%'
					OR @keyword  IS NULL) 
				  AND (@onlyMyRX = 0
					OR PharmID IN (
					   SELECT PharmID FROM dbo.Medication WHERE PatientID = @PatientID)))) 

		SELECT TOP (@pageSize) 
		meds.PharmID
,		meds.MedType
,		meds.RXCUI
,		meds.FULL_NAME
,		meds.TTY
		--,DISPLAY_NAME
,		meds.STRENGTH
		--,FULL_GENERIC_NAME
,		RowNum
			   FROM (
					 SELECT MedCTE.*
,							(
							SELECT COUNT (*) FROM MedCTE) AS RecCount FROM MedCTE) meds
			   WHERE
			   RowNum BETWEEN
			   ( CASE @StartRowIndex
					 WHEN -1
						 THEN ( RecCount ) - @pageSize
					 ELSE  @StartRowIndex
				 END) 
			   AND
			   ( CASE @StartRowIndex
					 WHEN -1
						 THEN ( RecCount ) - @pageSize
					 ELSE  @StartRowIndex
				 END) + @pageSize
--  --THEN 1 ELSE 0 END  = 1    
-- UNION  ALL SELECT 
--  -1 as PharmID, 
--  '' AS MedType, 
--  '' AS RXCUI, 
--  '' AS TTY, 
-- '' AS  FULL_NAME,
--  '' AS DISPLAY_NAME, 
--  --'' AS FULL_GENERIC_NAME, 
--  '' AS STRENGTH, 
-- ( SELECT count (*) FROM CustListtemp ) AS rownum
--END

END
GO
/****** Object:  StoredProcedure [dbo].[spPatientDietaryRestrictionChangeBinding]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-29
-- Modify date: 
-- Description:	ASSIGN/UNASSIGN
-- =============================================
CREATE PROCEDURE [dbo].[spPatientDietaryRestrictionChangeBinding]
@PatientID int
,@DietaryID int
,@active bit = NULL

AS
BEGIN
	SET NOCOUNT OFF;
	IF (@active = 1) 
		BEGIN
			IF NOT EXISTS (SELECT 1
								  FROM  [dbo].PatientDietaryRestriction
								  WHERE PatientID = @PatientID
									AND DietaryRestrictionID = @DietaryID) 
				BEGIN
					INSERT INTO [dbo].PatientDietaryRestriction
					([PatientID]
,					 [DietaryRestrictionID], Active)
					VALUES
					(  @PatientID
						 , @DietaryID
						 ,1) 
				END
			ELSE
					BEGIN
							UPDATE [dbo].PatientDietaryRestriction SET Active = 1 
								WHERE PatientID = @PatientID 
									AND DietaryRestrictionID = @DietaryID
					END 	
		END
	ELSE
		BEGIN
		IF @active = 0
			UPDATE [dbo].PatientDietaryRestriction SET Active = 0
								WHERE PatientID = @PatientID 
									AND DietaryRestrictionID = @DietaryID
		END
	RETURN @@ROWCOUNT
END
GO
/****** Object:  StoredProcedure [dbo].[spPatientChangeHealthCareProviderBinding]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-24
-- Modify date: 2016-10-24
-- Description:	ASSIGN/UNASSIGN
-- =============================================
CREATE PROCEDURE [dbo].[spPatientChangeHealthCareProviderBinding]
@PatientID int
,@PhysicianID int
,@mustAssign bit

AS
BEGIN

	SET NOCOUNT OFF
	IF (@mustAssign = 1) 
		BEGIN
			IF NOT EXISTS (SELECT 1
								  FROM  [dbo].[PatientPhysician]
								  WHERE PatientID = @PatientID
									AND PhysicianID = @PhysicianID) 
				BEGIN
					INSERT INTO [MedLog].[dbo].[PatientPhysician]
					([PatientID]
,					 [PhysicianID]) 
					VALUES
					(
						   @PatientID
						 , @PhysicianID) 
				END
		END
	ELSE
		BEGIN
			DELETE FROM [dbo].[PatientPhysician]
			WHERE PatientID = @PatientID
			  AND PhysicianID = @PhysicianID
		END
	RETURN @@ROWCOUNT
END
GO
/****** Object:  StoredProcedure [dbo].[spMedicationUpdate]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spMedicationUpdate] 
    @MedicationID int,
    @PatientID int,
    @PharmID int = NULL,
    @PhysicianID int = NULL,
    @Instructions nvarchar(MAX) = NULL,
    @Sig varchar(50),
    @StartDate date,
    @EndDate date = NULL,
    @Dosage nvarchar(256) = NULL,
    @FrequencySig varchar(30) = NULL,
    @Active bit
AS 
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Medication]
	SET    [PatientID] = @PatientID, [PharmID] = @PharmID, [PhysicianID] = @PhysicianID, [Instructions] = @Instructions, [Sig] = @Sig, [StartDate] = @StartDate, [EndDate] = @EndDate, [Dosage] = @Dosage, [FrequencySig] = @FrequencySig, [Active] = @Active
	WHERE  [MedicationID] = @MedicationID
	
END
GO
/****** Object:  StoredProcedure [dbo].[spMedicationSelect]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-24
-- Modify date: 1-28
-- Description: Basic fields
-- =============================================
CREATE PROC [dbo].[spMedicationSelect] 
    @MedicationID int = NULL
    ,@PatientID int
AS 
BEGIN

	SET NOCOUNT ON;


	SELECT [MedicationID], [PatientID], [PharmID], [PhysicianID], [Instructions], [Sig], [StartDate], [EndDate], [Dosage], [FrequencySig], ISNULL([Active] ,1) as Active
	FROM   [dbo].[Medication] 
	WHERE  ([MedicationID] = @MedicationID OR @MedicationID IS NULL)  AND PatientID = @PatientID
	
END
GO
/****** Object:  StoredProcedure [dbo].[spMedicationPatientChangeBinding]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-24
-- Modify date: 2016-10-28
-- Description: Basic fields
-- =============================================
CREATE PROCEDURE [dbo].[spMedicationPatientChangeBinding]
@PatientID int
,@PharmID int
,@PhysicanID int = NULL
,@Instructions nvarchar (max) = NULL
,@Sig varchar (50) = NULL
,@StartDate date = getdate
,@endDate date = NULL
,@active bit = 1

AS
IF @endDate IS NULL
	BEGIN
		SET @endDate = DATEADD (year , 1 , GETDATE ()) 
	END

SET NOCOUNT OFF
IF (@active = 1) 
	BEGIN
		IF NOT EXISTS (SELECT 1 FROM dbo.Medication WHERE PatientID = @PatientID
													  AND @PharmID = PharmID) 
			BEGIN
				INSERT INTO [dbo].Medication (PatientID
,											  PharmID
,											  PhysicianID
,											  Sig
,											  StartDate
,											  EndDate) 
				VALUES (
					   @PatientID
					 , @PharmID
					 , @PhysicanID
					 , @Sig
					 , ISNULL (@StartDate , GETDATE ()) 
					 , @endDate) 
			END
		ELSE
			BEGIN
				UPDATE Medication
				SET  Instructions = ISNULL (@Instructions , Instructions) 
,					 EndDate = ISNULL (@endDate , EndDate) 
,					 Active = ISNULL (@active , 1) 
,					 PhysicianID = ISNULL (@PhysicanID , PhysicianID) 
				WHERE  PatientID = @PatientID
				   AND @PharmID = PharmID
			END
	END
ELSE
	BEGIN
		UPDATE  dbo.Medication
		SET Active = 0
		WHERE  PatientID = @PatientID
		   AND @PharmID = PharmID
	END
RETURN @@ROWCOUNT
GO
/****** Object:  StoredProcedure [dbo].[spMedicationInsert]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- |CurrentDate|
CREATE PROC [dbo].[spMedicationInsert] 
    @PatientID int,
    @PharmID int = NULL,
    @PhysicianID int = NULL,
    @Instructions nvarchar(MAX) = NULL,
    @Sig varchar(50),
    @StartDate date,
    @EndDate date = NULL,
    @Dosage nvarchar(256) = NULL,
    @FrequencySig varchar(30) = NULL,
    @Active bit
, @inserted INT OUTPUT
AS 
BEGIN
	SET NOCOUNT ON 
	INSERT INTO [dbo].[Medication] ([PatientID], [PharmID], [PhysicianID], [Instructions], [Sig], [StartDate], [EndDate], [Dosage], [FrequencySig], [Active])
	SELECT @PatientID, @PharmID, @PhysicianID, @Instructions, @Sig, @StartDate, @EndDate, @Dosage, @FrequencySig, @Active      
SET @inserted = Ident_current ('[dbo].[Medication]')
END
GO
/****** Object:  StoredProcedure [dbo].[spMedicationDelete]    Script Date: 11/02/2016 08:46:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spMedicationDelete] 
    @MedicationID int
AS 
	SET NOCOUNT OFF 

	DELETE
	FROM   [dbo].[Medication]
	WHERE  [MedicationID] = @MedicationID
GO
/****** Object:  StoredProcedure [dbo].[spHealthcareProviderSelect]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-21
-- Modify date: 2016-10-24
-- Description:	SELECT
-- =============================================
CREATE PROC [dbo].[spHealthcareProviderSelect]
@PhysicianID int = NULL
, @PatientID int = NULL
, @keyword nvarchar (128) =null
AS
--TODO - ADD SEARCH
SET NOCOUNT ON

SELECT [PhysicianID]
,	   [lastname]
,	   [firstname]
,	   [specialty]
,	   [phoneWork]
,	   [phoneMobile]
,	   [phonePager]
,	   [phoneFax]
,	   [email]
,	   [pathient_log_communication_preference]
,	   [addressStreet]
,	   [addressCity]
,	   [addressStateID]
,	   [addressZip]
	   FROM [dbo].[HealthcareProvider]
	   WHERE (([PhysicianID] = @PhysicianID
			OR @PhysicianID IS NULL) 
		  AND ((EXISTS (
						SELECT 1
							   FROM PatientPhysician
							   WHERE @PatientID = PatientID
								 AND PhysicianID = @PhysicianID) 
			 OR @PatientID IS NULL))) 
	   ORDER BY 	UPPER (LASTNAME) , UPPER (FIRSTNAME)
GO
/****** Object:  StoredProcedure [dbo].[spDietaryRestrictionDelete]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-29
-- Modify date: 
-- Description:	DELETE
-- =============================================
CREATE PROC [dbo].[spDietaryRestrictionDelete] 
    @DietaryRestrictionID int
AS 
BEGIN
SET NOCOUNT ON;
DELETE FROM DBO.PatientDietaryRestriction WHERE DietaryRestrictionID = @DietaryRestrictionID
SET NOCOUNT OFF;
DELETE
	FROM   [dbo].[DietaryRestriction]
	WHERE  [DietaryRestrictionID] = @DietaryRestrictionID
END
GO
/****** Object:  Table [dbo].[MedicationTags]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MedicationTags](
	[MedicationID] [int] NOT NULL,
	[TagID] [int] NOT NULL,
 CONSTRAINT [PK_MedicationTags] PRIMARY KEY CLUSTERED 
(
	[MedicationID] ASC,
	[TagID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[spDietaryRestrictionSelect]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-29
-- Modify date: 
-- Description:	SELECT
-- =============================================
CREATE PROC [dbo].[spDietaryRestrictionSelect] 
    @DietaryRestrictionID int = NULL
    ,@PatientID int = NULL
    ,@Keyword nvarchar(128) = NULL
AS 
	
	SELECT [DietaryRestrictionID], [Name], [Restrictions] 
	FROM   [dbo].[DietaryRestriction] 
	WHERE  ([DietaryRestrictionID] = @DietaryRestrictionID OR @DietaryRestrictionID IS NULL)
	AND ( (@PatientID IS NULL ) OR  DietaryRestrictionID IN (
	SELECT  DietaryRestrictionID FROM dbo.PatientDietaryRestriction WHERE PatientID = @PatientID))
	AND ( @Keyword IS NULL OR (( Name LIKE '%' + @Keyword + '%' ) OR( Restrictions  LIKE '%' + @Keyword + '%')))
GO
/****** Object:  StoredProcedure [dbo].[spDietaryRestrictionInsert]    Script Date: 11/02/2016 08:46:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-29
-- Modify date: 
-- Description:	CREATE
-- =============================================
CREATE PROC [dbo].[spDietaryRestrictionInsert] 
    
    @Name nvarchar(MAX) = NULL
    ,@Restrictions nvarchar(MAX) = NULL
    ,@PatientID int = NULL
, @DietaryRestrictionID  INT OUTPUT
AS 
BEGIN
	SET NOCOUNT ON 
	INSERT INTO [dbo].[DietaryRestriction] ([Name], [Restrictions])
	SELECT @Name, @Restrictions      
SET @DietaryRestrictionID  = Ident_current ('[dbo].[DietaryRestriction]')

IF @PatientID IS NOT NULL 
 	BEGIN
 		EXEC dbo.[spPatientDietaryRestrictionChangeBinding] @PatientID, @DietaryRestrictionID, 1
 	END 	

END
GO
/****** Object:  StoredProcedure [dbo].[spDiaryUpdate]    Script Date: 11/02/2016 08:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-22
-- Description:	Updates  Diary record
-- =============================================
CREATE PROC [dbo].[spDiaryUpdate]
 @Id int
,@PatientID int
,@Title nvarchar (250) = NULL 
,@Notes nvarchar (max) 
,@NotesActivity nvarchar (max) = NULL
,@createdDate datetime = NULL
,@updatedDate datetime = GETDATE
,@includce_meds_current nchar (10) = NULL
,@attachmentPath nvarchar (255) = NULL
,@ratingMood int = NULL
,@ratingProductivity int = NULL
,@USER_FieldA2Id int = NULL
,@USER_FieldAId int = NULL
AS
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Diary]
	SET    [PatientID] = @PatientID
,		   [Title] = ISNULL(@Title,Title)
,		   [Notes] = @Notes
,		   [NotesActivity] = @NotesActivity
,		   [createdDate] = ISNULL (@createdDate , createdDate) 
,		   [updatedDate] = @updatedDate
,		   [includce_meds_current] = @includce_meds_current
,		   [attachmentPath] = @attachmentPath
,		   [ratingMood] = @ratingMood
,		   [ratingProductivity] = @ratingProductivity
,		   [USER_FieldA2Id] = @USER_FieldA2Id
,		   [USER_FieldAId] = @USER_FieldAId
	WHERE  [Id] = @Id

END
GO
/****** Object:  StoredProcedure [dbo].[spDiarySelect]    Script Date: 11/02/2016 08:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-25
-- Description:	Selects  Diary record
-- =============================================
CREATE PROC [dbo].[spDiarySelect]
@Id int = NULL
, @PatientID int
, @Keyword nvarchar (128) 
AS
SET NOCOUNT ON
--TODO ADD DATE FILTERS
IF @Keyword IS NULL 
		BEGIN		
SELECT [Id]
,	   [PatientID]
,	   [Title]
,	   [Notes]
,	   [NotesActivity]
,	   [createdDate]
,	   [updatedDate]
,	   [includce_meds_current]
,	   [attachmentPath]
,	   [ratingMood]
,	   [ratingProductivity]
,	   [USER_FieldA2Id]
,	   [USER_FieldAId]
	   FROM [dbo].[Diary]
	   WHERE  ([Id] = @Id OR @Id IS NULL) 
		  AND @PatientID = PatientID  -- Patient
		  
					   
END 
ELSE 
	BEGIN
		SELECT [Id]
,	   [PatientID]
,	   [Title]
,	   [Notes]
,	   [NotesActivity]
,	   [createdDate]
,	   [updatedDate]
,	   [includce_meds_current]
,	   [attachmentPath]
,	   [ratingMood]
,	   [ratingProductivity]
,	   [USER_FieldA2Id]
,	   [USER_FieldAId]
	   FROM [dbo].[Diary]
	   WHERE  ([Id] = @Id OR @Id IS NULL) 
		  AND @PatientID = PatientID  -- Patient
		  AND ((@Keyword IS NOT NULL
			AND ((LOWER (Title) LIKE '%' + LOWER (@keyword) + '%') --Keyword
			  OR Notes LIKE '%' + @keyword + '%')) 
			OR @Keyword IS NULL) 
		   AND ( @Keyword IS NULL OR ( @Keyword IS NOT NULL
			AND ID IN (
				SELECT  -- FT Search
				TOP 15 ID
					   FROM Diary
								JOIN CONTAINSTABLE (Diary , * , @keyword) FTS
									ON Diary.ID = FTS.[KEY]
					   WHERE PatientID = @PatientID
					   ORDER BY
					   FTS.Rank DESC)))
	END
GO
/****** Object:  StoredProcedure [dbo].[spDiaryInsert]    Script Date: 11/02/2016 08:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-25
-- Description:	Inserts  Diary record
-- =============================================
CREATE PROC [dbo].[spDiaryInsert]
@PatientID int
,@Title nvarchar (250) 
,@Notes nvarchar (max) 
,@NotesActivity nvarchar (max) = NULL
,@createdDate datetime = NULL
,@updatedDate datetime = NULL
,@includce_meds_current nchar (10) = NULL
,@attachmentPath nvarchar (255) = NULL
,@ratingMood int = NULL
,@ratingProductivity int = NULL--,
--@USER_FieldA2Id int = NULL,
--@USER_FieldAId int = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO [dbo].[Diary] ([PatientID]
,							   [Title]
,							   [Notes]
,							   [NotesActivity]
,							   [createdDate]
,							   [updatedDate]
,							   [includce_meds_current]
,							   [attachmentPath]
,							   [ratingMood]
,							   [ratingProductivity]
,							   [USER_FieldA2Id]
,							   [USER_FieldAId]) 
	SELECT @PatientID
,		   @Title
,		   @Notes
,		   @NotesActivity
,		   ISNULL(@createdDate,GETDATE())
,		   @updatedDate
,		   @includce_meds_current
,		   @attachmentPath
,		   @ratingMood
,		   @ratingProductivity
,		   NULL
,		   NULL
	SET @inserted = IDENT_CURRENT ('[dbo].[Diary]') 
END
GO
/****** Object:  StoredProcedure [dbo].[spDiaryDelete]    Script Date: 11/02/2016 08:46:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-22
-- Description:	Deletes  Diary record
-- =============================================
CREATE PROC [dbo].[spDiaryDelete]
@Id int
AS
SET NOCOUNT OFF
DELETE
FROM   [dbo].[Diary]
WHERE  [Id] = @Id
GO
/****** Object:  Table [dbo].[DiaryTags]    Script Date: 11/02/2016 08:46:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaryTags](
	[DiaryID] [int] NOT NULL,
	[TagID] [int] NOT NULL,
 CONSTRAINT [PK_DiaryTags] PRIMARY KEY CLUSTERED 
(
	[DiaryID] ASC,
	[TagID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF__Diary__CreatedDa__681373AD]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Diary] ADD  CONSTRAINT [DF__Diary__CreatedDa__681373AD]  DEFAULT (getdate()) FOR [createdDate]
GO
/****** Object:  Default [DF_Diary_ratingMood]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Diary] ADD  CONSTRAINT [DF_Diary_ratingMood]  DEFAULT ((1)) FOR [ratingMood]
GO
/****** Object:  Default [DF_Diary_ratingProductivity]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Diary] ADD  CONSTRAINT [DF_Diary_ratingProductivity]  DEFAULT ((1)) FOR [ratingProductivity]
GO
/****** Object:  Default [DF_Medication_StartDate]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Medication] ADD  CONSTRAINT [DF_Medication_StartDate]  DEFAULT (getdate()) FOR [StartDate]
GO
/****** Object:  Default [DF_Medication_Active]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Medication] ADD  CONSTRAINT [DF_Medication_Active]  DEFAULT ((1)) FOR [Active]
GO
/****** Object:  Default [DF_Patient_address_country]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Patient] ADD  CONSTRAINT [DF_Patient_address_country]  DEFAULT (N'USA') FOR [address_country]
GO
/****** Object:  Default [DF__Patient__date_jo__76619304]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Patient] ADD  CONSTRAINT [DF__Patient__date_jo__76619304]  DEFAULT (getdate()) FOR [date_joined]
GO
/****** Object:  Default [DF_Patient_userRole]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Patient] ADD  CONSTRAINT [DF_Patient_userRole]  DEFAULT ((1)) FOR [userRole]
GO
/****** Object:  Default [DF_PatientVitals_DateRecorded]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientVitals] ADD  CONSTRAINT [DF_PatientVitals_DateRecorded]  DEFAULT (getdate()) FOR [date_recorded]
GO
/****** Object:  Default [DF_Pharma_RX_OTC_TTY]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Pharma_RX_OTC] ADD  CONSTRAINT [DF_Pharma_RX_OTC_TTY]  DEFAULT ('SCD') FOR [TTY]
GO
/****** Object:  Default [DF_USER_FieldA_Grouping]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[USER_FieldA] ADD  CONSTRAINT [DF_USER_FieldA_Grouping]  DEFAULT (N'Default') FOR [Grouping]
GO
/****** Object:  ForeignKey [FK_Activity_ActivityType1]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Activity]  WITH CHECK ADD  CONSTRAINT [FK_Activity_ActivityType1] FOREIGN KEY([ExerciseTypeID])
REFERENCES [dbo].[ActivityType] ([ActivityTypeID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Activity] CHECK CONSTRAINT [FK_Activity_ActivityType1]
GO
/****** Object:  ForeignKey [FK_Activity_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Activity]  WITH CHECK ADD  CONSTRAINT [FK_Activity_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Activity] CHECK CONSTRAINT [FK_Activity_Patient]
GO
/****** Object:  ForeignKey [FK_ActivityTag_Activity]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[ActivityTag]  WITH CHECK ADD  CONSTRAINT [FK_ActivityTag_Activity] FOREIGN KEY([ExerciseID])
REFERENCES [dbo].[Activity] ([ExerciseID])
GO
ALTER TABLE [dbo].[ActivityTag] CHECK CONSTRAINT [FK_ActivityTag_Activity]
GO
/****** Object:  ForeignKey [FK_ActivityTag_Tag]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[ActivityTag]  WITH CHECK ADD  CONSTRAINT [FK_ActivityTag_Tag] FOREIGN KEY([TagID])
REFERENCES [dbo].[Tag] ([Id])
GO
ALTER TABLE [dbo].[ActivityTag] CHECK CONSTRAINT [FK_ActivityTag_Tag]
GO
/****** Object:  ForeignKey [FK_CommunicationLog_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[CommunicationLog]  WITH CHECK ADD  CONSTRAINT [FK_CommunicationLog_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[CommunicationLog] CHECK CONSTRAINT [FK_CommunicationLog_Patient]
GO
/****** Object:  ForeignKey [FK_CommunicationLog_Physician]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[CommunicationLog]  WITH CHECK ADD  CONSTRAINT [FK_CommunicationLog_Physician] FOREIGN KEY([PhysicianID])
REFERENCES [dbo].[HealthcareProvider] ([PhysicianID])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[CommunicationLog] CHECK CONSTRAINT [FK_CommunicationLog_Physician]
GO
/****** Object:  ForeignKey [FK_CommunicationLog_ReasonForCommunication]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[CommunicationLog]  WITH CHECK ADD  CONSTRAINT [FK_CommunicationLog_ReasonForCommunication] FOREIGN KEY([ReasonForCommunication])
REFERENCES [dbo].[ReasonForCommunication] ([ReasonForCommunicationID])
GO
ALTER TABLE [dbo].[CommunicationLog] CHECK CONSTRAINT [FK_CommunicationLog_ReasonForCommunication]
GO
/****** Object:  ForeignKey [FK_Diary_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Diary]  WITH CHECK ADD  CONSTRAINT [FK_Diary_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Diary] CHECK CONSTRAINT [FK_Diary_Patient]
GO
/****** Object:  ForeignKey [FK_Diary_USER_FieldA]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Diary]  WITH NOCHECK ADD  CONSTRAINT [FK_Diary_USER_FieldA] FOREIGN KEY([USER_FieldAId])
REFERENCES [dbo].[USER_FieldA] ([Id])
GO
ALTER TABLE [dbo].[Diary] CHECK CONSTRAINT [FK_Diary_USER_FieldA]
GO
/****** Object:  ForeignKey [FK_Diary_USER_FieldA1]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Diary]  WITH CHECK ADD  CONSTRAINT [FK_Diary_USER_FieldA1] FOREIGN KEY([USER_FieldA2Id])
REFERENCES [dbo].[USER_FieldA] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Diary] CHECK CONSTRAINT [FK_Diary_USER_FieldA1]
GO
/****** Object:  ForeignKey [FK_Diary_Sent_Log_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Diary_Sent_Log]  WITH CHECK ADD  CONSTRAINT [FK_Diary_Sent_Log_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
GO
ALTER TABLE [dbo].[Diary_Sent_Log] CHECK CONSTRAINT [FK_Diary_Sent_Log_Patient]
GO
/****** Object:  ForeignKey [FK_DiaryTags_Diary]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[DiaryTags]  WITH CHECK ADD  CONSTRAINT [FK_DiaryTags_Diary] FOREIGN KEY([DiaryID])
REFERENCES [dbo].[Diary] ([Id])
GO
ALTER TABLE [dbo].[DiaryTags] CHECK CONSTRAINT [FK_DiaryTags_Diary]
GO
/****** Object:  ForeignKey [FK_DiaryTags_Tag]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[DiaryTags]  WITH CHECK ADD  CONSTRAINT [FK_DiaryTags_Tag] FOREIGN KEY([TagID])
REFERENCES [dbo].[Tag] ([Id])
GO
ALTER TABLE [dbo].[DiaryTags] CHECK CONSTRAINT [FK_DiaryTags_Tag]
GO
/****** Object:  ForeignKey [FK_HealthcareProvider_State]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[HealthcareProvider]  WITH CHECK ADD  CONSTRAINT [FK_HealthcareProvider_State] FOREIGN KEY([addressStateID])
REFERENCES [dbo].[State] ([StateID])
GO
ALTER TABLE [dbo].[HealthcareProvider] CHECK CONSTRAINT [FK_HealthcareProvider_State]
GO
/****** Object:  ForeignKey [FK_Medication_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Medication]  WITH CHECK ADD  CONSTRAINT [FK_Medication_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
GO
ALTER TABLE [dbo].[Medication] CHECK CONSTRAINT [FK_Medication_Patient]
GO
/****** Object:  ForeignKey [FK_Medication_Pharma_RX_OTC]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Medication]  WITH CHECK ADD  CONSTRAINT [FK_Medication_Pharma_RX_OTC] FOREIGN KEY([PharmID])
REFERENCES [dbo].[Pharma_RX_OTC] ([PharmID])
GO
ALTER TABLE [dbo].[Medication] CHECK CONSTRAINT [FK_Medication_Pharma_RX_OTC]
GO
/****** Object:  ForeignKey [FK_Medication_Sig]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Medication]  WITH CHECK ADD  CONSTRAINT [FK_Medication_Sig] FOREIGN KEY([Sig])
REFERENCES [dbo].[Sig] ([SigAbbrID])
GO
ALTER TABLE [dbo].[Medication] CHECK CONSTRAINT [FK_Medication_Sig]
GO
/****** Object:  ForeignKey [FK_MedicationTags_Medication]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[MedicationTags]  WITH CHECK ADD  CONSTRAINT [FK_MedicationTags_Medication] FOREIGN KEY([MedicationID])
REFERENCES [dbo].[Medication] ([MedicationID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[MedicationTags] CHECK CONSTRAINT [FK_MedicationTags_Medication]
GO
/****** Object:  ForeignKey [FK_MedicationTags_Tag]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[MedicationTags]  WITH CHECK ADD  CONSTRAINT [FK_MedicationTags_Tag] FOREIGN KEY([TagID])
REFERENCES [dbo].[Tag] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[MedicationTags] CHECK CONSTRAINT [FK_MedicationTags_Tag]
GO
/****** Object:  ForeignKey [FK_Patient_Physician]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Physician] FOREIGN KEY([primary_physsician])
REFERENCES [dbo].[HealthcareProvider] ([PhysicianID])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Patient_Physician]
GO
/****** Object:  ForeignKey [FK_Patient_State]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Patient_State] FOREIGN KEY([addressState])
REFERENCES [dbo].[State] ([StateID])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Patient_State]
GO
/****** Object:  ForeignKey [FK_PatientDietaryRestriction_DietaryRestriction]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientDietaryRestriction]  WITH CHECK ADD  CONSTRAINT [FK_PatientDietaryRestriction_DietaryRestriction] FOREIGN KEY([DietaryRestrictionID])
REFERENCES [dbo].[DietaryRestriction] ([DietaryRestrictionID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PatientDietaryRestriction] CHECK CONSTRAINT [FK_PatientDietaryRestriction_DietaryRestriction]
GO
/****** Object:  ForeignKey [FK_PatientDietaryRestriction_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientDietaryRestriction]  WITH CHECK ADD  CONSTRAINT [FK_PatientDietaryRestriction_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PatientDietaryRestriction] CHECK CONSTRAINT [FK_PatientDietaryRestriction_Patient]
GO
/****** Object:  ForeignKey [FK_PatientMedication_Medication]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientMedication]  WITH CHECK ADD  CONSTRAINT [FK_PatientMedication_Medication] FOREIGN KEY([MedicationID])
REFERENCES [dbo].[Medication] ([MedicationID])
GO
ALTER TABLE [dbo].[PatientMedication] CHECK CONSTRAINT [FK_PatientMedication_Medication]
GO
/****** Object:  ForeignKey [FK_PatientMedication_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientMedication]  WITH CHECK ADD  CONSTRAINT [FK_PatientMedication_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
GO
ALTER TABLE [dbo].[PatientMedication] CHECK CONSTRAINT [FK_PatientMedication_Patient]
GO
/****** Object:  ForeignKey [FK_PatientPhysician_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientPhysician]  WITH CHECK ADD  CONSTRAINT [FK_PatientPhysician_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
GO
ALTER TABLE [dbo].[PatientPhysician] CHECK CONSTRAINT [FK_PatientPhysician_Patient]
GO
/****** Object:  ForeignKey [FK_PatientPhysician_Physician]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientPhysician]  WITH CHECK ADD  CONSTRAINT [FK_PatientPhysician_Physician] FOREIGN KEY([PhysicianID])
REFERENCES [dbo].[HealthcareProvider] ([PhysicianID])
GO
ALTER TABLE [dbo].[PatientPhysician] CHECK CONSTRAINT [FK_PatientPhysician_Physician]
GO
/****** Object:  ForeignKey [FK_PatientVitals_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[PatientVitals]  WITH CHECK ADD  CONSTRAINT [FK_PatientVitals_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PatientVitals] CHECK CONSTRAINT [FK_PatientVitals_Patient]
GO
/****** Object:  ForeignKey [FK_Pharma_RX_OTC_MedType]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Pharma_RX_OTC]  WITH CHECK ADD  CONSTRAINT [FK_Pharma_RX_OTC_MedType] FOREIGN KEY([MedType])
REFERENCES [dbo].[MedType] ([MedTypeID])
GO
ALTER TABLE [dbo].[Pharma_RX_OTC] CHECK CONSTRAINT [FK_Pharma_RX_OTC_MedType]
GO
/****** Object:  ForeignKey [FK_Tag_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[Tag]  WITH CHECK ADD  CONSTRAINT [FK_Tag_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Tag] CHECK CONSTRAINT [FK_Tag_Patient]
GO
/****** Object:  ForeignKey [FK_USER_FieldA_Patient]    Script Date: 11/02/2016 08:46:38 ******/
ALTER TABLE [dbo].[USER_FieldA]  WITH CHECK ADD  CONSTRAINT [FK_USER_FieldA_Patient] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patient] ([PatientID])
GO
ALTER TABLE [dbo].[USER_FieldA] CHECK CONSTRAINT [FK_USER_FieldA_Patient]
GO
