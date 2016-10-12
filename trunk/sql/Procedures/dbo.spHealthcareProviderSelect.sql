SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[spHealthcareProviderSelect] 
    @PhysicianID int
AS 
	SELECT [PhysicianID], [last_name], [first_name], [specialty], [WorkPhone], [CellPhone], [Pager], [Email], [Fax], [pathient_log_communication_preference] 
	FROM   [dbo].[HealthcareProvider] 
	WHERE  ([PhysicianID] = @PhysicianID OR @PhysicianID IS NULL) 

GO
