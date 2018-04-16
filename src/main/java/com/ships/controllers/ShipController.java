import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.services.ShipService;

@Controller
public class ShipController {
	@Autowired
	ShipService s;
	

	@RequestMapping(value = "/getShip", method=RequestMethod.GET)
	public String getShip(Model model) {
		ArrayList<Ship> ship = (ArrayList<Ship>) s.getAllShips();
		model.addAttribute("customers", ship);
		Ship s = new Ship();
		s.setScid("TESTING");
		model.addAttribute("cust", s);
		return "allShips";
	}

}