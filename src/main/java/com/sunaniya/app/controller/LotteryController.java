package com.sunaniya.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunaniya.app.model.Lottery;
import com.sunaniya.app.model.User;
import com.sunaniya.app.model.UserForm;
import com.sunaniya.app.repository.LotteryRepository;
import com.sunaniya.app.repository.UserRepository;
import com.sunaniya.app.validators.UserValidator;

@Controller
public class LotteryController {
   
	
	@Autowired
    private UserRepository userRepository;

	@Autowired
	private LotteryRepository lotteryRepository;
	
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User user = new User();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setMobileNumber(userForm.getMobileNumber());
        user.setEmailId(userForm.getEmailId());
        user.setAddress1(userForm.getAddress1());
        user.setAddress2(userForm.getAddress2());
        user.setCity(userForm.getCity());
        user.setState(userForm.getState());
        user.setPincode(userForm.getPincode());
        user.setCreatedDate(new Date());
        
        User savedUser = userRepository.save(user);
        userForm.setId(savedUser.getId());

        List<Lottery> lotteryList = lotteryRepository.findByAllotted(false, new PageRequest(1, 100));
        model.addAttribute("userForm", userForm);
        model.addAttribute("lotteryList", lotteryList);
        
        return "selectLottery";
    }

    @RequestMapping(value="/filterLotteryNumbers", method = RequestMethod.GET)
    @ResponseBody
    public List<Lottery> filterLotteryNumbers(@RequestParam("start") String starting, 
    		@RequestParam("end") String ending, Model model) {
    	
         return lotteryRepository.findByAllottedAndLotteryNumberContaining(false, starting, ending);
    }
    
    
    @Value("${costOfLottery}")
    private String costOfLottery;
    
    @RequestMapping(value="/selectLotteryNumbers", method = RequestMethod.POST)
    public void selectLottery(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
    	System.out.println(userForm);
    	
    	//Validate user data
    	if(userForm.getMobileNumber() == null || userForm.getEmailId().isEmpty()) {
    		//invalid way to post data
    		
    	}
    	    	
    	//calculate payment amount
    	int amountToPay = Integer.valueOf(costOfLottery)*userForm.getSelectedLotteries().size();
    	System.out.println(amountToPay);
    	//redirect to payment gateway screen
    	
    	//if successful payment then send email or message
    	
    	//save user lottery mapping in database
    	Set<Lottery> lotteries = new HashSet<>();
    	for(String lotteryNumbers : userForm.getSelectedLotteries()) {
    		Lottery l = lotteryRepository.getOne(Long.valueOf(lotteryNumbers));
    		if(null != l) {
    			lotteries.add(l);
    		}
    	}
    	User user = userRepository.findOne(userForm.getId());
    	user.setLotteries(lotteries);
    	userRepository.save(user);
    	
    	//update lottery status
    	for(Lottery allottedLottery : lotteries) {
    		allottedLottery.setAllotted(true);
    		lotteryRepository.save(allottedLottery);
    	}
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @Value("${lotteryPrefix}")
    private String lotteryPrefix;
    
    @Value("${staringNumber}")
    private String staringNumber;
    
    @Value("${endingNumber}")
    private String endingNumber;
    
    @Value("${limitOfLotteriesToSaveAtOnce}")
    private String limitOfLotteriesToSaveAtOnce;
    
    @RequestMapping(value = {"/loadLotteryNumbers"}, method = RequestMethod.GET)
    public void loadLotteryNumbersInDb(HttpServletResponse response) throws IOException {
    	
    	List<Lottery> lotteries = new ArrayList<>();
    	for(int i = Integer.valueOf(staringNumber); i < Integer.valueOf(endingNumber); i++) {
    		Lottery lottery = new Lottery(lotteryPrefix+i, false, "GENERATED");
    		lotteries.add(lottery);
    		if(Integer.valueOf(limitOfLotteriesToSaveAtOnce) == lotteries.size()) {
    			System.out.println("Saving Lottery Numbers...");
    			lotteryRepository.save(lotteries);
    			lotteries = new ArrayList<>();
    		}
    	}
    	
    	response.getWriter().write("Lottery Numbers generated");
    }
    
    
    @Value("${numberOfPrize}")
    private String numberOfPrize;
    
    
    @RequestMapping(value = {"/generatePrize"}, method = RequestMethod.GET)
    public void generatePrize(HttpServletResponse response) throws IOException {
    	
    	List<Lottery> lotteries = lotteryRepository.findAll();
    	
    	//write logic for prize generation
    	
    	response.getWriter().write("Lottery Numbers generated");
    }
    

}
