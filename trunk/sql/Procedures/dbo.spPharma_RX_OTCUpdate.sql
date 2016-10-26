SET ANSI_NULLS ON
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
