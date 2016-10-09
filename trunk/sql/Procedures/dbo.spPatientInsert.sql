SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 
-- Description:	Inserts  Patient record
-- =============================================
CREATE PROC [dbo].[spPatientInsert]
@SSN nvarchar (30) = NULL
,@user_name nvarchar (60) = NULL
,@user_password nvarchar (30) = NULL
,@user_hash nvarchar (32) = NULL
,@first_name nvarchar (30) = NULL
,@last_name nvarchar (30) = NULL
,@phone_home nvarchar (50) = NULL
,@phone_mobile nvarchar (50) = NULL
,@primary_email nvarchar (100) = NULL
,@email2 nvarchar (100) = NULL
,@status nvarchar (25) = NULL
,@address_street nvarchar (150) = NULL
,@address_city nvarchar (100) = NULL
,@address_state nvarchar (100) = NULL
,@address_country nvarchar (25) = NULL
,@address_postalcode nvarchar (9) = NULL
,@user_preferences nvarchar (max) = NULL
,@pwd_last_changed datetime = NULL
,@fitbit_auth nvarchar (max) = NULL
,@lang nvarchar (10) = NULL
,@timezone_id nvarchar (128) = NULL
,@primary_physsician int = NULL
,@date_of_birth bit = NULL
,@date_joined date
,@picture nvarchar (max) = NULL
,@meta_data xml = NULL
,@inserted int OUTPUT
AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO [dbo].[Patient] ([SSN]
,								 [user_name]
,								 [user_password]
,								 [user_hash]
,								 [first_name]
,								 [last_name]
,								 [phone_home]
,								 [phone_mobile]
,								 [primary_email]
,								 [email2]
,								 [status]
,								 [address_street]
,								 [address_city]
,								 [address_state]
,								 [address_country]
,								 [address_postalcode]
,								 [user_preferences]
,								 [pwd_last_changed]
,								 [fitbit_auth]
,								 [lang]
,								 [timezone_id]
,								 [primary_physsician]
,								 [date_of_birth]
,								 [date_joined]
,								 [picture]
,								 [meta_data]) 
	SELECT @SSN
,		   @user_name
,		   @user_password
,		   @user_hash
,		   @first_name
,		   @last_name
,		   @phone_home
,		   @phone_mobile
,		   @primary_email
,		   @email2
,		   @status
,		   @address_street
,		   @address_city
,		   @address_state
,		   @address_country
,		   @address_postalcode
,		   @user_preferences
,		   @pwd_last_changed
,		   @fitbit_auth
,		   @lang
,		   @timezone_id
,		   @primary_physsician
,		   @date_of_birth
,		   @date_joined
,		   @picture
,		   @meta_data
	SET @inserted = IDENT_CURRENT ('[dbo].[Patient]') 
END
GO
