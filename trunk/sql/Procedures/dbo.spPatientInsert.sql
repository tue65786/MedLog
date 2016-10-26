SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 2016-10-22
-- Description:	Inserts  Patient record
-- =============================================
CREATE PROC [dbo].[spPatientInsert]
@userName nvarchar (60) = NULL
,@userPassword nvarchar (30) = NULL
,@user_hash nvarchar (32) = NULL
,@firstName nvarchar (30) = NULL
,@lastName nvarchar (30) = NULL
,@phoneHome nvarchar (50) = NULL
,@phoneMobile nvarchar (50) = NULL
,@email nvarchar (100) = NULL
,@status nvarchar (25) = NULL
,@addressStreet nvarchar (150) = NULL
,@addressCity nvarchar (100) = NULL
,@addressState int = 2
,@address_country nvarchar (25) = NULL
,@address_postalcode nvarchar (9) = NULL
,@user_preferences nvarchar (max) = NULL
,@pwd_last_changed datetime = NULL
,@lang nvarchar (10) = 'en-us'
,@timezone_id nvarchar (128) = NULL
,@primary_physsician int = NULL
,@date_of_birth date = NULL
,@date_joined date = GETDATE
,@picture nvarchar (max) = NULL
,@meta_data xml = NULL
,@userRole int = NULL
, @inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT OFF;
	INSERT INTO [dbo].[Patient] ([userName]
,								 [userPassword]
,								 [user_hash]
,								 [firstName]
,								 [lastName]
,								 [phoneHome]
,								 [phoneMobile]
,								 [email]
,								 [status]
,								 [addressStreet]
,								 [addressCity]
,								 [addressState]
,								 [address_country]
,								 [address_postalcode]
,								 [user_preferences]
,								 [pwd_last_changed]
,								 [lang]
,								 [timezone_id]
,								 [primary_physsician]
,								 [date_of_birth]
,								 [date_joined]
,								 [picture]
,								 [meta_data]
,								 [userRole]) 
	SELECT @userName
,		   @userPassword
,		   @user_hash
,		   @firstName
,		   @lastName
,		   @phoneHome
,		   @phoneMobile
,		   @email
,		   @status
,		   @addressStreet
,		   @addressCity
,		   @addressState
,		   @address_country
,		   @address_postalcode
,		   @user_preferences
,		   @pwd_last_changed
,		   @lang
,		   @timezone_id
,		   @primary_physsician
,		   @date_of_birth
,		   ISNULL(@date_joined,GETDATE())
,		   @picture
,		   @meta_data
,		   @userRole
	SET @inserted = IDENT_CURRENT ('[dbo].[Patient]') 
END

GO
