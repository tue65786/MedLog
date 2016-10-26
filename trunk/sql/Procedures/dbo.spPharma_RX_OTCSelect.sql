SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-26
-- Modify date: 2016-10-26
-- Description:
-- =============================================
CREATE PROC [dbo].[spPharma_RX_OTCSelect]
@PharmID int
, @Keyword nvarchar (128) 
AS
BEGIN
	SET NOCOUNT ON

	--TODO add search

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
END

GO
