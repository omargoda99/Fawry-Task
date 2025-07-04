# Fawry-Task
First of all I'm gonna explain the structure of the project and my point of view

overview logic : 
Every Shop has products
and every shop has customers
and customer buys whatever he wants and adds to the cart
every cart has cart items even if it's empty
and after that there is a checkout system to ensure what customer chooses in cart 
and checkout doesn't proceed if the cart is empty or the product itself is unavailable or the customer doesn't have enough money to pay

that was the logical point of view of the general system

let's go techninaclly :

the product class is abstract because it's the general view of a product not a product itself and it has abstract method which are
isExpired and needsShipping since it has abstract methods, the class must be abstract as well

and making 2 interfaces like Expirable and Shippable makes it more abstract and resuable then
making the 3 types of products inherited from the abstract product class some of them are expirable and shippable and some are only shippable and some are none of them

and the customer normally has name and balance 
name is ignored in my opinion i didn't see a supermarket or even a huge franchise like carrefour asks a name of a customer while paying it's not neccessary and consumes alot of time

and customer has 3 methods, his amount of money and his ability to pay, and the payment action itself

and then the cart and cart item

every cart has cart items
and the cart item only has the product and its quantity and the total price is the product quantity multiplied by its price

the cart itself contains cart items if the product is out of stock it gets an error that you want to add an out of stock product to the cart else you can add the items you want

after all of that comes the checkout system 
if the cart is empty it throws an exception 
and after listing all cart items if the item is out of stock it throws an exception 
and if it's expirable and actually expired it throws an exception as well

else it will add total price and add 30 if it was shippable 
and add the shppied items to toShipping list to see what items should be shipped

and then if there are shippable items add 30 to the total 
then if customer can't pay that total throws an exception

then if he can pay he will do so

and then i created the shipment notice
by checking if the item is instance of shippable and needs shipping and then compute the total number of items he chooses and the weight of them
then creates the checkout receipt
it will compute the total price of all items the customer chooses within the subtotal and then add the shipping if there were any shippable items and after that gives the total price

