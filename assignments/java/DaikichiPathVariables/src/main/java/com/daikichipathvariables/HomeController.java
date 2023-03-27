package com.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/daikichi/travel/{city}")
	public String index(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to" + " " + city;
	}
	
	@RequestMapping("/daikichi/lotto/{lottoNumber}")
	public String lotto(@PathVariable("lottoNumber") Integer lottoNumber) {
		if(lottoNumber % 2 == 0) {
			return "You will take a grand journey in the future, but beware tempting offers.";
		}else {
			return "You have enjoyed the great fruits of your labor, but now is time to spend with family and friends.";
		}
	}
}
