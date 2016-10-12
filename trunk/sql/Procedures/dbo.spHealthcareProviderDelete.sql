SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spHealthcareProviderDelete] 
    @PhysicianID int
AS 
	DELETE
	FROM   [dbo].[HealthcareProvider]
	WHERE  [PhysicianID] = @PhysicianID
	
GO
