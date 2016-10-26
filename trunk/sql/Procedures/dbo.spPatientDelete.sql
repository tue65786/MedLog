SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-10
-- Modify date: 016-10-19
-- Description:	Delete  Patient record
-- =============================================
CREATE PROC [dbo].[spPatientDelete]
@PatientID int
AS DELETE
   FROM   [dbo].[Patient]
   WHERE  [PatientID] = @PatientID

GO
