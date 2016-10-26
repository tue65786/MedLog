SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
GO
/****** Script for SelectTopNRows command from SSMS  ******/
-- =============================================
-- Author:		Dan K.
-- Project:		MedLog
-- Create date: 2016-10-14
-- Modify date: 2016-10-26
-- Description:
-- =============================================
CREATE PROC [dbo].[spStateSelect]
AS
BEGIN
SET NOCOUNT ON;
SELECT [StateID]
      ,[StateName]
      ,[StateAbbreviation]
  FROM [dbo].[State]
  ORDER BY StateAbbreviation
END
GO
