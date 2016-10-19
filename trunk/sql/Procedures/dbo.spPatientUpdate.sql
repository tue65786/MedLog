SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 016-10-19
-- Description:	Updates  Patient record
-- =============================================
CREATE PROC [dbo].[spPatientUpdate] 
    @PatientID int,
    @userName nvarchar(60) = NULL,
    @userPassword nvarchar(30) = NULL,
    @user_hash nvarchar(32) = NULL,
    @firstName nvarchar(30) = NULL,
    @lastName nvarchar(30) = NULL,
    @phoneHome nvarchar(50) = NULL,
    @phoneMobile nvarchar(50) = NULL,
    @email nvarchar(100) = NULL,
    @status nvarchar(25) = NULL,
    @addressStreet nvarchar(150) = NULL,
    @addressCity nvarchar(100) = NULL,
    @addressState int = NULL,
    @address_country nvarchar(25) = NULL,
    @address_postalcode nvarchar(9) = NULL,
    @user_preferences nvarchar(MAX) = NULL,
    @pwd_last_changed datetime = NULL,
    @lang nvarchar(10) = NULL,
    @timezone_id nvarchar(128) = NULL,
    @primary_physsician int = NULL,
    @date_of_birth bit = NULL,
    @date_joined date,
    @picture nvarchar(MAX) = NULL,
    @meta_data xml = NULL,
    @userRole int = NULL
AS 
BEGIN
	SET NOCOUNT OFF
	UPDATE [dbo].[Patient]
	SET    [userName] = @userName, [userPassword] = @userPassword, [user_hash] = @user_hash, [firstName] = @firstName, [lastName] = @lastName, [phoneHome] = @phoneHome, [phoneMobile] = @phoneMobile, [email] = @email, [status] = @status, [addressStreet] = @addressStreet, [addressCity] = @addressCity, [addressState] = @addressState, [address_country] = @address_country, [address_postalcode] = @address_postalcode, [user_preferences] = @user_preferences, [pwd_last_changed] = @pwd_last_changed, [lang] = @lang, [timezone_id] = @timezone_id, [primary_physsician] = @primary_physsician, [date_of_birth] = @date_of_birth, [date_joined] = @date_joined, [picture] = @picture, [meta_data] = @meta_data, [userRole] = @userRole
	WHERE  [PatientID] = @PatientID
	
END
GO
