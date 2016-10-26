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
