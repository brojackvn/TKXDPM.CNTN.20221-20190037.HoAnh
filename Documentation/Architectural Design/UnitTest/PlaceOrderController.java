import common.exception.InvalidDeliveryInfoException;
import entity.cart.*;
import entity.invoice.*;
import entity.order.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import views.screen.popup.PopupScreen;

/**
 * Place order flow controller
 * @author anh.h190037
 */
public class PlaceOrderController extends BaseController {

  public void placeOrder() throws SQLException {
    Cart.getCart().checkAvailabilityOfProduct();
  }

  /**
   * This method creates the new Order based on the Cart
   * @return Order
   * @throws SQLException
   */
  public Order createOrder() throws SQLException {
    Order order = new Order();
    ArrayList<CartMedia> cartMedias = (CartMedia) Cart.getCart().getListMedia()
    cartMedias.forEach(
      cartMedia -> order.getlstOrderMedia().add(
        new OrderMedia(
            cartMedia.getMedia(),
            cartMedia.getQuantity(),
            cartMedia.getPrice()
          );
      );
    );
    return order;
  }

  public Invoice createInvoice(Order order) {
    return new Invoice(order);
  }

  /**
   * This method takes responsibility for processing the shipping info from user
   * @param info
   * @throws InterruptedException
   * @throws IOException
   */
  public void processDeliveryInfo(HashMap info)
    throws InterruptedException, IOException {
    validateDeliveryInfo(info);
  }

    public boolean validatePhoneNumber(String phoneNumber) {
    	if (phoneNumber == null ||phoneNumber.length() != 10) return false;
        if (!phoneNumber.startsWith("0")) return false;
        
        try {
        	Integer.parseInt(phoneNumber);
        } catch (Exception e) {
			// TODO: handle exception
        	return false;
		}
        return true;
  }
  
  public int calculateShippingFee(Order order) {
    int fees = (int) order.getAmount();
    return fees;
  }

  public boolean validateName(String name) {
    if (name == null) {
      return false;
    }
    return name.matches("^[A-Za-z]+$");
  }

  public boolean validateAddress(String address) {
    if (address == null) {
      return false;
    }
    return address.matches("^[A-Za-z0-9]+");
  }

  public void validateDeliveryInfo(HashMap<String, String> info)
    throws InterruptedException, IOException {}

  public boolean @CsvSource({
            "1 Dai Co Viet,true",
            "8/115 Dai Co Viet,true",
            ",false"
    })@CsvSource({
            "1 Dai Co Viet,true",
            "8/115 Dai Co Viet,true",
            ",false"
    })(String phoneNumber) {
    if (phoneNumber.length() != 10) {
      return false;
    }
    if (!phoneNumber.startsWith("0")) {
      return false;
    }
    try {
      Integer.parseInt(phoneNumber);
    } catch (InvalidDeliveryInfoException e) {
      return false;
    }
    return true;
  }
}
