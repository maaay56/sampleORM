package jp.co.springframework.controller;

import java.util.List;

import jp.co.springframework.dao.Test;
import jp.co.springframework.dao.TestDao;
import jp.co.springframework.dao.TestDaoImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
	public String test(@ModelAttribute("test") Test test, Model model) {

        TestDao<Test> dao = new TestDaoImpl();
        List<Test> list = dao.getAll();
        model.addAttribute("datalist", list);
        test.setId(list.get(list.size()-1).getId()+1);
		test.setName("");

        model.addAttribute("test", test);

        return "showMessage";
	}

    @RequestMapping(method = RequestMethod.POST)
    public String form(@ModelAttribute("test") Test test,Model model) {

    	 TestDao<Test> dao = new TestDaoImpl();
         dao.add(test);


        return "redirect:/test";
	}

}
