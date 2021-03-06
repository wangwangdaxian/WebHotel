USE [master]
GO
/****** Object:  Database [hotel]    Script Date: 2018/1/4 20:14:11 ******/
CREATE DATABASE [hotel] ON  PRIMARY 
( NAME = N'hotel', FILENAME = N'D:\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\hotel.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'hotel_log', FILENAME = N'D:\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\hotel_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [hotel].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [hotel] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [hotel] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [hotel] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [hotel] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [hotel] SET ARITHABORT OFF 
GO
ALTER DATABASE [hotel] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [hotel] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [hotel] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [hotel] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [hotel] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [hotel] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [hotel] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [hotel] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [hotel] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [hotel] SET  DISABLE_BROKER 
GO
ALTER DATABASE [hotel] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [hotel] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [hotel] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [hotel] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [hotel] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [hotel] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [hotel] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [hotel] SET RECOVERY FULL 
GO
ALTER DATABASE [hotel] SET  MULTI_USER 
GO
ALTER DATABASE [hotel] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [hotel] SET DB_CHAINING OFF 
GO
EXEC sys.sp_db_vardecimal_storage_format N'hotel', N'ON'
GO
USE [hotel]
GO
/****** Object:  Table [dbo].[Administor]    Script Date: 2018/1/4 20:14:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administor](
	[UserID] [char](18) NOT NULL,
	[Name] [varchar](20) NULL,
	[Password] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AdvanceOrder]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AdvanceOrder](
	[orderID] [char](11) NOT NULL,
	[UserID] [char](18) NOT NULL,
	[TypeName] [varchar](20) NOT NULL,
	[InDate] [date] NULL,
	[OutDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[UserID] [char](18) NOT NULL,
	[Name] [varchar](20) NULL,
	[Password] [varchar](10) NOT NULL,
	[Phone] [char](11) NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderForm]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderForm](
	[orderID] [char](19) NOT NULL,
	[AdmsID] [char](18) NOT NULL,
	[CustID] [char](18) NOT NULL,
	[RoomID] [char](3) NOT NULL,
	[InDate] [date] NULL,
	[OutDate] [date] NULL,
	[OrderState] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RoomID] [char](3) NOT NULL,
	[TypeName] [varchar](20) NOT NULL,
	[RoomFloor] [char](1) NULL,
	[Orientation] [varchar](4) NULL,
	[Feature] [varchar](20) NULL,
	[RoomState] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoomType]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoomType](
	[TypeName] [varchar](20) NOT NULL,
	[Price] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TypeName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[CustisHere]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[CustisHere]
as
select CustID,Name,RoomID,InDate,OutDate,phone
from Customer,OrderForm
where Customer.UserID=OrderForm.CustID and OrderState='进行中'
GO
ALTER TABLE [dbo].[AdvanceOrder]  WITH CHECK ADD FOREIGN KEY([TypeName])
REFERENCES [dbo].[RoomType] ([TypeName])
GO
ALTER TABLE [dbo].[AdvanceOrder]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Customer] ([UserID])
GO
ALTER TABLE [dbo].[OrderForm]  WITH CHECK ADD FOREIGN KEY([AdmsID])
REFERENCES [dbo].[Administor] ([UserID])
GO
ALTER TABLE [dbo].[OrderForm]  WITH CHECK ADD FOREIGN KEY([CustID])
REFERENCES [dbo].[Customer] ([UserID])
GO
ALTER TABLE [dbo].[OrderForm]  WITH CHECK ADD FOREIGN KEY([RoomID])
REFERENCES [dbo].[Room] ([RoomID])
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD FOREIGN KEY([TypeName])
REFERENCES [dbo].[RoomType] ([TypeName])
GO
/****** Object:  Trigger [dbo].[updateCustid]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[updateCustid]
on [dbo].[Customer]
for update
as
if update(UserID)
begin 
	update AdvanceOrder
	set UserID=i.UserID
	from AdvanceOrder ao,Deleted d,Inserted i
	where ao.UserID=d.UserID
end

GO
ALTER TABLE [dbo].[Customer] ENABLE TRIGGER [updateCustid]
GO
/****** Object:  Trigger [dbo].[updateCustid2]    Script Date: 2018/1/4 20:14:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[updateCustid2]
on [dbo].[Customer]
for update
as
if update(UserID)
begin 
	update OrderForm
	set CustID=i.UserID
	from OrderForm o,Deleted d,Inserted i
	where o.CustID=d.UserID
end
GO
ALTER TABLE [dbo].[Customer] ENABLE TRIGGER [updateCustid2]
GO
USE [master]
GO
ALTER DATABASE [hotel] SET  READ_WRITE 
GO
