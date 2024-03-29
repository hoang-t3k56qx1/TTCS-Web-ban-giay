CREATE DATABASE [TTCS]
GO
USE [TTCS]
GO
/****** Object:  Table [dbo].[Catalog]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Catalog](
	[c_id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY ,
	[c_name] [nvarchar](255) NOT NULL,
)
/****** Object:  Table [dbo].[Product]     ******/
GO
CREATE TABLE [dbo].[Product](
	[p_id] [int] IDENTITY(1,1) NOT NULL  PRIMARY KEY,
	[p_name] [nvarchar](50) NOT NULL,
	[image] [nvarchar](max) NOT NULL,
	[price] [money] NOT NULL,
	[title] [nvarchar](max) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[c_id] [int] NOT NULL,
	CONSTRAINT FK_Product FOREIGN KEY (c_id)
    REFERENCES Catalog(c_id)
)
GO
/****** Object:  Table [dbo].[User]    ******/
CREATE TABLE [dbo].[User](
	[u_id] [int]  IDENTITY(1,1) NOT NULL  PRIMARY KEY,
	[user] [nvarchar](50) NOT NULL,
	[pass] [nvarchar](50) NOT NULL,
	[u_name] [nvarchar](50) NOT NULL,
	[dateofbirth] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](50) NOT NULL,
	[manager] [int] NOT NULL
)


GO
CREATE TABLE [dbo].[Order](
	[o_id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[date] [nvarchar](50) NOT NULL,
	[u_id] [int] NOT NULL,
	[totalmoney] [money] NOT NULL,
	CONSTRAINT FK_Order FOREIGN KEY (u_id)
    REFERENCES [User](u_id)
)

GO
CREATE TABLE [dbo].[OrderLine](
	[id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[o_id] [int] NOT NULL,
	[p_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [money] NOT NULL,
	CONSTRAINT FK_OrderLine_Product FOREIGN KEY (p_id) REFERENCES [Product](p_id),
	CONSTRAINT FK_OrderLine_Order FOREIGN KEY (o_id) REFERENCES [Order](o_id)
 )
GO


INSERT [dbo].[Catalog]  VALUES ( N'GIÀY ADIDAS')
INSERT [dbo].[Catalog]  VALUES ( N'GIÀY NIKE')
INSERT [dbo].[Catalog]  VALUES ( N'GIÀY THỂ THAO')
INSERT [dbo].[Catalog]  VALUES ( N'GIÀY CONVERSE')

GO
INSERT [dbo].[User]  VALUES ( N'admin',N'123',N'hoang',N'01/12/2001',N'lehuyhoangt3@gmail.com',N'0358828708',1)
