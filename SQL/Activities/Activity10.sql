select o.order_no,o.purchase_amount,o.order_date,o.customer_id,o.salesman_id from orders o 
where o.salesman_id in (select salesman_id from customers ) and o.customer_id =3007;

select *from orders o  where o.salesman_id in (select c.salesman_id from  customers c  where c.city = 'New York' );

select count(c.customer_id),grade from customers c group by grade having grade > (select avg(grade) from customers where city = 'New York');

select *from orders o where o.salesman_id in (select salesman_id from salesman where commission in(  select max(commission) from salesman)); 