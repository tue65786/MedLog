SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[spHealthcareProviderInsert] 
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
, @inserted INT OUTPUT
AS 
BEGIN
	SET NOCOUNT ON 
	INSERT INTO [dbo].[HealthcareProvider] ([PhysicianID], [last_name], [first_name], [specialty], [WorkPhone], [CellPhone], [Pager], [Email], [Fax], [pathient_log_communication_preference])
	SELECT @PhysicianID, @last_name, @first_name, @specialty, @WorkPhone, @CellPhone, @Pager, @Email, @Fax, @pathient_log_communication_preference      
SET @inserted = Ident_current ('[dbo].[HealthcareProvider]')
END
GO
