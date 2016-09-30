SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[DiaryTags] (
		[DiaryID]     [int] NOT NULL,
		[TagID]       [int] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DiaryTags]
	ADD
	CONSTRAINT [PK_DiaryTags]
	PRIMARY KEY
	CLUSTERED
	([DiaryID], [TagID])
	ON [PRIMARY]
GO
ALTER TABLE [dbo].[DiaryTags]
	WITH CHECK
	ADD CONSTRAINT [FK_DiaryTags_Diary]
	FOREIGN KEY ([DiaryID]) REFERENCES [dbo].[Diary] ([Id])
ALTER TABLE [dbo].[DiaryTags]
	CHECK CONSTRAINT [FK_DiaryTags_Diary]

GO
ALTER TABLE [dbo].[DiaryTags]
	WITH CHECK
	ADD CONSTRAINT [FK_DiaryTags_Tag]
	FOREIGN KEY ([TagID]) REFERENCES [dbo].[Tag] ([Id])
ALTER TABLE [dbo].[DiaryTags]
	CHECK CONSTRAINT [FK_DiaryTags_Tag]

GO
ALTER TABLE [dbo].[DiaryTags] SET (LOCK_ESCALATION = TABLE)
GO
