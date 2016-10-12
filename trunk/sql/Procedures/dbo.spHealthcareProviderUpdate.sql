SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spHealthcareProviderUpdate] 
    @PhysicianID int,
    @last_name nvarchar(MAX),
    @first_name nvarchar(MAX),
    @specialty nvarchar(256) = NULL,
    @WorkPhone nvarchar(256),
    @CellPhone nvarchar(256) = NULL,
    @Pager varbinary(50) = NULL,
    @Email nvarchar(256) = NULL,
    @Fax nchar(10) = NULL,
    @pathient_log_communication_preference varchar(20) = NULL
AS 
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[HealthcareProvider]
	SET    [PhysicianID] = @PhysicianID, [last_name] = @last_name, [first_name] = @first_name, [specialty] = @specialty, [WorkPhone] = @WorkPhone, [CellPhone] = @CellPhone, [Pager] = @Pager, [Email] = @Email, [Fax] = @Fax, [pathient_log_communication_preference] = @pathient_log_communication_preference
	WHERE  [PhysicianID] = @PhysicianID
	
END
GO
