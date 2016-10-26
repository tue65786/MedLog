SET ANSI_NULLS ON
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
