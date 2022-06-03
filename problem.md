# BackofficeSprits-App

### Objective/ Vision

Build a system that allows reception of orders of spirits bottle boxes. An order contains multiple item number and quantity

Example:

Order # QC213_211006_0102110101_FR is an order for the Warehouse 213 located in Quebec, created in 2021-10-06 with a random unique number “0102110101” from France.

Information available for an order

1.	Order number

2.	GrossWeight (kg)

3.	Truck number (Qc_8849_AZMG_001939)

4.	Creation date and time of the order in UTC

5.	Driver (ex. hugo.lloris)

6.	ReceivedBy (warehouse user)

7.	Reception Signature

8.	Reception date and time of the order in UTC



###Content of the order

Sku	        Name                            	              Qty	        BoxType

ABMT_2019	Alain Brumont Madiran Tour	                  20    	Box_12

ABM_4L	    Antoine Bonet Merlot	                        10	    Box_6

CHBPGC_2011	Câtea Haut-Brion Premier Grand Cru Classé 2011	3	Ea

###BoxTypes

Name	Qty per Box

Box_12	12

Ea	1

Box_6	6


### Users
Name	    Warehouse numbers

paul.pogba	        213

antoine.friezmann	746

raphael.varane	    213 and 746


### Warehouses

Name	Warehouse number

Montreal	213

Drummondville	746

Sherbrooke	933

Saguenay	738

Shawinigan	219

On receiving, the Warehouse user scans and confirms reception of items. When order is fully acknowledge, the inventory of the location if updated only for received items. Any non-acknowledge item requires a comment before completion. Warehouse user can only perform the reception process from his location.
For Capstone project purpose, the user registration process is already set in a database (they already exists. Another system is taking care of it)
For Capstone project purpose, the order data already exists in a database (Another system is taking care of it)


### Functional Requirements

1)	Warehouse user should be able to login in the system. 

2)	Once connected, Warehouse user access the list of order to be received.

a.	Only orders from the available warehouses to the user are listed and orders that are not received yet.

b.	Because the list may have 100+ orders a search field is available to the user and search on many fields at the same time

i.	Date: Ex. 2021-10-06 find orders created on this date

ii.	Warehouse num: Ex. 213 find order for warehouse 213 (* attention user must have access to that warehouse to see it)

iii.	Full order number:

c.	If only one result is returned. The warehouse is redirected to the order detail for confirmation of reception.

3)	The order reception page contains

a.	The information from the order (see objective section #2)

b.	Each line of item has a field (a check) to confirm the receiving quantity

i.	Quantity can be lower or equal to order

ii.	When received quantity is lower than the order, the warehouse user must add a comment to explain the difference (not in order, broken box, etc)

iii.	A check is available to confirm each line.

iv.	Warehouse must sign and submit the reception of the order (sign and upload as image on server)

c.	On submit, inventory table is update with bottle quantity. System no longer see box unit type.

4)	Warehouse user can view inventory.

a.	List of product (sku number) with image, name, inventory count (aggregate of all warehouses for that product)

b.	When user client on a sku, an accordion type detail is displayed on screen to show the inventory by warehouse.

#### The Application needs to meet the below requirements 

•  Proper navigation links for all the pages should be available within pages. 

•  validation should be implemented across pages. Appropriate messages should be displayed for the same.  

•  Stitching views using Routes and Guards 

•  Making the application Responsive/Progressive 

•  Unit Tests should be created for the Components and Services 

•  Authenticated User to get JWT Token for accessing secured services

•  E2E scripts should be created for the functional flows 

•  Implement CI - continuous Integration 

•  JWT Filter should be applied for all the API calls of the secured endpoints. 

•  AOP & Swagger to be implemented

•  Entire application should be containerized

•  Register the services with Eureka
