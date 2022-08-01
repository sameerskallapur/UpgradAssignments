import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.ordermanagement.dto.Address;
import com.ordermanagement.dto.OrderLine;
import com.ordermanagement.statusEnum.OrderLineStatus;

public class ApplicationMain {

	public static void main(String[] args) {
		
		Address add1 = new Address();
		add1.setCity("Blr");
		add1.setCountry("India");
		add1.setPincode("123");
		
		OrderLine oLine1 = new OrderLine("laptop", 20000, 2, getDate("31/03/2022") ,OrderLineStatus.OPEN .toString());
		System.out.println(oLine1.getEta());
		
		
	}
	
	
	public static Date getDate(String dateAsString) {
		  Date date = null;
		  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			try {
				date = formatter.parse(dateAsString);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
			return date;
	}
}

