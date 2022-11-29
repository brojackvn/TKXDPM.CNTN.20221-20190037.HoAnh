package controller;

import entity.cart.*;
import entity.order.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Place rush order flow controller
 * @author anh.h190037
 */
public class PlaceRushOrderController extends PlaceOrderController {

  public boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false; 
    }
    return pattern.matcher(strNum).matches();
  }

  public boolean validateExpectedTime(String expectedTime) {
    return expectedTime.matches("^[0-9]+/[0-9]+/[0-9]+ [0-9]+:[0-9]+:[0-9]+$");
  }
  
  public boolean validateRushDeliveryDay(String duration) {
    int d;
    if(isNumeric(duration) == false) return false;
    else Integer.parseInt(duration);
    if (d < 1 || d > 10) return false;
    return true;
  }

  public int calculateShippingFee(Order order, String deliveryDay) {
    Random rand = new Random();
    int fees = (int) order.getAmount();
    int additionalFee = (int) (
      ((rand.nextFloat() * 10) / 100) * (20 - Integer.parseInt(deliveryDay))
    );
    fees += additionalFee;
    return fees;
  }
}
