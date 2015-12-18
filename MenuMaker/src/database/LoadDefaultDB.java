package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class LoadDefaultDB {
	
	public static void loadDB() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:sqlite:mmdefault.db");
		Statement statement = conn.createStatement();
		statement.setQueryTimeout(30);
		
		// Drop Existing Tables
		statement.executeUpdate("drop table if exists categories");
		statement.executeUpdate("drop table if exists recipes");
		statement.executeUpdate("drop table if exists currentmenu");
		statement.executeUpdate("drop table if exists ingredients");
		statement.executeUpdate("drop table if exists recipeingredients");
		
		// Create New Tables
		statement.executeUpdate("create table categories(catid integer, catname varchar(20))");
		statement.executeUpdate("create table currentmenu(id integer, recname varchar(50), "
				+ "recdesc varchar(120), recid integer)");
		statement.executeUpdate("create table recipes(recid integer, recname varchar(50), "
				+ "recdesc varchar(120), reccatid integer)");
		statement.executeUpdate("create table ingredients(ingid integer, ingitem varchar(30), "
				+ "ingstore varchar(20), ingqty integer)");
		statement.executeUpdate("create table recipeingredients(recingid integer, recid integer, "
				+ "ingid integer, recingname varchar(50))");
		
		// Populate Categories Table
		statement.executeUpdate("insert into categories values(1, 'Paleo')");
		statement.executeUpdate("insert into categories values(2, 'Tex-Mex')");
		statement.executeUpdate("insert into categories values(3, 'Traditional')");
		statement.executeUpdate("insert into categories values(4, 'Comfort Food')");
		statement.executeUpdate("insert into categories values(5, 'Crock Pot Cooking')");
		statement.executeUpdate("insert into categories values(6, 'Easy Meals')");
		statement.executeUpdate("insert into categories values(7, 'Weekend Meals')");
		
		// Populate Recipes Table
		
		statement.executeUpdate("insert into recipes values(1, 'Burgers and Fries', "
				+ "'Angus Burgers and Seasoned French Fries', 6)");
		statement.executeUpdate("insert into recipes values(2, 'BBQ Pork Sandwiches', "
				+ "'BBQ Pork Sandwiches with Tater Tots', 6)");
		statement.executeUpdate("insert into recipes values(3, 'Beef Stroganoff', "
				+ "'Beef Stroganoff with Canned Corn on the side', 6)");
		statement.executeUpdate("insert into recipes values(4, 'Biscuits and Gravy', "
				+ "'Buttermilk Biscuits with Sausage Gravy', 6)");
		statement.executeUpdate("insert into recipes values(5, 'BLTs', "
				+ "'Bacon, Lettuce and Tomato Sandwiches', 6)");
		statement.executeUpdate("insert into recipes values(6, 'Buffalo Wings', "
				+ "'Baked Buffalo Wings with Tobasco sauce', 1)");
		statement.executeUpdate("insert into recipes values(7, 'Cheeseburger Mac', "
				+ "'Cheeseburger Mac with Green Beans on the side', 6)");
		statement.executeUpdate("insert into recipes values(8, 'Chicken Cacciatore', "
				+ "'Baked Chicken Cacciatori', 1)");
		statement.executeUpdate("insert into recipes values(9, 'Chicken Enchiladas', "
				+ "'Chicken and sour cream filled tortillas, covered in enchilada sauce', 2)");
		statement.executeUpdate("insert into recipes values(10, 'Chicken Wine Bake', "
				+ "'Pan-fried chicken  breasts, baked in a mushroom wine gravy, with mashed potatoes', 7)");
		statement.executeUpdate("insert into recipes values(11, 'Chili', "
				+ "'Traditional meat, tomato and bean chili', 2)");
		statement.executeUpdate("insert into recipes values(12, 'Cinco de Mayo Skillet', "
				+ "'Like a taco salad, minus the tortilla chips and with black beans and rice added', 2)");
		statement.executeUpdate("insert into recipes values(13, 'Coneys', "
				+ "'Hot dogs with chili, onion and shredded cheddar cheese', 6)");
		statement.executeUpdate("insert into recipes values(14, 'Corned Beef and Cabbage', "
				+ "'Corned beef brisket baked with cabbage leaves and red potatoes', 7)");
		statement.executeUpdate("insert into recipes values(15, 'Beef and Noodles', "
				+ "'Beef roast slow cooked, shredded, and served over buttered egg noodles', 5)");
		statement.executeUpdate("insert into recipes values(16, 'Beef Stew', "
				+ "'Stew of beef, mixed vegetables and baby potatoes', 5)");
		statement.executeUpdate("insert into recipes values(17, 'Meatball Sandwiches', "
				+ "'Meatballs slow cooked in a tomato sauce, served on hoagie rolls with provolone cheese', 5)");
		statement.executeUpdate("insert into recipes values(18, 'Cuban Sandwiches', "
				+ "'Pressed hoagie rolls with cooked pork, ham, pickle, swiss cheese, and mustard', 7)");
		statement.executeUpdate("insert into recipes values(19, 'Fish and Chips', "
				+ "'Fried fish filets and french fries sprinkled with malt vinegar', 6)");
		statement.executeUpdate("insert into recipes values(20, 'Fried Chicken', "
				+ "'Pan-fried chicken, served with mashed potatoes and gravy and green beans', 4)");
		statement.executeUpdate("insert into recipes values(21, 'Frito Pie', "
				+ "'Casserole made with layers of corn chips, chili, and shredded cheddar cheese', 2)");
		statement.executeUpdate("insert into recipes values(22, 'Garlic Chicken Pasta', "
				+ "'Grilled chicken breast pieces, served with penne in a garlic oil sauce', 6)");
		statement.executeUpdate("insert into recipes values(23, 'Goulash', "
				+ "'Classic dish of ground beef, macaroni, and tomatos', 3)");
		statement.executeUpdate("insert into recipes values(24, 'Grilled Cheese', "
				+ "'Grilled cheese sandwiches served with tomato soup', 4)");
		statement.executeUpdate("insert into recipes values(25, 'Jambalaya', "
				+ "'Boxed jambalaya mix, cooked with sliced of smoked sausage', 6)");
		statement.executeUpdate("insert into recipes values(26, 'Box Lasagna', "
				+ "'Boxed lasagna served with texas toast', 6)");
		statement.executeUpdate("insert into recipes values(27, 'Macaroni Bake', "
				+ "'Casserole of ground beef, macaroni, spaghetti sauce, cheddar "
				+ "and mozzarella cheeses', 7)");
		statement.executeUpdate("insert into recipes values(28, 'Meal in Foil', "
				+ "'Ground beef, vegetables, potatoes and cheese, baked in a foil packet', 6)");
		statement.executeUpdate("insert into recipes values(29, 'Meatloaf', "
				+ "'Meatloaf served with mashed potatoes and green beans', 4)");
		statement.executeUpdate("insert into recipes values(30, 'Minestrone', "
				+ "'Soup of beef stock, ground beef, and vegetables', 3)");
		statement.executeUpdate("insert into recipes values(31, 'Pepper Steaks', "
				+ "'Pepper steaks served with couscous and green beans', 6)");
		statement.executeUpdate("insert into recipes values(32, 'Pizza', 'Oven-fresh pizza', 6)");
		statement.executeUpdate("insert into recipes values(33, 'Poor Mans Stroganoff', "
				+ "'Egg noodles, ground beef, and cream of mushroom soup', 6)");
		statement.executeUpdate("insert into recipes values(34, 'Pork Chops', "
				+ "'Pan-fried pork chops, served with cornmeal gravy and green beans', 7)");
		statement.executeUpdate("insert into recipes values(35, 'Pork Fritter Sandwiches', "
				+ "'Pork fritter sandwiches with lettuce, tomato and onion', 6)");
		statement.executeUpdate("insert into recipes values(36, 'Pork Tenderloin', "
				+ "'Baked pork tenderloin, served with dressing and mixed vegetables', 7)");
		statement.executeUpdate("insert into recipes values(37, 'Reuben Casserole', "
				+ "'Casserole of rye croutons, corned beef, sauerkraut, sliced swiss cheese "
				+ "and thousand island dressing', 6)");
		statement.executeUpdate("insert into recipes values(38, 'Ribeye Stir Fry', "
				+ "'Stir fry of ribeye steaks and onion, served over rice with soy sauce or "
				+ "worchestershire sauce', 6)");
		statement.executeUpdate("insert into recipes values(39, 'Roast Kit', "
				+ "'Pork or beef roast kit, with vegetables and potatoes', 5)");
		statement.executeUpdate("insert into recipes values(40, 'Salmon Patties', "
				+ "'Pan-fried salmon patties served with fried potatos and onions', 7)");
		statement.executeUpdate("insert into recipes values(41, 'Shepherds Pie', "
				+ "'Casserole of ground beef, peas and corn with worchestershire sauce, topped "
				+ "wth mashed potatoes', 7)");
		statement.executeUpdate("insert into recipes values(42, 'Spaghetti', "
				+ "'Spaghetti noodles and tomato sauce, served with garlic bread', 6)");
		statement.executeUpdate("insert into recipes values(43, 'Steak Fajitas', "
				+ "'Fajitas of steak, onion and bell pepper, served with sour cream and shredded "
				+ "cheese', 2)");
		statement.executeUpdate("insert into recipes values(44, 'Stuffed Shells', "
				+ "'Casserole of shells stuffed with ricotta, mozzarella, sauteed mushroom, onion, "
				+ "topped with tomato sauce', 7)");
		statement.executeUpdate("insert into recipes values(45, 'Taco Salad', "
				+ "'Ground beef with taco seasoning, lettuce, tomato, onion, sour cream and cheese, "
				+ "served over tortilla chips', 2)");
		statement.executeUpdate("insert into recipes values(46, 'Tater Tot Casserole', "
				+ "'Ground beef, cheddar cheese soup, golden mushroom soup and shredded chedder, "
				+ "over tater tots', 4)");
		
		// Populate Ingredients Table
		statement.executeUpdate("insert into ingredients values(1, 'Salsa', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(2, 'Tortilla Chips', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(3, 'Corn Chips', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(4, 'Snack Cakes', 'ALDI', 0)"); 
		statement.executeUpdate("insert into ingredients values(5,'Fruit Cups', 'ALDI', 0)"); 
		statement.executeUpdate("insert into ingredients values(6, 'Sliced Pickles', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(7, 'Yellow Mustard', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(8, 'Spicy Brown Mustard', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(9, 'Ketchup', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(10, 'Thousand Island Dressing', 'ALDI', 0)"); 
		statement.executeUpdate("insert into ingredients values(11, 'Mayonnaise', 'ALDI', 0)"); 
		statement.executeUpdate("insert into ingredients values(12, 'BBQ Sauce', 'ALDI', 0)"); 
		statement.executeUpdate("insert into ingredients values(13, 'Peanut Butter', 'ALDI', 0)"); 
		statement.executeUpdate("insert into ingredients values(14, 'Jelly', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(15, 'Pop Tarts', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(16, 'Garlic Salt', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(17, 'Garlic Powder', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(18, 'Onion Powder', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(19, 'Ground Cumin', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(20, 'Oregano', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(21, 'Parsley', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(22, 'Basil', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(23, 'Bay Leaves', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(24, 'Italian Seasoning', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(25, 'Red Pepper Flake', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(26, 'Salt', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(27, 'Olive Oil', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(28, 'Extra Virgin Olive oil', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(29, 'Vegetable Oil', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(30, 'Cooking Spray', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(31, 'Sugar', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(32, 'All Purpose Flour', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(33, 'Citrus Soda', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(34, 'Green Beans', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(35, 'Kernel Corn', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(36, 'Sweet Peas', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(37, 'Mushrooms', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(38, 'Tomatoes with Chilis', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(39, 'Diced Tomatoes', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(40, 'Tomato Sauce', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(41, 'Tomato Paste', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(42, 'Black Beans', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(43, 'Mixed Vegetables', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(44, 'Red Kidney Beans', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(45, 'Black Beans', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(46, 'Baby Potatoes', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(47, 'Shredded Mozzarella', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(48, 'Bacon', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(49, 'Hot Dogs', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(50, 'Block Cheddar', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(51, 'Sliced Swiss', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(52, 'Sliced Provolone', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(53, 'Corned Beef Brisket', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(54, 'Pork Tenderloin', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(55, 'Buttermilk Biscuits', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(56, 'Smoked Sausage', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(57, 'Pizza', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(58, 'Tissues', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(59, 'Toilet Paper', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(60, 'Plates', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(61, 'Paper Towels', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(62, 'Trash Bags', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(63, 'Laundry Detergent', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(64, 'Bleach', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(65, 'Dish Detergent', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(66, 'Dryer Sheets', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(67, 'Aluminum Foil', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(68, 'Chicken Salad Kits', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(69, 'Jambalaya', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(70, 'Strognaoff', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(71, 'Cheeseburger Mac', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(72, 'Boxed Lasagna', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(73, 'Instant Mashed Potatoes', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(74, 'Box Mac and Cheese', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(75, 'Egg Noodles', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(76, 'Spaghetti Pasta', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(77, 'Macaroni Pasta', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(78, 'Penne Pasta', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(79, 'Spaghetti Sauce', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(80, 'Dressing', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(81, 'Beef Stock', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(82, 'Beef Broth', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(83, 'Chicken Broth', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(84, 'Cream of Mushroom Soup', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(85, 'Tomato Soup', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(86, 'Canned Salmon', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(87, 'Canned Tuna', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(88, 'Sloppy Joe', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(89, 'Corned Beef Hash', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(90, 'Tater Tots', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(91, 'Seasoned Fries', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(92, 'Crinkle Cut Fries', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(93, 'Chicken Breast Strips', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(94, 'Battered Fish', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(95, 'Angus and Cheddar Burgers', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(96, 'Ground Beef', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(97, 'Hamburger Buns', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(98, 'Hot Dog Buns', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(99, 'Bread', 'ALDI', 0)");
		statement.executeUpdate("insert into ingredients values(100, 'Rye Bread', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(101, 'Bananas', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(102, 'Hot Sauce', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(103, 'Sliced Ham', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(104, 'Stew Beef', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(105, 'Beef Roast', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(106, 'Fajita Steak', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(107, 'Chicken Wings', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(108, 'Sliced Black Olive', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(109, 'Sauerkraut', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(110, 'Body Wash', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(111, 'Shampoo', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(112, 'Q-Tips', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(113, 'Ibuprofin', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(114, 'Boil in Bag Rice', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(115, 'Lasagna Pasta', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(116, 'Sardines', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(117, 'Whole Peppercorns', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(118, 'Potato Chips', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(119, 'Tortillas', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(120, 'Taco Seasoning', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(121, 'Fajita Seasoning', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(122, 'Enchilada Sauce (Red)', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(123, 'Enchilada Sauce (Green)', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(124, 'Snack Cakes', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(125, 'Coffee', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(126, 'Frozen Spinach', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(127, 'Garlic Bread', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(128, 'Texas Toast', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(129, 'Pizza Rolls', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(130, 'Jalapeno Poppers', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(131, 'Sour Cream', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(132, 'Shredded Cheddar', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(133, 'Shredded Taco Blend', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(134, 'Pork Fritters', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(135, 'Salisbury Steak Meals', 'SAVE A LOT', 0)");
		statement.executeUpdate("insert into ingredients values(136, 'Pepper Steaks', 'RADFORDS', 0)");
		statement.executeUpdate("insert into ingredients values(137, 'Ribeye Steaks', 'RADFORDS', 0)");
		statement.executeUpdate("insert into ingredients values(138, 'Meatloaf', 'RADFORDS', 0)");
		statement.executeUpdate("insert into ingredients values(139, 'Apples', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(140, 'Kiwi', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(141, 'Cuties', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(142, 'Lettuce', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(143, 'Cabbage', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(144, 'Bell Pepper', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(145, 'Lime', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(146, 'Minced Garlic', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(147, 'Tomato', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(148, 'Onion', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(149, 'Red Onion', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(150, 'Red Potatoes', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(151, 'Potatoes', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(152, 'Sweet Potatoes', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(153, 'Salads', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(154, 'Bag of Salad', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(155, 'Roast Kit', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(156, 'Chicken Breasts', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(157, 'Pork Chops', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(158, 'Fryer Chicken', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(159, 'Turkey Breast', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(160, 'Breakfast Sandwiches', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(161, 'Hoagie Buns', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(162, 'Decaf Instant Tea', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(163, 'Soy Sauce', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(164, 'Worchestershire Sauce', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(165, 'Tobasco Sauce', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(166, 'Cooked Pork', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(167, 'Cooked Chicken', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(168, 'Hot Dog Chili', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(169, 'Gravy mix', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(170, 'Onion Soup Mix', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(171, 'Corn Starch', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(172, 'Large Shells', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(173, 'Campbell Tomato Soup', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(174, 'Cheddar Cheese Soup', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(175, 'Golden Mushroom Soup', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(176, 'Sausage Log', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(177, 'Sausage Patties', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(178, 'American Cheese Singles', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(179, 'Sliced Corned Beef', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(180, 'Cornmeal', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(181, 'Couscous', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(182, 'Celery Salt', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(183, 'Coke', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(184, 'White Wine', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(185, 'Color Safe Bleach', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(186, 'Febreeze', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(187, 'Milk', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(188, 'Ricotta Cheese', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(189, 'Margarine', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(190, 'Butter', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(191, 'Eggs', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(192, 'Cat Litter', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(193, 'Litter Deodorizer', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(194, 'Cat Food', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(195, 'Tooth Stuff', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(196, 'Tooth Paste', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(197, 'Deodorant', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(198, 'Allergy Pills', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(199, 'Nose Spray', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(200, 'Baby Aspirin', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(201, 'Prescriptions', 'WALMART', 0)");
		statement.executeUpdate("insert into ingredients values(202, 'Herb Butter', 'JUNGLE JIMS', 0)");
		statement.executeUpdate("insert into ingredients values(203, 'Malt Vinegar', 'WALMART', 0)");
		
		// Populate Recipe Ingredients Table
		statement.executeUpdate("insert into recipeingredients values(1, 12, 1, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(2, 43, 1, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(3, 45, 1, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(4, 45, 2, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(5, 21, 3, 'Frito Pie')");
		statement.executeUpdate("insert into recipeingredients values(6, 18, 6, 'Cuban Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(7, 2, 7, 'BBQ Pork Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(8, 18, 7, 'Cuban Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(9, 18, 12, 'Cuban Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(10, 7, 34, 'Cheeseburger Mac')");
		statement.executeUpdate("insert into recipeingredients values(11, 20, 34, 'Fried Chicken')");
		statement.executeUpdate("insert into recipeingredients values(12, 29, 34, 'Meatloaf')");
		statement.executeUpdate("insert into recipeingredients values(13, 31, 34, 'Pepper Steaks')");
		statement.executeUpdate("insert into recipeingredients values(14, 34, 34, 'Pork Chops')");
		statement.executeUpdate("insert into recipeingredients values(15, 3, 35, 'Beef Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(16, 16, 35, 'Beef Stew')");
		statement.executeUpdate("insert into recipeingredients values(17, 41, 35, 'Shepherds Pie')");
		statement.executeUpdate("insert into recipeingredients values(18, 41, 36, 'Shepherds Pie')");
		statement.executeUpdate("insert into recipeingredients values(19, 3, 37, 'Beef Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(20, 7, 37, 'Cheeseburger Mac')");
		statement.executeUpdate("insert into recipeingredients values(21, 8, 37, 'Chicken Cacciatore')");
		statement.executeUpdate("insert into recipeingredients values(22, 22, 37, 'Garlic Chicken Pasta')");
		statement.executeUpdate("insert into recipeingredients values(23, 23, 37, 'Goulash')");
		statement.executeUpdate("insert into recipeingredients values(24, 26, 37, 'Box Lasagna')");
		statement.executeUpdate("insert into recipeingredients values(25, 27, 37, 'Macaroni Bake')");
		statement.executeUpdate("insert into recipeingredients values(26, 42, 37, 'Spaghetti')");
		statement.executeUpdate("insert into recipeingredients values(27, 44, 37, 'Stuffed Shells')");
		statement.executeUpdate("insert into recipeingredients values(28, 11, 38, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(29, 12, 38, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(30, 8, 39, 'Chicken Cacciatore')");
		statement.executeUpdate("insert into recipeingredients values(31, 11, 39, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(32, 23, 39, 'Goulash')");
		statement.executeUpdate("insert into recipeingredients values(33, 30, 39, 'Minestrone')");
		statement.executeUpdate("insert into recipeingredients values(34, 23, 40, 'Goulash')");
		statement.executeUpdate("insert into recipeingredients values(35, 23, 41, 'Goulash')");
		statement.executeUpdate("insert into recipeingredients values(36, 12, 42, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(37, 16, 43, 'Beef Stew')");
		statement.executeUpdate("insert into recipeingredients values(38, 28, 43, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(39, 30, 43, 'Minestrone')");
		statement.executeUpdate("insert into recipeingredients values(40, 36, 43, 'Pork Tenderloin')");
		statement.executeUpdate("insert into recipeingredients values(41, 11, 44, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(42, 11, 45, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(43, 12, 45, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(44, 16, 46, 'Beef Stew')");
		statement.executeUpdate("insert into recipeingredients values(45, 28, 47, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(46, 5, 48, 'BLTs')");
		statement.executeUpdate("insert into recipeingredients values(47, 13, 49, 'Coneys')");
		statement.executeUpdate("insert into recipeingredients values(48, 28, 50, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(49, 37, 51, 'Reuben Casserole')");
		statement.executeUpdate("insert into recipeingredients values(50, 17, 52, 'Meatball Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(51, 14, 53, 'Corned Beef and Cabbage')");
		statement.executeUpdate("insert into recipeingredients values(52, 36, 54, 'Pork Tenderloin')");
		statement.executeUpdate("insert into recipeingredients values(53, 4, 55, 'Biscuits and Gravy')");
		statement.executeUpdate("insert into recipeingredients values(54, 25, 56, 'Jambalaya')");
		statement.executeUpdate("insert into recipeingredients values(55, 32, 57, 'Pizza')");
		statement.executeUpdate("insert into recipeingredients values(56, 25, 69, 'Jambalaya')");
		statement.executeUpdate("insert into recipeingredients values(57, 3, 70, 'Beef Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(58, 7, 71, 'Cheeseburger Mac')");
		statement.executeUpdate("insert into recipeingredients values(59, 26, 72, 'Box Lasagna')");
		statement.executeUpdate("insert into recipeingredients values(60, 20, 73, 'Fried Chicken')");
		statement.executeUpdate("insert into recipeingredients values(61, 29, 73, 'Meatloaf')");
		statement.executeUpdate("insert into recipeingredients values(62, 41, 73, 'Shepherds Pie')");
		statement.executeUpdate("insert into recipeingredients values(63, 15, 75, 'Beef and Noodles')");
		statement.executeUpdate("insert into recipeingredients values(64, 42, 76, 'Spaghetti')");
		statement.executeUpdate("insert into recipeingredients values(65, 27, 77, 'Macaroni Bake')");
		statement.executeUpdate("insert into recipeingredients values(66, 22, 78, 'Garlic Chicken Pasta')");
		statement.executeUpdate("insert into recipeingredients values(67, 17, 79, 'Meatball Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(68, 27, 79, 'Macaroni Bake')");
		statement.executeUpdate("insert into recipeingredients values(69, 42, 79, 'Spaghetti')");
		statement.executeUpdate("insert into recipeingredients values(70, 36, 80, 'Pork Tenderloin')");
		statement.executeUpdate("insert into recipeingredients values(71, 30, 81, 'Minestrone')");
		statement.executeUpdate("insert into recipeingredients values(72, 15, 82, 'Beef and Noodles')");
		statement.executeUpdate("insert into recipeingredients values(73, 16, 82, 'Beef Stew')");
		statement.executeUpdate("insert into recipeingredients values(74, 39, 82, 'Roast Kit')");
		statement.executeUpdate("insert into recipeingredients values(75, 41, 82, 'Shepherds Pie')");
		statement.executeUpdate("insert into recipeingredients values(76, 8, 83, 'Chicken Cacciatore')");
		statement.executeUpdate("insert into recipeingredients values(77, 10, 84, 'Chicken Wine Bake')");
		statement.executeUpdate("insert into recipeingredients values(78, 33, 84, 'Poor Mans Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(79, 24, 85, 'Grilled Cheese')");
		statement.executeUpdate("insert into recipeingredients values(80, 40, 86, 'Salmon Patties')");
		statement.executeUpdate("insert into recipeingredients values(81, 2, 90, 'BBQ Pork Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(82, 46, 90, 'Tater Tot Casserole')");
		statement.executeUpdate("insert into recipeingredients values(83, 1, 91, 'Burgers and Fries')");
		statement.executeUpdate("insert into recipeingredients values(84, 19, 92, 'Fish and Chips')");
		statement.executeUpdate("insert into recipeingredients values(85, 22, 93, 'Garlic Chicken Pasta')");
		statement.executeUpdate("insert into recipeingredients values(86, 19, 94, 'Fish and Chips')");
		statement.executeUpdate("insert into recipeingredients values(87, 1, 95, 'Burgers and Fries')");
		statement.executeUpdate("insert into recipeingredients values(88, 3, 96, 'Beef Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(89, 7, 96, 'Cheeseburger Mac')");
		statement.executeUpdate("insert into recipeingredients values(90, 11, 96, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(91, 12, 96, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(92, 21, 96, 'Frito Pie')");
		statement.executeUpdate("insert into recipeingredients values(93, 23, 96, 'Goulash')");
		statement.executeUpdate("insert into recipeingredients values(94, 26, 96, 'Box Lasagna')");
		statement.executeUpdate("insert into recipeingredients values(95, 27, 96, 'Macaroni Bake')");
		statement.executeUpdate("insert into recipeingredients values(96, 28, 96, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(97, 30, 96, 'Minestrone')");
		statement.executeUpdate("insert into recipeingredients values(98, 33, 96, 'Poor Mans Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(99, 41, 96, 'Shepherds Pie')");
		statement.executeUpdate("insert into recipeingredients values(100, 42, 96, 'Spaghetti')");
		statement.executeUpdate("insert into recipeingredients values(101, 45, 96, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(102, 46, 96, 'Tater Tot Casserole')");
		statement.executeUpdate("insert into recipeingredients values(103, 1, 97, 'Burgers and Fries')");
		statement.executeUpdate("insert into recipeingredients values(104, 2, 97, 'BBQ Pork Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(105, 35, 97, 'Pork Fritter Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(106, 13, 98, 'Coneys')");
		statement.executeUpdate("insert into recipeingredients values(107, 5, 99, 'BLTs')");
		statement.executeUpdate("insert into recipeingredients values(108, 37, 100, 'Reuben Casserole')");
		statement.executeUpdate("insert into recipeingredients values(109, 18, 103, 'Cuban Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(110, 16, 104, 'Beef Stew')");
		statement.executeUpdate("insert into recipeingredients values(111, 15, 105, 'Beef and Noodles')");
		statement.executeUpdate("insert into recipeingredients values(112, 43, 106, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(113, 6, 107, 'Buffalo Wings')");
		statement.executeUpdate("insert into recipeingredients values(114, 12, 108, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(115, 43, 108, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(116, 45, 108, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(117, 37, 109, 'Reuben Casserole')");
		statement.executeUpdate("insert into recipeingredients values(118, 12, 114, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(119, 38, 114, 'Ribeye Stir Fry')");
		statement.executeUpdate("insert into recipeingredients values(120, 9, 119, 'Chicken Enchiladas')");
		statement.executeUpdate("insert into recipeingredients values(121, 43, 119, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(122, 12, 120, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(123, 45, 120, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(124, 43, 121, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(125, 9, 122, 'Chicken Enchiladas')");
		statement.executeUpdate("insert into recipeingredients values(126, 9, 123, 'Chicken Enchiladas')");
		statement.executeUpdate("insert into recipeingredients values(127, 44, 126, 'Stuffed Shells')");
		statement.executeUpdate("insert into recipeingredients values(128, 42, 127, 'Spaghetti')");
		statement.executeUpdate("insert into recipeingredients values(129, 26, 128, 'Box Lasagna')");
		statement.executeUpdate("insert into recipeingredients values(130, 9, 131, 'Chicken Enchiladas')");
		statement.executeUpdate("insert into recipeingredients values(131, 10, 131, 'Chicken Wine Bake')");
		statement.executeUpdate("insert into recipeingredients values(132, 12, 131, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(133, 33, 131, 'Poor Mans Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(134, 43, 131, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(135, 45, 131, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(136, 9, 132, 'Chicken Enchiladas')");
		statement.executeUpdate("insert into recipeingredients values(137, 13, 132, 'Coneys')");
		statement.executeUpdate("insert into recipeingredients values(138, 28, 132, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(139, 11, 133, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(140, 43, 133, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(141, 45, 133, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(142, 35, 134, 'Pork Fritter Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(143, 31, 136, 'Pepper Steaks')");
		statement.executeUpdate("insert into recipeingredients values(144, 38, 137, 'Ribeye Stir Fry')");
		statement.executeUpdate("insert into recipeingredients values(145, 17, 138, 'Meatball Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(146, 29, 138, 'Meatloaf')");
		statement.executeUpdate("insert into recipeingredients values(147, 1, 142, 'Burgers and Fries')");
		statement.executeUpdate("insert into recipeingredients values(148, 5, 142, 'BLTs')");
		statement.executeUpdate("insert into recipeingredients values(149, 12, 142, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(150, 43, 142, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(151, 45, 142, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(152, 14, 143, 'Corned Beef and Cabbage')");
		statement.executeUpdate("insert into recipeingredients values(153, 38, 144, 'Ribeye Stir Fry')");
		statement.executeUpdate("insert into recipeingredients values(154, 43, 144, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(155, 12, 145, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(156, 6, 146, 'Buffalo Wings')");
		statement.executeUpdate("insert into recipeingredients values(157, 8, 146, 'Chicken Cacciatore')");
		statement.executeUpdate("insert into recipeingredients values(158, 12, 146, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(159, 22, 146, 'Garlic Chicken Pasta')");
		statement.executeUpdate("insert into recipeingredients values(160, 28, 146, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(161, 30, 146, 'Minestrone')");
		statement.executeUpdate("insert into recipeingredients values(162, 42, 146, 'Spaghetti')");
		statement.executeUpdate("insert into recipeingredients values(163, 44, 146, 'Stuffed Shells')");
		statement.executeUpdate("insert into recipeingredients values(164, 1, 147, 'Burgers and Fries')");
		statement.executeUpdate("insert into recipeingredients values(165, 5, 147, 'BLTs')");
		statement.executeUpdate("insert into recipeingredients values(166, 8, 147, 'Chicken Cacciatore')");
		statement.executeUpdate("insert into recipeingredients values(167, 12, 147, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(168, 45, 147, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(169, 1, 148, 'Burgers and Fries')");
		statement.executeUpdate("insert into recipeingredients values(170, 9, 148, 'Chicken Enchiladas')");
		statement.executeUpdate("insert into recipeingredients values(171, 11, 148, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(172, 12, 148, 'Cinco de Mayo Skillet')");
		statement.executeUpdate("insert into recipeingredients values(173, 13, 148, 'Coneys')");
		statement.executeUpdate("insert into recipeingredients values(174, 21, 148, 'Frito Pie')");
		statement.executeUpdate("insert into recipeingredients values(175, 23, 148, 'Goulash')");
		statement.executeUpdate("insert into recipeingredients values(176, 28, 148, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(177, 30, 148, 'Minestrone')");
		statement.executeUpdate("insert into recipeingredients values(178, 35, 148, 'Pork Fritter Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(179, 38, 148, 'Ribeye Stir Fry')");
		statement.executeUpdate("insert into recipeingredients values(180, 40, 148, 'Salmon Patties')");
		statement.executeUpdate("insert into recipeingredients values(181, 43, 148, 'Steak Fajitas')");
		statement.executeUpdate("insert into recipeingredients values(182, 44, 148, 'Stuffed Shells')");
		statement.executeUpdate("insert into recipeingredients values(183, 45, 148, 'Taco Salad')");
		statement.executeUpdate("insert into recipeingredients values(184, 8, 149, 'Chicken Cacciatore')");
		statement.executeUpdate("insert into recipeingredients values(185, 14, 150, 'Corned Beef and Cabbage')");
		statement.executeUpdate("insert into recipeingredients values(186, 28, 151, 'Meal in Foil')");
		statement.executeUpdate("insert into recipeingredients values(187, 40, 151, 'Salmon Patties')");
		statement.executeUpdate("insert into recipeingredients values(188, 39, 155, 'Roast Kit')");
		statement.executeUpdate("insert into recipeingredients values(189, 8, 156, 'Chicken Cacciatore')");
		statement.executeUpdate("insert into recipeingredients values(190, 10, 156, 'Chicken Wine Bake')");
		statement.executeUpdate("insert into recipeingredients values(191, 34, 157, 'Pork Chops')");
		statement.executeUpdate("insert into recipeingredients values(192, 20, 158, 'Fried Chicken')");
		statement.executeUpdate("insert into recipeingredients values(193, 17, 161, 'Meatball Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(194, 18, 161, 'Cuban Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(195, 2, 166, 'BBQ Pork Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(196, 18, 166, 'Cuban Sandwiches')");
		statement.executeUpdate("insert into recipeingredients values(197, 9, 167, 'Chicken Enchiladas')");
		statement.executeUpdate("insert into recipeingredients values(198, 13, 168, 'Coneys')");
		statement.executeUpdate("insert into recipeingredients values(199, 15, 170, 'Beef and Noodles')");
		statement.executeUpdate("insert into recipeingredients values(200, 44, 172, 'Stuffed Shells')");
		statement.executeUpdate("insert into recipeingredients values(201, 11, 173, 'Chili')");
		statement.executeUpdate("insert into recipeingredients values(202, 21, 173, 'Frito Pie')");
		statement.executeUpdate("insert into recipeingredients values(203, 46, 174, 'Tater Tot Casserole')");
		statement.executeUpdate("insert into recipeingredients values(204, 46, 175, 'Tater Tot Casserole')");
		statement.executeUpdate("insert into recipeingredients values(205, 24, 178, 'Grilled Cheese')");
		statement.executeUpdate("insert into recipeingredients values(206, 37, 179, 'Reuben Casserole')");
		statement.executeUpdate("insert into recipeingredients values(207, 31, 181, 'Pepper Steaks')");
		statement.executeUpdate("insert into recipeingredients values(208, 10, 184, 'Chicken Wine Bake')");
		statement.executeUpdate("insert into recipeingredients values(209, 3, 187, 'Beef Stroganoff')");
		statement.executeUpdate("insert into recipeingredients values(210, 4, 187, 'Biscuits and Gravy')");
		statement.executeUpdate("insert into recipeingredients values(211, 7, 187, 'Cheeseburger Mac')");
		statement.executeUpdate("insert into recipeingredients values(212, 26, 187, 'Box Lasagna')");
		statement.executeUpdate("insert into recipeingredients values(213, 44, 188, 'Stuffed Shells')");
		statement.executeUpdate("insert into recipeingredients values(214, 10, 202, 'Chicken Wine Bake')");
	}
}
