select cust.customer_name,sal.salesman_name from salesman sal , customers cust where cust.salesman_id = sal.salesman_id;

select c.customer_name,c.customer_id from customers c, salesman sal where c.grade <300 and   c.salesman_id = sal.salesman_id order by c.customer_id;

select cust.customer_name,sal.salesman_name,sal.commission from customers cust, salesman sal where cust.salesman_id =sal.salesman_id and sal.commission >12;

select o.order_no,o.order_date,o.purchase_amount,c.customer_name,s.commission,s.salesman_name from orders o ,customers c,salesman s 
where o.customer_id = c.customer_id  and c.salesman_id =s.salesman_id;