package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.EmployeDAO;
import com.app.dao.PlaceOrderDAO;
import com.app.dao.ProductsDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.EmployeDAOImpl;
import com.app.dao.impl.PlaceOrderImpl;
import com.app.dao.impl.ProductsDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.PlaceOrder;
import com.app.model.Products;
import com.app.model.Temp;
import com.app.service.valid.EmployeService;
import com.app.service.valid.EmployeValid;
import com.app.service.valid.LoginValidation;
import com.app.service.valid.PlaceOrderService;
import com.app.service.valid.impl.EmployeServiceImpl;
import com.app.service.valid.impl.EmployeValidImpl;
import com.app.service.valid.impl.LoginValidationImpl;
import com.app.service.valid.impl.PlaceOrderServiceImpl;

public class Main {
	public static int cid = 0;
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws BusinessException {
		final int empid = 999;
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			log.info("Welcome to Mithra Online Shopping portal");
			log.info("==========================================");
			log.info("***********PLEASE LOGIN ******************");
			log.info("____________________________");
			log.info("|1.Employee login           |");
			log.info("|2.Customer login           |");
			log.info("|3.NewUser? signup!         |");
			log.info("|4.Exit                     |");
			log.info("|___________________________|");
			log.info("Enter Ur Choice");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.warn(e);
			}
			switch (ch) {
			case 1:
				int j = 0, eid = 0;
				log.info("Enter employee id:");
				eid = Integer.parseInt(sc.nextLine());
				if (empid == eid) {
					log.info("Welcome to Online shopping portal");
					do {
						log.info("____________________________");
						log.info("|                           |");
						log.info("|1.Add products             |");
						log.info("|2.view products            |");
						log.info("|3.Order Status             |");
						log.info("|4.Update Cost              |");
						log.info("|5.Exit                     |");
						log.info("|___________________________|");
						log.info("Enter Ur Choice");
						j = Integer.parseInt(sc.nextLine());
						switch (j) {
						case 1:
							ProductsDAO pp = new ProductsDAOImpl();
							Products p = new Products();
							log.info("Add products ");
							log.info("Enter product id");
							p.setPid(Integer.parseInt(sc.nextLine()));
							log.info("Enter product name");
							p.setPname(sc.nextLine());
							log.info("Enter product cost");
							p.setCost(Integer.parseInt(sc.nextLine()));
							int l = pp.insertIntoProducts(p);
							if (l == 1) {
								log.info("Product added successfully");
							} else {
								log.info("Failed in adding product");
							}
							break;
						case 2:
							log.info(" Displaying details of all products");
							List<Products> product = new ArrayList();
							ProductsDAO pd = new ProductsDAOImpl();
							product = pd.getAllProducts();
							for (Products i : product) {
								log.info(i);
							}
							int kli = 0;
							do {
								log.info("______________________________________");
								log.info("|                                        |");
								log.info("|1.Search product  by Name               |");
								log.info("|2.Search product by id                  |");
								log.info("|3.Exit                                  |");
								log.info("|________________________________________|");
								log.info("Enter Ur Choice");
								kli = Integer.parseInt(sc.nextLine());
								switch (kli) {
								case 1:
									EmployeService lkm = new EmployeServiceImpl();
									List<Products> lpm = new ArrayList();
									log.info("Enter product name :");
									String name = sc.nextLine();
									lpm = lkm.getProductByName(name);
									if (lpm != null && lpm.size() > 0) {
										for (Products i : lpm) {
											log.info(i);
										}
									} else {
										log.info("NO product found with this name...Try again");
									}

									break;
								case 2:
									EmployeService lm = new EmployeServiceImpl();
									List<Products> llm = new ArrayList();
									log.info("Enter product id :");
									int id = Integer.parseInt(sc.nextLine());
									llm = lm.getProductById(id);
									if (llm != null && llm.size() > 0) {
										for (Products i : llm) {
											log.info(i);
										}
									} else {
										log.info("NO product found with this name...Try again");
									}

									break;
								default:
									log.warn(
											"Invalid Search Option... Choice should be only number between 1-3only. Kindly Retry ");
									break;

								}
							} while (kli != 3);
							break;
						case 3:
							log.info("Displaying all the orders:");
							List<PlaceOrder> orders = new ArrayList();
							PlaceOrderDAO pad = new PlaceOrderImpl();
							orders = pad.displayOrders();
							for (PlaceOrder i : orders) {
								log.info(i);
							}
							int opt = 0;
							do {
								log.info("______________________________________");
								log.info("|                                        |");
								log.info("|1.Mark order as shipped                 |");
								log.info("|2.View orders Which are delivered       |");
								log.info("|3.Exit                                  |");
								log.info("|________________________________________|");
								log.info("Enter Ur Choice");
								opt = Integer.parseInt(sc.nextLine());
								switch (opt) {
								case 1:
									log.info("Enter oid that need to be marked as shipped");
									int shp = Integer.parseInt(sc.nextLine());
									EmployeValid ev = new EmployeValidImpl();
									ev.isValidOid(shp);

									break;
								case 2:
									log.info("Products that are delivered successfully:");
									EmployeDAO edao = new EmployeDAOImpl();
									List<PlaceOrder> lpo = new ArrayList();
									lpo = edao.ordersReceivedByCustomer();
									for (PlaceOrder i : lpo) {
										log.info("orderId= " + i.getOid() + " productId= " + i.getPid()
												+ " productName " + i.getPname() + " totalCost " + i.getCost()
												+ " has been delivered to the address " + i.isOrderReceived()
												+ " successfulyy");
									}
									break;
								case 3:
									log.info("Returning to main menu:");
								default:
									log.warn(
											"Invalid Search Option... Choice should be only number between 1-3only. Kindly Retry ");
									break;
								}
							} while (opt != 3);

							break;

						case 4:log.info("Enter the id of product to be updated:");
						       int pid=Integer.parseInt(sc.nextLine());
						       log.info("Enter the revised cost");
						       double cost=Double.parseDouble(sc.nextLine());
						       EmployeService edo=new EmployeServiceImpl();
						       edo.updateCost(pid, cost);
							
							break;
						case 5 :
							log.info("Returning to main menu:");
							break;
						default:
							log.info(
									"Invalid search option... Choice should be only number between 1-3only. Kindly Retry");
							break;

						}

					} while (j != 5);

				} else {
					log.info("Invalid login id,Access denied ");
				}

				break;
			case 2:
				log.info("Enter email id:");
				String email = sc.nextLine();
				LoginValidation a = new LoginValidationImpl();
				Customer customer1 = new Customer();
				try {
					customer1 = a.isValidUser(email);
					cid = customer1.getCid();
					String d = customer1.getPassword();
				} catch (NullPointerException e) {
					log.warn("Invalid email id,retry:");
					break;
				}
				log.info("Enter password:");
				String pass = sc.nextLine();

				if (customer1.getPassword().equals(pass)) {
					log.info("Successfully signed in");
					log.info("Welcome " + customer1.getCname());
					int opti = 0;
					do {
						log.info("____________________________");
						log.info("|                           |");
						log.info("|1.View Products            |");
						log.info("|2.View Orders              |");
						log.info("|3.Mark product as received |");
						log.info("|4.Exit                     |");
						log.info("|___________________________|");
						log.info("Enter Ur Choice");
						try {
							opti = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							log.warn(e);
						}

						switch (opti) {
						case 1:
							log.info(" Displaying details of all products");
							List<Products> product = new ArrayList();
							ProductsDAO pd = new ProductsDAOImpl();
							product = pd.getAllProducts();
							for (Products i : product) {
								log.info(i);
							}
							int z = 0;

							do {
								log.info("____________________________");
								log.info("|                           |");
								log.info("|1.Add products to Cart     |");
								log.info("|2.view cart                |");
								log.info("|3.Place order              |");
								log.info("|4.Exit                     |");
								log.info("|___________________________|");
								log.info("Enter Ur Choice");
								try {
									z = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									log.warn(e);
								}
								switch (z) {
								case 1:
									log.info("Adding products to cart:");
									log.info("Enter id of product to be added in cart:");
									int id = Integer.parseInt(sc.nextLine());
									Products product2 = new Products();
									ProductsDAO pd1 = new ProductsDAOImpl();
									product2 = pd1.getProductById(id);
									log.info("Enter qunatity:");
									int quantity = Integer.parseInt(sc.nextLine());

									CartDAO cd = new CartDAOImpl();
									int g = cd.addToCart(cid, product2.getPid(), quantity);
									if (g == 1) {
										log.info("product " + product2.getPname() + " is added is cart !!");
									} else {
										log.warn("Failed to add product,some internal error occured");
									}

									break;
								case 2:
									CartDAO dd = new CartDAOImpl();
									List<Temp> products = dd.getAllItemsInCart(cid);
									if (products != null && products.size() > 0) {
										log.info("Items in the cart:");
										for (Temp i : products) {
											log.info(i);
										}
									} else {
										log.info("OOPS!! seem's like ur cart is empty.Keep shopping");
									}
									break;
								case 3:CartDAO ca = new CartDAOImpl();
								List<Temp> products3 = new ArrayList();
								products3 = ca.getAllItemsInCart(cid);
									 PlaceOrderService pkk=new PlaceOrderServiceImpl();
									 double n=pkk.placingOrder(products3,cid);
									if (n != 0) {
										log.info("placing ur order");
										log.info("Total cost:" + n);
										ca.deleteCartById(cid);
									} else {
										log.info("No tems in ur cart!keep shopping !!");
									}
									break;
								case 4:
									log.info("Returning to main menu");
									break;
								default:
									log.warn(
											"Invalid Search Option... Choice should be only number between 1-4only. Kindly Retry ");
									break;
								}

							} while (z != 4);
							break;
						case 2:
							List<PlaceOrder> po = new ArrayList();
							PlaceOrderDAO kk = new PlaceOrderImpl();
							po = kk.getOrdersById(cid);
							if (po.size() > 0 && po != null) {
								log.info("Displaying orders:");
								for (PlaceOrder i : po) {
									log.info(i);
								}
							} else {
								log.info("U have not placed any orders yet.Continue shopping to place");
							}

							break;
						case 3:
							String mark = "true";
							log.info("enter id of order to be marked as received");
							int oid = Integer.parseInt(sc.nextLine());
							PlaceOrderDAO placeorder = new PlaceOrderImpl();
							String op = placeorder.isOrderShipped(oid);
							if (op.equals(mark)) {
								int x = placeorder.markOrderReceive(oid);
								if (x == 1) {
									log.info("order with id " + oid + " has been marked received successfully");
								} else {
									log.info("Failed to mark it,some internal error occur");
								}
							} else {
								log.info("Oops the order is not yet shipped!! Try again");
							}
							break;
						case 4:
							log.info("Returning to main :");

							break;
						default:
							log.warn(
									"Invalid Search Option... Choice should be only number between 1-4only. Kindly Retry ");
							break;
						}

					} while (opti != 4);

				} else {
					log.info("Entered password was wrong!Re-enter");
				}

				break;
			case 3:
				LoginValidation lv = new LoginValidationImpl();
				log.info("Welocme new user,signup :");
				Customer customer = new Customer();
				log.info("enter customer id:");
				customer.setCid(Integer.parseInt(sc.nextLine()));
				log.info("enter customer Name:");
				customer.setCname(sc.nextLine());
				log.info("enter EMail id:");
				customer.setEmailid(sc.nextLine());
				log.info("enter correct password:");
				customer.setPassword(sc.nextLine());
				log.info("enter contact number:");
				customer.setContact(Long.parseLong(sc.nextLine()));
				log.info("enter customer address:");
				customer.setAddress(sc.nextLine());
				CustomerDAO customerdao = new CustomerDAOImpl();
				int k = lv.isValidLogin(customer);

				break;
			case 4:
				log.info("Logging off:");

				break;

			default:
				log.warn("Invalid Search Option... Choice should be only number between 1-4only. Kindly Retry ");
				break;

			}

		} while (ch != 4);

	}
}
