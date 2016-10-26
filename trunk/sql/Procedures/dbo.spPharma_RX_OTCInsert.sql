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
	SET NOCOUNT ON
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
	SELECT @MedType
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
