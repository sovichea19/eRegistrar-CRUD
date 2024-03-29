package edu.mum.cs.cs425.eregistrarcrudweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.eregistrarcrudweb.model.Student;
import edu.mum.cs.cs425.eregistrarcrudweb.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = {"/eregistrar/students/list"})
    public ModelAndView ListBooks(@RequestParam(defaultValue = "0") int pageNum){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudentsPaged(pageNum));
        modelAndView.addObject("currentPageNum", pageNum);
        modelAndView.setViewName("students/list");
        return modelAndView;
        
        

    }

    @GetMapping(value = {"/eregistrar/students/new", "eregistrar/students/new"})
    public String displayNewStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "students/new";
    }

    @PostMapping(value = {"/eregistrar/students/new","eregistrar/students/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "students/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/students/list";
    }
    
    //Delete Student
    @GetMapping(value = {"/eregistrar/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model) {
    	studentService.deleteStudentById(studentId);
    	return "redirect:/eregistrar/students/list";
    }
    
    //Edit Student GET
	@GetMapping(value = {"/eregistrar/students/edit/{studentId}"})
    public String editBook(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "students/edit";
        }
        return "students/list";
    }

    @PostMapping(value = {"/eregistrar/students/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "students/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/students/list";
    }

}