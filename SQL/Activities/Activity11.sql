select c.customer_name,c.customer_id from customers c where 1< (select count(*) from orders o where o.customer_id = c.customer_id) 
union select s.salesman_name,s.salesman_id from salesman s where 1 < ( select count(*) from orders o where o.salesman_id = s.salesman_id);



SELECT a.salesman_id, a.salesman_name, order_no, 'highest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, order_no, 'lowest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);