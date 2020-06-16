use master
go
if exists (select * from sys.databases where name =N'QuanLyCaPhe')
	drop database QuanLyCaPhe
go
Create Database QuanLyCaPhe
go 
use QuanLyCaPhe
go
CREATE TABLE Users(
	Username nvarchar(50) NOT NULL,
	Password nvarchar(50) NOT NULL,
	Fullname nvarchar(50) NOT NULL,
	PRIMARY KEY(Username)
)
GO
CREATE TABLE Category(
	ID int primary key IDENTITY(1,1),
	Name nvarchar(50)
)
GO
CREATE TABLE Product(
	ID int primary key IDENTITY(1,1),
	Name nvarchar(100),
	CategoryID int,
	Photo nvarchar(100),
	Price float,
	Describe nvarchar(500),
	FOREIGN KEY(CategoryID) REFERENCES Category(Id) ON DELETE NO ACTION ON UPDATE CASCADE
)
GO
CREATE TABLE Sale(
	ID int primary key IDENTITY(1,1),
	ProductID int,
	Date date,
	FOREIGN KEY(ProductID) REFERENCES Product(Id) ON DELETE NO ACTION ON UPDATE CASCADE
)