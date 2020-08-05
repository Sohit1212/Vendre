package ECUtils;
public class ECConst {
	public static String DB_NAME ="vendre_db";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{
		"create table app_users (id INT NOT NULL AUTO_INCREMENT, email varchar(40), pass varchar(50), user_name varchar(50), phone_no varchar(15),  address TEXT, s_que varchar(100),  s_ans varchar(100),  role varchar(30),  status varchar(40),  PRIMARY KEY (id))",	
		"create table products (id INT NOT NULL AUTO_INCREMENT,  seller_id int, name varchar(40),  price double, item_desc text, category varchar(30),  status varchar(40),  PRIMARY KEY (id))",	
		"create table kart (id INT NOT NULL AUTO_INCREMENT, buyer_id int, order_date date, status varchar(40),  PRIMARY KEY (id))",	
		"create table order_items (id INT NOT NULL AUTO_INCREMENT, kart_id int, product_id int, status varchar(40),  PRIMARY KEY (id))",	
		"insert into app_users (email , pass, user_name, phone_no , address , s_que, s_ans, role,status ) "
					+ " values ('admin@gmail.com', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'approved')",	
		"create table combo_values (id INT NOT NULL AUTO_INCREMENT, c_type varchar(40), c_value varchar(100), PRIMARY KEY (id))",	
		"insert into combo_values (c_type , c_value) "
				+ " values ('sec_q', 'Favourite Color'), ('sec_q', 'Favourite Teacher'), ('sec_q', 'Favourite Sports'); ",	
		"insert into combo_values (c_type , c_value) "
				+ " values ('p_category', 'Mobile'), ('p_category', 'Electronics'), ('p_category', 'Cloths') , ('p_category', 'Sports'),  ('p_category', 'Other'); ",	
		"insert into combo_values (c_type , c_value) "
						+ " values ('p_status', 'Available'), ('p_status', 'Not Available'), ('p_status', 'Coming Soon'); ",	
	};
}
