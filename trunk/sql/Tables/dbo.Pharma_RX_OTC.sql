SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Pharma_RX_OTC] (
		[PharmID]                  [int] IDENTITY(1, 1) NOT NULL,
		[MedType]                  [varchar](16) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[RXCUI]                    [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[GENERIC_RXCUI]            [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[TTY]                      [varchar](20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[FULL_NAME]                [varchar](3000) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[RXN_DOSE_FORM]            [varchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[FULL_GENERIC_NAME]        [varchar](3000) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[BRAND_NAME]               [varchar](500) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[DISPLAY_NAME]             [varchar](3000) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[ROUTE]                    [varchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[NEW_DOSE_FORM]            [varchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[STRENGTH]                 [varchar](500) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
		[SUPPRESS_FOR]             [varchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[DISPLAY_NAME_SYNONYM]     [varchar](500) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[IS_RETIRED]               [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[SXDG_RXCUI]               [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[SXDG_TTY]                 [varchar](20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[SXDG_NAME]                [varchar](3000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
		[PSN]                      [varchar](3000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Pharma_RX_OTC]
	ADD
	CONSTRAINT [PK__Pharma_R__16360C9F793DFFAF]
	PRIMARY KEY
	CLUSTERED
	([PharmID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[Pharma_RX_OTC]
	WITH CHECK
	ADD CONSTRAINT [FK_Pharma_RX_OTC_MedType]
	FOREIGN KEY ([MedType]) REFERENCES [dbo].[MedType] ([MedTypeID])
ALTER TABLE [dbo].[Pharma_RX_OTC]
	CHECK CONSTRAINT [FK_Pharma_RX_OTC_MedType]

GO
ALTER TABLE [dbo].[Pharma_RX_OTC] SET (LOCK_ESCALATION = TABLE)
GO
