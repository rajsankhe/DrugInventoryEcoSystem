# DrugInventoryEcoSystem
## Project Overview 
Drug Inventory Management System provides a platform for the chemist to order medicinal drugs from the supplier. 
Once an order is at supplier end, supplier checks the chemist authenticity with legal records and then accept an order accordingly. 
Supplier fulfils the order by checking the availability of drugs in inventory, if stock is available then an order is delivered by
transportation department else supplier send bid request to manufacturers or request order from other suppliers.
Manufacturers will send quotation; and on bases of time and cost, supplier chooses the manufacturer.
We aim to build a system which provides a comprehensive and simple Inventory management system. 

## Application Key functionality 
- Create an order request - Check authenticity by legal department 
- Send bid request to manufacturers if drug not in stock
- Persist all data using Object Store and retrieve it on application start-up
- Email functionality and Auto-password generation 
- API call to check legal authority to sell drugs

